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
		// BufferedReader readerServer = null;
		PrintWriter writer = null;
		Account acc = new Account();
		try {
			PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// readerServer = new BufferedReader(new
			// InputStreamReader(socket.getInputStream()));
			String name = showIntro(printwriter, reader);
			// this.addLogToDb(joinChatLog);
			// DBConnect.insert(new Logs(joinChatLog));
			acc.setName(name);
			accList.add(acc);
			// Scanner sc = new Scanner(System.in);
			while (true) {
				// String serverInput = sc.nextLine();
				// System.out.println(serverInput);
				// String msgServer = readerServer.readLine().trim();
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
					break;
					// writer = new PrintWriter(socket.getOutputStream());
					// writer.flush();
					// continue;
				}

				if (message.startsWith("#")) {
					determineCmd(message, acc, printwriter);
					printwriter.flush();
					continue;
				}

				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i).getOutputStream());
					writer.println(name + ": " + message);
					String sendMessageLog = (name + " sent a message");
					if (i == 0) {
						System.out.println(sendMessageLog);
					}
					addLogToDb(sendMessageLog);
					addHistoryToDb(name, message);
					writer.flush();
				}
				printwriter.flush();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param message
	 * @param acc
	 * @param printwriter
	 */
	private void determineCmd(String message, Account acc, PrintWriter printwriter) {
		String cmd = message.substring(1);
		int cmdLen = cmd.split("\\s").length;
		String commandLog = "";
		if (cmdLen == 1) {
			if (cmd.equalsIgnoreCase("help")) {
				commandLog = acc.getName() + " used help command";
				System.out.println(commandLog);
				showHelpList(printwriter);
			} else if (cmd.equalsIgnoreCase("showactive")) {
				commandLog = acc.getName() + " used show active users command";
				System.out.println(commandLog);
				showActive(printwriter);
			} else if (cmd.equalsIgnoreCase("history")) {
				commandLog = acc.getName() + " used show history command";
				printwriter.println("------------------------------------------------------------------------");
				printwriter.println("\t\t\t\tHISTORY");
				getHistory(printwriter);
				System.out.println(commandLog);
			}
		} else if (cmdLen == 3) {
			String[] cmdAr = cmd.split("\\s");
			if (cmdAr[0].equalsIgnoreCase("history")) {
				if (cmdAr[1].equalsIgnoreCase("from")) {
					printwriter.println(cmdAr[2]);
					commandLog = acc.getName() + " used show history command. View from " + cmdAr[2];
					printwriter.println("------------------------------------------------------------------------");
					printwriter.println("\t\t\t\tHISTORY");
					getHistory(printwriter, cmdAr[2]);
					System.out.println(commandLog);
				}
			}
		} else if (cmdLen == 5) {
			String[] cmdAr = cmd.split("\\s");
			if (cmdAr[0].equalsIgnoreCase("history")) {
				if (cmdAr[1].equalsIgnoreCase("from") && cmdAr[3].equalsIgnoreCase("to")) {
					printwriter.println(cmdAr[2] + " " + cmdAr[4]);
					commandLog = acc.getName() + " used history command. View from " + cmdAr[2] + " to " + cmdAr[4];
					printwriter.println("------------------------------------------------------------------------");
					printwriter.println("\t\t\t\tHISTORY");
					getHistory(printwriter, cmdAr[2], cmdAr[4]);
					System.out.println(commandLog);
				}
			}
		}
		addLogToDb(commandLog);
	}

	private void getHistory(PrintWriter writer) {
		List<History> historyReturn;
		try {
			historyReturn = this.daoImpl.getHistory();
			writer.println("Sender\t\t\tMessage\t\t\tDate and Time");
			writer.println("------------------------------------------------------------------------");
			for (History history : historyReturn) {
				writer.println(history.getChatterName() + "\t\t\t" + history.getMessage() + "\t\t\t"
						+ history.getDateCreated());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getHistory(PrintWriter writer, String fromDate, String toDate) {
		List<History> historyReturn = null;
		try {
			historyReturn = this.daoImpl.getHistory(fromDate, toDate);
			writer.println("Sender\t\t\tMessage\t\t\tDate and Time");
			writer.println("------------------------------------------------------------------------");
			for (History history : historyReturn) {
				writer.println(history.getChatterName() + "\t\t\t" + history.getMessage() + "\t\t\t"
						+ history.getDateCreated());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getHistory(PrintWriter writer, String fromDate) {
		List<History> historyReturn = null;
		try {
			historyReturn = this.daoImpl.getHistory(fromDate);
			writer.println("Sender\t\t\tMessage\t\t\tDate and Time");
			writer.println("------------------------------------------------------------------------");
			for (History history : historyReturn) {
				writer.println(history.getChatterName() + "\t\t\t" + history.getMessage() + "\t\t\t"
						+ history.getDateCreated());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param printwriter
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private String showIntro(PrintWriter printwriter, BufferedReader reader) throws IOException {
		printwriter.println("------------------------");
		printwriter.println("WELCOME TO THE CHAT ROOM");
		printwriter.println("------------------------");
		String name = null;
		while (true) {
			printwriter.println("Enter desired name: ");
			name = reader.readLine();
			boolean userExists = isUserExisting(name, accList, printwriter);
			if (userExists) {
				printwriter.println("Name already exists! Please chose a different name!");
			} else if (name.equals("")) {
				printwriter.println("Name can not be empty");
			} else {
				socketList.add(socket);
				break;
			}
		}
		String joinChatLog = name + " joined the chat!";
		System.out.println(joinChatLog);
		for (int i = 0; i < socketList.size(); i++) {
			printwriter = new PrintWriter(socketList.get(i).getOutputStream());
			if (socket.equals(socketList.get(i))) {
				printwriter.println("You joined the chat!");
				printwriter.println("Start chatting!");
			} else {
				printwriter.println(joinChatLog);
			}
			printwriter.flush();
		}
		addLogToDb(joinChatLog);
		return name;
	}

	private boolean isUserExisting(String name, List<Account> accList, PrintWriter printwriter) {

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
		try {
			this.daoImpl.insert(new Logs(logInsert));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param name
	 * @param historyInsert
	 */

	private void addHistoryToDb(String name, String historyInsert) {
		try {
			this.daoImpl.insert(new History(name, historyInsert));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param printwriter
	 */
	private void showActive(PrintWriter printwriter) {
		printwriter.println("Active Users");
		for (Account account : accList) {
			printwriter.println(account.getName());
		}
	}

	/**
	 * 
	 * @param printwriter
	 */
	private void showHelpList(PrintWriter printwriter) {
		printwriter.println("------------------------------------------------------------------------");
		printwriter.println("All command lines will start with number sign(#).");
		printwriter.println();
		printwriter.println("#disconnect\t\t\t\t\t\t-leave the chat");
		printwriter.println("#help\t\t\t\t\t\t\t-shows the list of all commands");
		printwriter.println("#history\t\t\t\t\t\t-shows the chat history for today");
		printwriter.println("#history from <date>\t\t\t\t\t-shows the chat history from the date to the current date");
		printwriter.println(
				"#history from <start date> to <end date>\t\t-shows the chat history from the start date to end date");
		printwriter.println("#showactive\t\t\t\t\t\t-shows the current active chat members");
		printwriter.println();
		printwriter.println();
	}
}
