package com.oocl.mnlbc.functions;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
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
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient client = new ChatClient("10.222.29.148"); //Change for terminal IP address
		client.startWork();
	}

}
