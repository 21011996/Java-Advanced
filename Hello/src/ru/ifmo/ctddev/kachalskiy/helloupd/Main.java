package ru.ifmo.ctddev.kachalskiy.helloupd;

/**
 * Created by Илья on 21.05.2015.
 */
public class Main {
    final private static int port = 8888;
    final private static int workers = 5;
    final private static int threads = 2;
    final private static int requests = 3;
    final private static String prefix = "hello";

    public static void main(String[] args){
        HelloUDPClient client = new HelloUDPClient();
        HelloUDPServer server = new HelloUDPServer();
        server.start(port, workers);
        client.start("localhost",port,prefix,threads,requests);
        server.close();
    }
}
