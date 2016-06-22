package com.oocl.mnlbc;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	private String ipAdress;

	public Client(String ipAString) {
		this.ipAdress = ipAdress;
	}

	public void startWork() throws UnknownHostException, IOException {
		Socket socket = new Socket(ipAdress, 2345);
		new ReadMes(socket).start();
		new SendMes(socket).start();
		
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Client chatClient = new Client(args[0]);
		chatClient.startWork();
	}
}
