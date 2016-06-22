package com.oocl.mnlbc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	
	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2345);
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		
		Ticket ticket = new Ticket(500);
		int count = 0;
		while (true) {
			socket = serverSocket.accept();
			count++;
			System.out.println(count + " clinet connected to the server!");
			socketList.add(socket);
			new Booking(ticket,count, socket, socketList).start();
		}
	}
	
	 public static void main(String[] args) throws IOException {
		 Server server = new Server();
		 server.startWork();
	}
}
