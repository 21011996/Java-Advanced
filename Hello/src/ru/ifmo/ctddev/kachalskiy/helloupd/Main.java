package ru.ifmo.ctddev.kachalskiy.helloupd;

import java.io.UnsupportedEncodingException;

/**
 * Created by Илья on 21.05.2015.
 */
public class Main {
    private static int port = 8888;
    final private static int port2 = 1111;
    final private static int workers = 5;
    final private static String prefix = "ya ne Vadim, ya Sasha";

    public static void main(String[] args){
        HelloUDPClient client = new HelloUDPClient();
        HelloUDPServer server = new HelloUDPServer();
        for (int i=1; i<2; i++) {
            port = port2*i;
            server.start(port, workers);
            client.start("localhost", port, "доска", i, i*2);
            server.close();
        }
        String ochen = "aaaaaa";
        try {
            byte[] ghal = ochen.getBytes("UTF-8");
            System.out.println(new String(ghal));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
