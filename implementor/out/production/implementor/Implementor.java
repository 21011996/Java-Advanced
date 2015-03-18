package ru.ifmo.ctddev.kachalskiy.implementor;

import info.kgeorgiy.java.advanced.implementor.Impler;
import info.kgeorgiy.java.advanced.implementor.ImplerException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilya Kachaslkiy
 *
 * This class implements interface, prob. will create jar file.
 */

public class Implementor implements Impler {

    /**
     * StringBuilder used as container for implementation.
     */
    private StringBuilder sb;
    /**
     * List contains all methods from file given.
     */
    private List<Method> allMethods;

    /**
     * Empty constructor.
     */
    public Implementor() {
        sb = new StringBuilder();
        allMethods = new ArrayList<>();
    }

    /**
     * Main method. Starts implementation of file given.
     * @param args args[0] - contains path to file to implement.
     * @throws info.kgeorgiy.java.advanced.implementor.ImplerException when implementation cannot be started.
     * @see java.lang.String
     */
    public static void main(String args[]) throws ImplerException {
        try {
            Implementor implementor = new Implementor();
            implementor.implement(Class.forName(args[0]), new File(args[1]));
        } catch (Exception e) {
        	System.err.println(e.toString());
        }
    }

    /**
     * Based on <tt>token</tt> type creates file with implementation <tt>Impl.java</tt> or trows error.
     * @param token based on type implementation will be created.
     * @param root root directory of file given.
     * @throws info.kgeorgiy.java.advanced.implementor.ImplerException if unable to create implementation.
     * @see java.io.File
     * @see java.lang.Class
     * @see java.lang.String
     */
    public void implement(Class<?> token, File root) throws ImplerException {
        if (token.isPrimitive()) {
            throw new ImplerException();
        }
        try {
            String path = root.getCanonicalPath() + "/" + token.getPackage().getName().replaceAll("\\.", "/");
            File file = new File(path);
            file.mkdirs();
            try (FileWriter fileWriter = new FileWriter(path + "/" + token.getSimpleName() + "Impl.java")) {
                printClass(token);

                fileWriter.append(sb.toString());
                sb.delete(0, sb.length());
                allMethods.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Input/Output error");
        }
    }

    /**
     * Prints all basic information such as package name, class name and calls {@link #printMethods(java.lang.Class) printMethods}.
     * @param token contains all basic information needed.
     * @throws info.kgeorgiy.java.advanced.implementor.ImplerException if unable to create implementation.
     * @see java.lang.Class
     * @see java.lang.StringBuilder
     */
    private void printClass(Class<?> token) throws ImplerException {
        sb.append("package " + token.getPackage().getName() + ";\n\n");
        sb.append("public class " + token.getSimpleName() + "Impl ");
        sb.append("implements " + token.getCanonicalName());
        sb.append(" {\n");
        printMethods(token);
        sb.append("\n}");
    }

    /**
     * Prints all methods by collecting them with {@link #collectAllMethods(java.lang.Class) collectAllMethods} and printing them with {@link #printMethod(java.lang.reflect.Method) printMethod}.
     * @param token contains all basic information needed.
     * @see java.lang.Class
     */
    private void printMethods(Class<?> token) {
        collectAllMethods(token);
        for (int i = 0; i < allMethods.size(); i++) {
            printMethod(allMethods.get(i));
        }
    }

    /**
     * Prints implementation of method by calling {@link #getReturnValue(java.lang.reflect.Method) getReturnValue} and {@link #getArgs(java.lang.reflect.Method) getArgs}.
     * {@link #printMethod(java.lang.reflect.Method) printMethod} ignores Abstract Methods.
     * @param method will be printed.
     * @see java.lang.reflect.Method
     * @see java.lang.String
     */
    private void printMethod(Method method) {
        int modifiers = method.getModifiers();
        if (!Modifier.isAbstract(modifiers)) {
            return;
        }
        sb.append("\n" + "    " + "@Override");
        modifiers ^= Modifier.ABSTRACT;
        
        if (Modifier.isTransient(modifiers)) {
            modifiers ^= Modifier.TRANSIENT;
        }
        sb.append("\n");
        sb.append("    ");
        sb.append(Modifier.toString(modifiers) + " " +
                method.getReturnType().getCanonicalName() + " " +
                method.getName() +
                "(" + getArgs(method) + ")" +
                " { return " + getReturnValue(method) + "; }\n");
    }

    /**
     * Returns default return value based on type of <tt>method</tt> given.
     * @param method defines return type.
     * @return default return.
     * @see java.lang.String
     */
    private String getReturnValue(Method method) {
        Class<?> returnValue = method.getReturnType();
        if (!returnValue.isPrimitive()) {
            return "null";
        } else {
            if ("char".equals(returnValue.getSimpleName())) {
                return "'0'";
            }
            if ("boolean".equals(returnValue.getSimpleName())) {
                return "false";
            }
            if (!"void".equals(returnValue.getSimpleName())) {
                return "0";
            }
            return "";
        }
    }

    /**
     * Provides <tt>String</tt> of arguments of given <tt>Method</tt>.
     * @param method provides arguments.
     * @return String of arguments in format "type1 arg1, type2 arg2, ...".
     * @see java.lang.reflect.Method
     * @see java.lang.StringBuilder
     */
    private String getArgs(Method method) {
        StringBuilder ans = new StringBuilder();
        Class<?>[] parameters = method.getParameterTypes();
        for (int i = 0; i < parameters.length; i++) {
            if (i == parameters.length - 1) {
                ans.append(parameters[i].getCanonicalName() + " args" + i);
            } else {
                ans.append(parameters[i].getCanonicalName() + " args" + i + ", ");
            }
        }
        return ans.toString();
    }

    /**
     * Calls {@link #collectAllMethods(java.lang.Class) collectAllMethods} recursively in order to collect all methods.
     * Also calls {@link #addAllMethods(java.lang.Class) addAllMethods} in order to store all Methods.
     * @param token Class to collect Methods.
     * @see java.lang.Class
     * @see java.lang.reflect.Method
     */
    private void collectAllMethods(Class<?> token) {
        if (token == null) {
            return;
        }
        addAllMethods(token);
        Class[] interfaces = token.getInterfaces();
        for (Class i : interfaces) {
            collectAllMethods(i);
        }
        collectAllMethods(token.getSuperclass());
    }

    /**
     * Stores all methods in List.
     * Ignores stored methods with {@link #equalMethod(java.lang.reflect.Method,java.lang.reflect.Method) equalMethod}.
     * @param token Class to store Methods.
     * @see java.lang.Class
     * @see java.lang.reflect.Method
     */
    private void addAllMethods(Class<?> token) {
        Method[] methods = token.getDeclaredMethods();
        for (Method method : methods) {
            boolean flag = false;
            for (int i = 0; i < allMethods.size(); i++) {
                if (equalMethod(method, allMethods.get(i))) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                allMethods.add(method);
            }
        }
    }

    /**
     * Compares 2 Methods given for equality.
     * @param a first Method to compare.
     * @param b second Method to compare.
     * @return <tt>boolean</tt>.
     */
    private boolean equalMethod(Method a, Method b) {
        if (!a.getName().equals(b.getName())) {
            return false;
        }
        Class[] paramTypesA = a.getParameterTypes();
        Class[] paramTypesB = b.getParameterTypes();
        if (paramTypesA.length != paramTypesB.length) {
            return false;
        }
        for (int i = 0; i < paramTypesA.length; i++) {
            if (!(paramTypesA[i].getCanonicalName()).equals(paramTypesB[i].getCanonicalName())) {
                return false;
            }
        }
        return true;
    }
}