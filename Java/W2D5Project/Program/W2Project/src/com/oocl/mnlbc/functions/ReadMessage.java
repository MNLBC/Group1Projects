package com.oocl.mnlbc.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Class that allows clients to read message.
 * 
 * @author Group 1
 *
 */
public class ReadMessage extends Thread {
	private Socket socket;

	/**
	 * Instantiates the ReadMessage class, accepts sockets that will be given
	 * the read capabilities.
	 * 
	 * @param socket
	 *            Connects server and client.
	 */
	public ReadMessage(Socket socket) {
		this.socket = socket;
	}

	/**
	 * 
	 * Runs the Read Message class.
	 * 
	 */
	public void run() {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = null;
			while (true) {
				message = reader.readLine();
				if (message.equalsIgnoreCase("#disconnect")) {
					break;
				}
				System.out.println(message);
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
