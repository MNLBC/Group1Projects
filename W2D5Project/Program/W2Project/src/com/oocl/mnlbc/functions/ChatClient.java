package com.oocl.mnlbc.functions;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The client that will be run to join the chat.
 * 
 * @author Group 1
 *
 */
public class ChatClient {
	private String ip;

	/**
	 * Constructor of ChatClient Class
	 * 
	 * @param ip
	 */
	public ChatClient(String ip) {
		this.ip = ip;
	}

	/**
	 * Starts the ReadMessage and SendMessage class. Allows the start of the
	 * chat by giving the connected sockets the read and send abilities.
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void startWork() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, 123);
		new ReadMessage(socket).start();
		new SendMessage(socket).start();
	}

	/**
	 * Main method for the ChatClient class.
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient client = new ChatClient("127.0.0.1");
		client.startWork();
	}

}
