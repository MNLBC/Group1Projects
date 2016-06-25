package com.oocl.mnlbc.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.oocl.mnlbc.dao.CommandDAOImpl;
import com.oocl.mnlbc.model.Account;
import com.oocl.mnlbc.model.Logs;

public class Chat extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private List<Account> accList;
	private int ctr;
	private CommandDAOImpl daoImpl;

	public Chat(Socket socket, List<Socket> socketList, int ctr, List<Account> acc, CommandDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
		this.socket = socket;
		this.socketList = socketList;
		this.ctr = ctr;
		this.accList = acc;
	}

	public void run() {
		BufferedReader reader = null;
		Scanner scanServer = null;
		PrintWriter writer = null;
		Account acc = null;
		
		try {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

			PrintWriter printServer = new PrintWriter(System.out, true);

			// readerServer = new BufferedReader(new
			// InputStreamReader(System.in));

			printWriter.println("------------------------");
			printWriter.println("WELCOME TO THE CHAT ROOM");
			printWriter.println("------------------------");
			printWriter.println("Enter desired name: ");

			// while (true) {
//			scanServer = new Scanner(System.in);
//			String msgServer = scanServer.nextLine().trim();// .readLine().trim();
//			if (msgServer.equalsIgnoreCase("#showactive")) {
////				showActive(printServer);
//				System.out.println("HOY");
//			}
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if (acc==null) {
				String name =  showIntro(printWriter, reader);
				acc = new Account(name);
				// this.addLogToDb(joinChatLog);
				// DBConnect.insert(new Logs(joinChatLog));
				accList.add(acc);
			}
			// Scanner sc = new Scanner(System.in);
			while (true) {
				// String serverInput = sc.nextLine();
				// System.out.println(serverInput);

				String message = reader.readLine().trim();
				if (message.equalsIgnoreCase("#disconnect")) {
					String disconnectLog = acc.getName() + " left the group chat";
					System.out.println(disconnectLog);
					// addLogToDb(disconnectLog);
					return;
					// writer = new PrintWriter(socket.getOutputStream());
					// writer.flush();
					// continue;
				}

				if (message.startsWith("#")) {
					determineCmd(message, acc, printWriter);
					printWriter.flush();
					continue;
				}

				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i).getOutputStream());
					writer.println(acc.getName() + ": " + message);
					String sendMessageLog = (acc.getName() + " sent a message");
					if (i == 0) {
						System.out.println(sendMessageLog);
					}
					writer.flush();
				}
				printWriter.flush();

				// }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void determineCmd(String message, Account acc, PrintWriter printWriter) {
		String cmd = message.substring(1);
		int cmdLen = cmd.split("\\s").length;
		String commandLog = "";
		if (cmdLen == 1) {
			if (cmd.equalsIgnoreCase("help")) {
				commandLog = acc.getName() + " used help command";
				System.out.println(commandLog);
				showHelpList(printWriter);
			} else if (cmd.equalsIgnoreCase("showactive")) {
				commandLog = acc.getName() + " used show active users command";
				System.out.println(commandLog);
				showActive(printWriter);
			} else if (cmd.equalsIgnoreCase("history")) {
				commandLog = acc.getName() + " used show history command";
				printWriter.println("History :}");
				System.out.println(commandLog);
			}
		} else if (cmdLen == 3) {
			String[] cmdAr = cmd.split("\\s");
			if (cmdAr[0].equalsIgnoreCase("history")) {
				if (cmdAr[1].equalsIgnoreCase("from")) {
					printWriter.println(cmdAr[2]);
					commandLog = acc.getName() + " used show history command. View from " + cmdAr[2];
					System.out.println(commandLog);
				}
			}
		} else if (cmdLen == 5) {
			String[] cmdAr = cmd.split("\\s");
			if (cmdAr[0].equalsIgnoreCase("history")) {
				if (cmdAr[1].equalsIgnoreCase("from") && cmdAr[3].equalsIgnoreCase("to")) {
					printWriter.println(cmdAr[2] + " " + cmdAr[4]);
					commandLog = acc.getName() + " used history command. View from " + cmdAr[2] + " to " + cmdAr[4];
					System.out.println(commandLog);
				}
			}
		}
		// addLogToDb(commandLog);
	}

	private String showIntro(PrintWriter printWriter, BufferedReader reader) throws IOException {
		String name = reader.readLine();
		printWriter.println("Start chatting!");
		String joinChatLog = name + " joined the chat!";
		System.out.println(joinChatLog);
		return name;
	}

	private void addLogToDb(String logInsert) {
		try {
			this.daoImpl.insert(new Logs(logInsert));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void showActive(PrintWriter printWriter) {
		printWriter.println("Active Users");
		for (Account account : accList) {
			printWriter.println(account.getName());
		}
	}

	private void showHelpList(PrintWriter printWriter) {
		printWriter.println("All command lines will start with number sign(#).");
		printWriter.println();
		printWriter.println("#disconnect\t\t-leave the chat");
		printWriter.println("#help\t\t-shows the list of all commands");
		printWriter.println("#history\t\t-shows the chat history for today");
		printWriter.println("#history from <date>\t\t-shows the chat history from the date to the current date");
		printWriter.println(
				"#history from <start date> to <end date>\t\t-shows the chat history from the start date to end date");
		printWriter.println("#showactive\t\t-shows the current active chat members");
		printWriter.println();
		printWriter.println();
	}
}
