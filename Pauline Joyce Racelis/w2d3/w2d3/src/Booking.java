import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
* 
*/
class Booking extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private int count;
	Ticket ticket;

	// private int ticket;
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
				// Client will quit if client send "bye", and print "bye" to in
				// the client
				if (message.equals("bye")) {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println("bye");
					writer.flush();
					System.exit(1);
					continue;
				}
				if (Integer.parseInt(message) <= ticket.getNumberOfTickets()) {
					ticket.setNumberOfTickets(ticket.getNumberOfTickets() - Integer.parseInt(message));
					// Print all the message to all clients, Group chat
					for (int i = 0; i < socketList.size(); i++) {
						writer = new PrintWriter(socketList.get(i).getOutputStream());
						writer.println("Number of available tickets: " + ticket.getNumberOfTickets());
						writer.flush();
					}
				} else {
					for (int i = 0; i < socketList.size(); i++) {
						writer = new PrintWriter(socketList.get(i).getOutputStream());
						writer.println("Sorry! No available tickets.");
						writer.flush();
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}