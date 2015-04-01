package ru.ifmo.ctddev.kachalskiy.iterativeparallelism;

import java.util.function.Function;

/**
 * Created by Ilya on 01.04.15.
 */
class Task<T, R> {

    private T argument;
    private Function<? super T, ? extends R> function;
    private R result;

    Task(T argument, Function<? super T, ? extends R> function) {
        this.argument = argument;
        this.function = function;
    }

    public synchronized void process() {
        result = function.apply(argument);
        //Notify about ending of task
        notifyAll();
    }

    public synchronized R getResult() throws InterruptedException {
        while (result == null) {
            wait();
        }
        return result;
    }

}