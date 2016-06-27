package com.oocl.mnlbc.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * Class that gives sockets capabilities to send messages.
 * 
 * @author Group 1
 *
 */
public class SendMessage extends Thread {
	private Socket socket;

	/**
	 * Constructor for the Send Message class. Instantiates the socket to be
	 * used.
	 * 
	 * @param socket
	 *            Connects server and client.
	 */
	public SendMessage(Socket socket) {
		this.socket = socket;
	}

	/**
	 * 
	 * Runs the Send Message class.
	 * 
	 */
	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		Chat chat;
		try {
			String message = null;
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(socket.getOutputStream());
			while (true) {
				message = reader.readLine();
				if (message.equalsIgnoreCase("#disconnect")) {
				}
				writer.println(message);
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
