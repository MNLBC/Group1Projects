package W2D3;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BookingServer {

	/**
	 * Description
	 * 
	 * @param args
	 */


	public void startWork() throws IOException {
		int ticket = 500;
		ServerSocket serverSocket = new ServerSocket(2345);
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		Ticket tick = new Ticket(500);
		int count = 0;
		while (true) {
			socket = serverSocket.accept();
			count++;
			System.out.println(count + " clinet connected to the server!");
			// Add any connected client to the server
			socketList.add(socket);
			// Will open a new thread to process, once a new client connected.
			Booking c = new Booking(count, socket, socketList, tick);
			c.start();
		}
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		BookingServer bookServer = new BookingServer();
		bookServer.startWork();
	}

}