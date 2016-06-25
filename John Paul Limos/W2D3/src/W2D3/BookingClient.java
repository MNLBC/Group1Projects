package W2D3;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class BookingClient {
	private String ipAdress;

	public BookingClient(String ipAString) {
		this.ipAdress = ipAdress;
	}

	public void startWork() throws UnknownHostException, IOException {
		Socket socket = new Socket(ipAdress, 2345);
		new ReadMes(socket).start();
		new SendMes(socket).start();
		
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		BookingClient bookingClient = new BookingClient(args[0]);
		bookingClient.startWork();
	}

}