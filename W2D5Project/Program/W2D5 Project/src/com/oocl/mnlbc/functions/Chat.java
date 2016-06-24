package com.oocl.mnlbc.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Chat extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private int ctr;
	
	public Chat(Socket socket, List<Socket> socketList, int ctr) {
		this.socket = socket;
		this.socketList = socketList;
		this.ctr = ctr;
	}
	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = null;
			while(true){
				
				writer.println("Enter message: " );
				message = reader.readLine();
				if (message.equalsIgnoreCase("#Disconnect")){
					writer.flush();
					continue;
				}
				
				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i)
							.getOutputStream());
					writer.println(ctr + ": " + message);
					writer.flush();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
