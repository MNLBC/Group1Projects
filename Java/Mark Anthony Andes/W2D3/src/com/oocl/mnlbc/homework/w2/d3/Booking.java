package com.oocl.mnlbc.homework.w2.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Booking extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private int count;
	Ticket ticket;

	public Booking(int count, Socket socket, List<Socket> socketList, Ticket ticket) {
		this.count = count;
		this.socket = socket;
		this.socketList = socketList;
		this.ticket = ticket;
	}

	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String message = null;
			while (true) {
				message = reader.readLine();
				// Client will quit if client send "close", and print "close" to in
				if (message.equals("close")) {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println("close");
					writer.flush();
					continue;
				}
				int inputTicket = Integer.parseInt(message);
				ticket.setTicket(ticket.getTicket() - inputTicket);
				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i).getOutputStream());
					writer.println("Tickets Left: " + ticket.getTicket());
					writer.flush();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
