package W2D3_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class BookingServer {

	/**
	 * Description
	 * 
	 * @param args
	 */

	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2345);
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		Ticket ticket = new Ticket(500);
		int count = 0;
		while (true) {
			socket = serverSocket.accept();
			count++;
			System.out.println("Client #" + count +" connected to the server!");
			// Add any connected client to the server
			socketList.add(socket);
			// Will open a new thread to process, once a new client connected.
			Booking book = new Booking(count, socket, socketList, ticket);
			book.start();
		}
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		BookingServer server = new BookingServer();
		server.startWork();
	}

}
