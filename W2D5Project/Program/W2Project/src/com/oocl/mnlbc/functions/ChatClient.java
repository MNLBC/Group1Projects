package com.oocl.mnlbc.functions;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	private String ip;
	
	public ChatClient(String ip) {
		this.ip = ip;
	}

	public void startWork() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, 123);
		new ReadMessage(socket).start();
		new SendMessage(socket).start();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient client = new ChatClient(args[0]);
		client.startWork();
	}

}
