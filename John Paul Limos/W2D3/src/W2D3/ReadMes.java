package W2D3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ���ܷ�������Ϣ
 */
class ReadMes extends Thread {
	private Socket socket;

	public ReadMes(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String message = null;
			while (true) {
				message = reader.readLine();
				// ������������Ϣ�߳̽��յ�bye�����߳��˳�
				if (message.equals("bye")) {
					break;
				}
				System.out.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}