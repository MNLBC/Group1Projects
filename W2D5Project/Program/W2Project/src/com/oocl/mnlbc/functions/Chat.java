package com.oocl.mnlbc.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.oocl.mnlbc.dao.CommandDAOImpl;
import com.oocl.mnlbc.db.DBConnect;
import com.oocl.mnlbc.model.Account;
import com.oocl.mnlbc.model.History;
import com.oocl.mnlbc.model.Logs;

/**
 * 
 * @author Group 1
 *
 */
public class Chat extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private List<Account> accList;
	private int ctr;
	private CommandDAOImpl daoImpl;

	/**
	 * 
	 * @param socket
	 * @param socketList
	 * @param ctr
	 * @param acc
	 * @param daoImpl
	 */
	public Chat(Socket socket, List<Socket> socketList, int ctr, List<Account> acc, CommandDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
		this.socket = socket;
		this.socketList = socketList;
		this.ctr = ctr;
		this.accList = acc;
	}

	/**
	 * This method will start the stream. It will start accepting inputs from
	 * users and display them on the servers.
	 */
	public void run() {
		BufferedReader reader = null;
		Scanner scanServer = null;
		PrintWriter writer = null;
		Account acc = null;

		try {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

			PrintWriter printServer = new PrintWriter(System.out, true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if (acc == null) {
				String name = showIntro(printWriter, reader);
				acc = new Account(name);
				// this.addLogToDb(joinChatLog);
				// DBConnect.insert(new Logs(joinChatLog));
				accList.add(acc);
			}
			while (true) {
				String message = reader.readLine().trim();
				if (message.equalsIgnoreCase("#disconnect")) {
					String disconnectLog = acc.getName() + " left the group chat";
					System.out.println(disconnectLog);
					for (int i = 0; i < socketList.size(); i++) {
						writer = new PrintWriter(socketList.get(i).getOutputStream());
						if (socket.equals(socketList.get(i))) {
							writer.println("You left the group chat");
						} else {
							writer.println(disconnectLog);
						}
						writer.flush();
					}
					addLogToDb(disconnectLog);
					socketList.remove(socket);
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
					addLogToDb(sendMessageLog);
					addHistoryToDb(acc.getName(), message);
					writer.flush();
				}
				printWriter.flush();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param message
	 * @param acc
	 * @param printWriter
	 */
	private void determineCmd(String message, Account acc, PrintWriter printWriter) {
		String cmd = message.substring(1);
		int cmdLen = cmd.split("\\s").length;
		String commandLog = "";
		if (cmdLen == 1) {
			if (cmd.equalsIgnoreCase("help")) {
				showHelpList(printWriter);
				commandLog = acc.getName() + " used help command";
				System.out.println(commandLog);
			} else if (cmd.equalsIgnoreCase("showactive")) {
				showActive(printWriter);
				commandLog = acc.getName() + " used show active users command";
				System.out.println(commandLog);
			} else if (cmd.equalsIgnoreCase("history")) {
				getHistory(printWriter);
				commandLog = acc.getName() + " used show history command";
				System.out.println(commandLog);
			}
		} else if (cmdLen == 3) {
			String[] cmdAr = cmd.split("\\s");
			if (cmdAr[0].equalsIgnoreCase("history")) {
				if (cmdAr[1].equalsIgnoreCase("from")) {
					getHistory(printWriter, cmdAr[2]);
					commandLog = acc.getName() + " used show history command. View from " + cmdAr[2];
					printWriter.println("------------------------------------------------------------------------");
					printWriter.println("\t\t\t\tHISTORY");
					System.out.println(commandLog);
				}
			}
		} else if (cmdLen == 5) {
			String[] cmdAr = cmd.split("\\s");
			if (cmdAr[0].equalsIgnoreCase("history")) {
				if (cmdAr[1].equalsIgnoreCase("from") && cmdAr[3].equalsIgnoreCase("to")) {
					getHistory(printWriter, cmdAr[2], cmdAr[4]);
					commandLog = acc.getName() + " used history command. View from " + cmdAr[2] + " to " + cmdAr[4];
					printWriter.println("------------------------------------------------------------------------");
					printWriter.println("\t\t\t\tHISTORY");
					System.out.println(commandLog);
				}
			}
		}
		addLogToDb(commandLog);
	}

	private void getHistory(PrintWriter writer) {
		writer.println("------------------------------------------------------------------------");
		writer.println("\t\t\t\tHISTORY");
		List<History> historyReturn;
		historyReturn = this.daoImpl.getHistory();
		writer.println("Date and Time\t\t\tSender\t\t\tMessage");
		writer.println("------------------------------------------------------------------------");
		for (History history : historyReturn) {
			writer.println(
					history.getDateCreated() + "\t\t" + history.getChatterName() + "\t\t\t" + history.getMessage());
		}
	}

	private void getHistory(PrintWriter writer, String fromDate, String toDate) {
		writer.println("------------------------------------------------------------------------");
		writer.println("\t\t\t\tHISTORY");
		List<History> historyReturn = null;
		historyReturn = this.daoImpl.getHistory(fromDate, toDate);
		writer.println("Date and Time\t\t\tSender\t\t\tMessage");
		writer.println("------------------------------------------------------------------------");
		for (History history : historyReturn) {
			writer.println(
					history.getDateCreated() + "\t\t" + history.getChatterName() + "\t\t\t" + history.getMessage());
		}
	}

	private void getHistory(PrintWriter writer, String fromDate) {
		writer.println("------------------------------------------------------------------------");
		writer.println("\t\t\t\tHISTORY");
		List<History> historyReturn = null;
		historyReturn = this.daoImpl.getHistory(fromDate);
		writer.println("Date and Time\t\t\tSender\t\t\tMessage");
		writer.println("------------------------------------------------------------------------");
		for (History history : historyReturn) {
			writer.println(
					history.getDateCreated() + "\t\t" + history.getChatterName() + "\t\t\t" + history.getMessage());
		}
	}

	/**
	 * 
	 * @param printWriter
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private String showIntro(PrintWriter printWriter, BufferedReader reader) throws IOException {
		printWriter.println("------------------------");
		printWriter.println("WELCOME TO THE CHAT ROOM");
		printWriter.println("------------------------");
		String name = null;
		while (true) {
			printWriter.println("Enter desired name: ");
			name = reader.readLine();
			boolean userExists = isUserExisting(name, accList, printWriter);
			if (userExists) {
				printWriter.println("Name already exists! Please chose a different name!");
			} else if (name.equals("")) {
				printWriter.println("Name can not be empty");
			} else {
				socketList.add(socket);
				break;
			}
		}
		String joinChatLog = name + " joined the chat!";
		System.out.println(joinChatLog);
		for (int i = 0; i < socketList.size(); i++) {
			printWriter = new PrintWriter(socketList.get(i).getOutputStream());
			if (socket.equals(socketList.get(i))) {
				printWriter.println("You joined the chat!");
				printWriter.println("Start chatting!");
			} else {
				printWriter.println(joinChatLog);
			}
			printWriter.flush();
		}
		addLogToDb(joinChatLog);
		return name;
	}

	private boolean isUserExisting(String name, List<Account> accList, PrintWriter printWriter) {

		if (!accList.isEmpty()) {
			for (int i = 0; i < accList.size(); i++) {
				if (accList.get(i).getName().equalsIgnoreCase(name)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param logInsert
	 */
	private void addLogToDb(String logInsert) {
		this.daoImpl.insert(new Logs(logInsert));
	}

	/**
	 * 
	 * @param name
	 * @param historyInsert
	 */

	private void addHistoryToDb(String name, String historyInsert) {
		this.daoImpl.insert(new History(name, historyInsert));
	}

	/**
	 * 
	 * @param printWriter
	 */
	private void showActive(PrintWriter printWriter) {
		printWriter.println("Active Users");
		for (Account account : accList) {
			printWriter.println(account.getName());
		}
	}

	/**
	 * 
	 * @param printWriter
	 */

	private void showHelpList(PrintWriter printWriter) {
		printWriter.println("------------------------------------------------------------------------");
		printWriter.println("All command lines will start with number sign(#).");
		printWriter.println();
		printWriter.println("#disconnect\t\t\t\t\t\t-leave the chat");
		printWriter.println("#help\t\t\t\t\t\t\t-shows the list of all commands");
		printWriter.println("#history\t\t\t\t\t\t-shows the chat history for today");
		printWriter.println("#history from <date>\t\t\t\t\t-shows the chat history from the date to the current date");
		printWriter.println(
				"#history from <start date> to <end date>\t\t-shows the chat history from the start date to end date");
		printWriter.println("#showactive\t\t\t\t\t\t-shows the current active chat members");
		printWriter.println();
		printWriter.println();
	}
}
