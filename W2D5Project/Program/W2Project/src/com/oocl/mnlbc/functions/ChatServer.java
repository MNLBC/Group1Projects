package com.oocl.mnlbc.functions;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.dao.CommandDAOImpl;
import com.oocl.mnlbc.model.Account;

/**
 * 
 * @author Group 1
 *
 */

public class ChatServer {

	/**
	 * 
	 * @throws IOException
	 */

	public void startWork() throws IOException {

		ServerSocket serverSocket = new ServerSocket(123);
		List<Socket> socketList = new ArrayList<Socket>();
		List<Account> acc = new ArrayList<Account>();
		CommandDAOImpl daoImpl = new CommandDAOImpl();
		Socket socket = null;
		int ctr = 0;
		while (true) {
			socket = serverSocket.accept();
			ctr++;
			// System.out.println(ctr + " joined the chat");
			
			new Chat(socket, socketList, ctr, acc, daoImpl).start();
		}
	}

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ChatServer server = new ChatServer();
		server.startWork();
	}

}
