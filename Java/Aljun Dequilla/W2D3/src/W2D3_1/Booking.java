package W2D3_1;

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
			
			while (true) {
				PrintWriter printwriter = new PrintWriter(socket.getOutputStream(),true);
				printwriter.println("Enter number of tickets: ");
				int t = Integer.parseInt(reader.readLine());
				if (t<1) {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println("bye");
					writer.flush();
					continue;
				}
				// Print all the message to all clients, Group chat
				ticket.setTickets(ticket.getTickets() - t);
				int i = 0;
				for (i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i).getOutputStream());
					writer.println("Client #" + count + " has booked " + t + " ticket(s). Tickets remaining: " + ticket.getTickets());
					writer.flush();
				}

				System.out.println("Client #" + i + " booked " + t + " tickets. Tickets Left: " + this.ticket.getTickets());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
