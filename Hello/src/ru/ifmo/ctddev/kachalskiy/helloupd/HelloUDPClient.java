package ru.ifmo.ctddev.kachalskiy.helloupd;

import info.kgeorgiy.java.advanced.hello.HelloClient;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Ilya
 *
 * This class implements client: sends packets to the server, accept the results and display them to the console.
 * @see HelloClient
 */

public class HelloUDPClient implements HelloClient {
    private static final long TERMINATION_TIME_OUT = 10;
    private static final int SOCKET_TIMEOUT = 50;

    /**
     * Method to start sending requests.
     *
     * @param url      address to send requests to
     * @param port     port to connect to
     * @param prefix   the prefix of the request
     * @param requests number of the requests per thread
     * @param threads  number of the threads to send requests from
     * @see ExecutorService
     * @see InetAddress
     * @see DatagramSocket
     * @see DatagramPacket
     */
    @Override
    public void start(String url, int port, String prefix, int requests, int threads) {
        ExecutorService service = Executors.newFixedThreadPool(threads);
        try {
            InetAddress address = InetAddress.getByName(url);
            for (int i = 0; i < threads; i++) {
                final int threadId = i;
                service.submit(() -> {
                    try (DatagramSocket socket = new DatagramSocket()) {
                        socket.setSoTimeout(SOCKET_TIMEOUT);
                        for (int requestId = 0; requestId < requests; requestId++) {
                            String request = prefix + threadId + "_" + requestId;
                            DatagramPacket sendingPacket =
                                    new DatagramPacket(request.getBytes(), request.getBytes().length, address, port);
                            DatagramPacket receivedPacket = new DatagramPacket(new byte[socket.getReceiveBufferSize()], socket.getReceiveBufferSize());
                            String required = "Hello, " + request;
                            String received = "";
                            while (!required.equals(received)) {
                                try {
                                    socket.send(sendingPacket);
                                    socket.receive(receivedPacket);
                                    received = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                                } catch (IOException e) {
                                }
                            }
                        }
                    } catch (SocketException e) {
                    }
                });
            }

            service.shutdownNow();
            service.awaitTermination(TERMINATION_TIME_OUT, TimeUnit.SECONDS);
        } catch (UnknownHostException e) {
            System.err.println(e.toString());
        } catch (InterruptedException e) {
        }
    }
}