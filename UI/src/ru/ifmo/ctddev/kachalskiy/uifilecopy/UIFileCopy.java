package ru.ifmo.ctddev.kachalskiy.uifilecopy;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.Objects;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Created by Ilya on 13.05.2015.
 */
public class UIFileCopy extends JPanel implements ActionListener,PropertyChangeListener {

    private JProgressBar progressBar;
    private JButton cancelButton;
    private JLabel elapsedTime;
    private JLabel remainingTime;
    private JLabel averageSpeed;
    private JLabel nowSpeed;
    private JLabel currentFile;
    private Task task;
    private File from;
    private File to;
    private boolean stop=false;

    class Task extends SwingWorker<Void, Void> {
        @Override
        public Void doInBackground() {
            long size = folderGetSize(from);
            setProgress(0);
            int progress = 0;
            long speed = 0;
            long avspeed = 0;
            long started = System.currentTimeMillis();
            long remaining = 0;
            long readed = 0;
            int write=0;


            for (File file : from.listFiles()) {
                if (file.isFile()){
                    InputStream is = null;
                    OutputStream os = null;
                    try {
                        currentFile.setText(file.getName());
                        long shutter=System.currentTimeMillis();
                        long readed2=0;
                        is = new FileInputStream(file);
                        os = new FileOutputStream(to+"/"+file.getName());
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) > 0) {
                            if (stop) {
                                return null;
                            }
                            os.write(buffer, 0, length);
                            readed+=length;
                            readed2+=length;

                            if (System.currentTimeMillis()-shutter>10) {
                                speed = (readed2) / (System.currentTimeMillis() - shutter + 1);
                                write = (int)(speed*0.000122);
                                nowSpeed.setText(""+write+" Mbit/second");
                                shutter=System.currentTimeMillis();
                                readed2=0;
                            }

                            write = (int)(System.currentTimeMillis() - started)/1000;
                            elapsedTime.setText(""+write+" seconds");

                            avspeed = readed / (System.currentTimeMillis() - started + 1);
                            write = (int)(avspeed*0.000122);
                            averageSpeed.setText(""+write+" Mbit/second");

                            remaining =(size - readed) / avspeed;
                            write = (int)(remaining/1000);
                            remainingTime.setText(""+write+" seconds");

                            progress = (int) ((readed * 100 / size));
                            progressBar.setValue(progress);
                        }
                        progress = (int) ((readed * 100 / size));
                        progressBar.setValue(progress);
                        is.close();
                        os.close();
                    } catch (IOException e) {}
                }
            }
            return null;
        }

        @Override
        public void done(){
            if (!stop) {
                progressBar.setString("100%");

            } else {
                progressBar.setString("Stoped at " + progressBar.getString());
            }
        }
    }

    public UIFileCopy(File from, File to) {
        super(new BorderLayout());
        this.from = from;
        this.to = to;

        cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);

        TitledBorder titledBorder = new TitledBorder("Progress");
        titledBorder.setTitlePosition(TitledBorder.TOP);
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBorder(titledBorder);

        currentFile = new JLabel();
        currentFile.setText("");
        currentFile.setBorder(new TitledBorder("Current file"));
        currentFile.setHorizontalAlignment(SwingConstants.CENTER);

        elapsedTime = new JLabel();
        elapsedTime.setText("0");
        elapsedTime.setBorder(new TitledBorder("Elapsed time"));
        elapsedTime.setHorizontalAlignment(SwingConstants.CENTER);
        remainingTime = new JLabel();
        remainingTime.setText("1");
        remainingTime.setBorder(new TitledBorder("Rem. time"));
        remainingTime.setHorizontalAlignment(SwingConstants.CENTER);
        averageSpeed = new JLabel();
        averageSpeed.setText("2");
        averageSpeed.setBorder(new TitledBorder("Av. speed"));
        averageSpeed.setHorizontalAlignment(SwingConstants.CENTER);
        nowSpeed = new JLabel();
        nowSpeed.setText("3");
        nowSpeed.setBorder(new TitledBorder("Curr. speed"));
        nowSpeed.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10,0));

        panel.add(progressBar,BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4,1,20,10));
        panel2.add(elapsedTime);
        panel2.add(remainingTime);
        panel2.add(averageSpeed);
        panel2.add(nowSpeed);
        panel.add(cancelButton,BorderLayout.SOUTH);
        panel.add(currentFile,BorderLayout.NORTH);

        panel.add(panel2,BorderLayout.WEST);

        add(panel, BorderLayout.CENTER);

        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
    }

    public void actionPerformed(ActionEvent evt) {
        cancelButton.setEnabled(false);
        stop=true;

    }

    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);

        }
    }

    public static void createGUI(File from, File to){
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {}
        JFrame frame = new JFrame("Copying files");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new UIFileCopy(from,to);
        newContentPane.setOpaque(true);
        JPanel cheat = new JPanel(new BorderLayout(5,5));

        cheat.add(new JLabel(""),BorderLayout.NORTH);
        cheat.add(new JLabel(""),BorderLayout.SOUTH);
        cheat.add(new JLabel(""),BorderLayout.WEST);
        cheat.add(new JLabel(""),BorderLayout.EAST);
        cheat.add(newContentPane,BorderLayout.CENTER);
        frame.setContentPane(cheat);
        frame.setPreferredSize(new Dimension(600, 350));
        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String[] args){
        if (args.length != 2) {
            return;
        }
        final File from = new File(args[0]);
        final File to = new File(args[1]);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI(from,to);
            }
        });

        /*long size = folderGetSize(from);
        float progres = 0;
        long speed = 0;
        long avspeed = 0;
        long elapsed = System.currentTimeMillis();
        long remaining = 0;
        long readed = 0;


        for (File file : from.listFiles()) {
            if (file.isFile()){
                InputStream is = null;
                OutputStream os = null;
                try {
                    long shutter = System.currentTimeMillis();
                    is = new FileInputStream(file);
                    os = new FileOutputStream(to+"/"+file.getName()+(remaining));
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                        readed+=length;
                    }
                    progres=readed/size;
                    speed=length/(System.currentTimeMillis()-shutter+1);
                    shutter=System.currentTimeMillis();
                    avspeed=readed/(shutter-elapsed+1);
                    remaining=(size-readed)/avspeed;
                    is.close();
                    os.close();
                } catch (IOException e) {}
            }
        }*/
    }



    private static long folderGetSize(File from){
        long length = 0;
        for (File file : from.listFiles()) {
            if (file.isFile()){
                length += file.length();
            } else {
                //length += folderGetSize(file);
            }
        }
        return length;
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
