package com.oocl.mnlbc.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReadMessage extends Thread{
	private Socket socket;

	public ReadMessage(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = null;
			while(true){
				message = reader.readLine();
				if (message.equalsIgnoreCase("#Disconnect")){
					break;
				}
				System.out.println(message);
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

}
