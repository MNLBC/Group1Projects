package HomeWork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BookingServer{

	Booking b = new Booking(0, null, null,null);
	
	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2345);
		Ticket ticket = new Ticket(500);
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		int count = 0;
		while (true) {
			socket = serverSocket.accept();
			count++;
			// Add any connected client to the server
			socketList.add(socket);
			// Will open a new thread to process, once a new client connected.
			new Booking(count, socket, socketList,ticket).start();
		}
	}

	public static void main(String args[]) throws IOException {
		BookingServer chatServer = new BookingServer();
		chatServer.startWork();
	}

}
