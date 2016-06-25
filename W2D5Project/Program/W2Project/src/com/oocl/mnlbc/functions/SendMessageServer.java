package com.oocl.mnlbc.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import com.oocl.mnlbc.model.Account;

public class SendMessageServer extends Thread {
	private Socket socket;
	private List<Account> acc;

	public SendMessageServer(Socket socket, List<Account> acc) {
		this.socket = socket;
		this.acc = acc;
	}

	public void run() {
		BufferedReader reader = null;
		try {
			String message = null;
			reader = new BufferedReader(new InputStreamReader(System.in));
			new PrintWriter(socket.getOutputStream());
			while (true) {
				message = reader.readLine();
				if (message.equalsIgnoreCase("#showactive")) {
					showActive();
				}
				// writer.println("send"+message);
				// writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void showActive() {
		if (acc.size() > 0) {
			System.out.println("Active Users");
			for (Account account : acc) {
				System.out.println(account.getName());
			}
		}else{
			System.out.println("No active user yet.");
		}
	}
}
