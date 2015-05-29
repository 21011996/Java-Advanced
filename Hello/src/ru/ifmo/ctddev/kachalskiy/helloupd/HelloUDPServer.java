package ru.ifmo.ctddev.kachalskiy.helloupd;

import info.kgeorgiy.java.advanced.hello.HelloServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Server that receives request, processes them and sends responses.
 * Server will reply to every request if the number of threads it is working on allows.
 * The reply will be {@code "Hello, " + received}, where "receive" is the string representation of the request.
 * <p>
 * Server can be created from the command line with two parameters:
 * port and number of threads.
 * <p>
 * Server is started with the method {@code start}.
 * <p>
 * To use method start user has to provide two integers - port and threads' number.
 * <p>
 * Server can be started several times on different ports.
 * <p>
 * To close the server there is the method {@code close}.
 *
 * @author Ilya
 * @see HelloServer
 */

public class HelloUDPServer implements HelloServer {
	private ExecutorService service;
	private DatagramSocket receivingSocket;

	/**
     * Method to start server with the given parameters
     *
     * @param port    number of the port to start server on
     * @param threads number of threads to process requests on
     * @see ExecutorService
     * @see DatagramSocket
     * @see DatagramPacket
     */
    @Override
	public void start(int port, int threads) {
		service = Executors.newFixedThreadPool(threads);
		try {
			receivingSocket = new DatagramSocket(port);
			for (int i = 0; i < threads; i++) {
				service.submit(() -> {
					try (DatagramSocket sendingSocket = new DatagramSocket()) {
						DatagramPacket receivingPacket = new DatagramPacket(
								new byte[sendingSocket.getReceiveBufferSize()], sendingSocket.getReceiveBufferSize());
						while (!Thread.interrupted()
								&& !receivingSocket.isClosed()) {
							receivingSocket.receive(receivingPacket);
							String received = new String(receivingPacket
									.getData(), 0, receivingPacket.getLength());
							String sending = "Hello, " + received;
                            byte[] arr = sending.getBytes("UTF-8");
                            sending = new String(arr);
							//System.out.println(sending);
							sendingSocket.send(new DatagramPacket(sending
									.getBytes(), sending.getBytes().length,
									receivingPacket.getAddress(),
									receivingPacket.getPort()));
						}
					} catch (IOException e) {
					}
				});
			}
		} catch (SocketException e) {
			System.err.println(e.toString());
		}
	}

	@Override
	public void close() {
		service.shutdown();
		try {
			service.awaitTermination(1, TimeUnit.SECONDS);
			service.shutdownNow();
		} catch (InterruptedException e) {
		}
		if (receivingSocket != null && !receivingSocket.isClosed()) {
			receivingSocket.close();
		}
	}
}