package W2D3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 	
 */
class Booking extends Thread {
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
		int numOfTickets = 0;
		Scanner input = new Scanner(System.in);

		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String message = null;
			while (true) {
				PrintWriter  pw = new PrintWriter(socket.getOutputStream(),true);
				pw.println("Insert number of tickets to book: ");
				message = reader.readLine();
				// Client will quit if client send "bye", and print "bye" to in the client
				if (message.equals("bye")) {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println("bye");
					writer.flush();
					continue;
				}


				// Print all the message to all clients, Group chat
				ticket.setTickets(ticket.getTickets() - Integer.parseInt(message));
				int i = 0;
				for (i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i)
							.getOutputStream());
					writer.println("Client " + count + " booked " + message+" ticket/s. Tickets remaining: " + ticket.getTickets());
					writer.flush();
				}
				
				System.out.println("Client " + i + " booked "+message+" tickets. Tickets Left: " + this.ticket.getTickets());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}