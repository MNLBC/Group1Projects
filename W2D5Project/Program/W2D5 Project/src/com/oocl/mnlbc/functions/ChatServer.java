package com.oocl.mnlbc.functions;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer {

	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(123);
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		int ctr = 0;
		while(true){
			socket = serverSocket.accept();
			ctr++;
			System.out.println(ctr + " joined the chat");
			socketList.add(socket);
			new Chat(socket, socketList, ctr).start();
		}
	}
	public static void main(String[] args) throws IOException {
		ChatServer server = new ChatServer();
		server.startWork();
	}

}
