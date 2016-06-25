package com.oocl.mnlbc.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private List<Account> accList;
	private int ctr;
//	DBConnect db = new DBConnect();

	public Chat(Socket socket, List<Socket> socketList, int ctr, List<Account> acc) {
		this.socket = socket;
		this.socketList = socketList;
		this.ctr = ctr;
		this.accList = acc;
	}

	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		Account acc = new Account();
		accList.add(acc);
		try {

			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
			printwriter.println("------------------------");
			printwriter.println("WELCOME TO THE CHAT ROOM");
			printwriter.println("------------------------");
			printwriter.println("Enter desired name: ");
			String name = reader.readLine();
			printwriter.println("Start chatting!");
			String joinChatLog = name + " joined the chat!";
//			addLogToDb(joinChatLog);
			//DBConnect.insert(new Logs(joinChatLog));
			
			System.out.println(joinChatLog);
			
			acc.setName(name);
			String message = null;
			//Scanner sc = new Scanner(System.in);
			while (true) {
//				String serverInput = sc.nextLine();
//				System.out.println(serverInput);
				message = reader.readLine().trim();
				if (message.equalsIgnoreCase("#disconnect")) {
					String disconnectLog = acc.getName() + " left the group chat";
					System.out.println(disconnectLog);
					//addLogToDb(disconnectLog);
					break;
//					writer = new PrintWriter(socket.getOutputStream());
//					writer.flush();
//					continue;
				}

				if (message.startsWith("#")) {
					String cmd = message.substring(1);
					int cmdLen = cmd.split("\\s").length;
					String commandLog ="";
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
							printwriter.println("History :}");
							System.out.println(commandLog);
						}
					} else if (cmdLen == 3) {
						String[] cmdAr = cmd.split("\\s");
						if (cmdAr[0].equalsIgnoreCase("history")) {
							if (cmdAr[1].equalsIgnoreCase("from")) {
								printwriter.println(cmdAr[2]);
								commandLog = acc.getName() + " used show history command. View from " + cmdAr[2];
								System.out.println(commandLog);
							}
						}
					} else if (cmdLen == 5) {
						String[] cmdAr = cmd.split("\\s");
						if (cmdAr[0].equalsIgnoreCase("history")) {
							if (cmdAr[1].equalsIgnoreCase("from") && cmdAr[3].equalsIgnoreCase("to")) {
								printwriter.println(cmdAr[2] + " " + cmdAr[4]);
								commandLog = acc.getName() + " used history command. View from " + cmdAr[2] + " to " + cmdAr[4];
								System.out.println(commandLog);
							}
						}
					}
					//addLogToDb(commandLog);
					printwriter.flush();
					continue;
				}

				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i).getOutputStream());
					writer.println(name + ": " + message);
					String sendMessageLog = (name + " sent a message");
					if(i==0){
						System.out.println(sendMessageLog);
					}
					writer.flush();
				}
				printwriter.flush();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	private void addLogToDb(String logInsert){
//		DBConnect.insert(new Logs(logInsert));
//	}

	private void showActive(PrintWriter printwriter) {
		printwriter.println("Active Users");
		for (Account account : accList) {
			printwriter.println(account.getName());
		}
	}

	private void showHelpList(PrintWriter printwriter) {
		printwriter.println("All command lines will start with number sign(#).");
		printwriter.println();
		printwriter.println("#help											-shows the list of all commands");
		printwriter.println("#showactive									-shows the current active chat members");
		printwriter.println("#history										-shows the chat history for today");
		printwriter.println(
				"#history from <date>							-shows the chat history from the date to the current date");
		printwriter.println(
				"#history from <start date> to <end date>		-shows the chat history from the start date to end date");
		printwriter.println();
		printwriter.println();
	}
}
