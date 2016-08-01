package com.oocl.mnlbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Booking extends Thread{
	private Socket socket;
	private List<Socket> socketList;
	private int count;
	private Ticket ticket;

	public Booking(Ticket ticket,int count, Socket socket, List<Socket> socketList) {
		this.ticket = ticket;
		this.count = count;
		this.socket = socket;
		this.socketList = socketList;
	}

	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String message = null;
			while (true) {
				message = reader.readLine();
				if (message.equals("bye")) {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println("bye");
					writer.flush();
					continue;
				}

				for (int i = 0; i < socketList.size(); i++) {
					ticket.setRemaining(ticket.getRemaining() - 1);
					writer = new PrintWriter(socketList.get(i)
							.getOutputStream());
					writer.println("Ticket is now " + ticket.getRemaining());
					writer.flush();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
