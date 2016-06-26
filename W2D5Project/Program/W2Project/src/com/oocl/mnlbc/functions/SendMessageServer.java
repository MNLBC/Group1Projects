package com.oocl.mnlbc.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import com.oocl.mnlbc.dao.CommandDAO;
import com.oocl.mnlbc.dao.CommandDAOImpl;
import com.oocl.mnlbc.model.Account;
import com.oocl.mnlbc.model.FileHistory;
import com.oocl.mnlbc.model.History;
import com.oocl.mnlbc.model.Logs;

public class SendMessageServer extends Thread {
	private Socket socket;
	private List<Account> acc;
	private CommandDAO daoImpl;

	public SendMessageServer(Socket socket, List<Account> acc, CommandDAO daoImpl) {
		this.socket = socket;
		this.acc = acc;
		this.daoImpl = daoImpl;
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
					continue;
				}
				if (message.equalsIgnoreCase("#genfile")) {
					generateFile();
				}
				if (message.startsWith("#")) {
					determindCmd(message);

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

	private void determindCmd(String message) {

		String cmd = message.substring(1);
		int cmdLen = cmd.split("\\s").length;
		String commandLog = "";
		if (cmdLen == 1) {
			if (cmd.equalsIgnoreCase("history")) {
				history();
			} else if (cmd.equalsIgnoreCase("logs")) {
				logs();
			}
		} else if (cmdLen == 3) {
			String[] cmdAr = cmd.split("\\s");
			if (cmdAr[0].equalsIgnoreCase("history")) {
				if (cmdAr[1].equalsIgnoreCase("from")) {
					history(cmdAr[2]);
				} else if (cmdAr[0].equalsIgnoreCase("logs")) {
					if (cmdAr[1].equalsIgnoreCase("from")) {
						logs(cmdAr[2]);
					}
				}
			}
		} else if (cmdLen == 5) {
			String[] cmdAr = cmd.split("\\s");
			if (cmdAr[0].equalsIgnoreCase("history")) {
				if (cmdAr[1].equalsIgnoreCase("from") && cmdAr[3].equalsIgnoreCase("to")) {
					history(cmdAr[2], cmdAr[4]);
				}
			} else if (cmdAr[0].equalsIgnoreCase("logs")) {
				if (cmdAr[1].equalsIgnoreCase("from") && cmdAr[3].equalsIgnoreCase("to")) {
					logs(cmdAr[2], cmdAr[4]);
				}
			}
		}

	}

	private void headerHistory() {
		System.out.println("Date and Time\t\t\tSender\t\t\tMessage");
		System.out.println("------------------------------------------------------------------------");
	}

	private void headerLogs() {
		System.out.println("Date and Time\t\t\t\tMessage");
		System.out.println("------------------------------------------------------------------------");
	}

	private void logs(String fromDate, String toDate) {
		headerLogs();
		List<Logs> logsList = this.daoImpl.getLogs(fromDate, toDate);
		for (Logs logs : logsList) {
			String entry = logs.getDateCreated() + "\t\t\t" + logs.getMessage();
			System.out.println(entry);
		}
	}

	private void logs(String fromDate) {
		headerLogs();
		List<Logs> logsList = this.daoImpl.getLogs(fromDate);
		for (Logs logs : logsList) {
			String entry = logs.getDateCreated() + "\t\t\t" + logs.getMessage();
			System.out.println(entry);
		}
	}

	private void logs() {
		headerLogs();
		List<Logs> logsList = this.daoImpl.getLogs();
		for (Logs logs : logsList) {
			String entry = logs.getDateCreated() + "\t\t\t" + logs.getMessage();
			System.out.println(entry);
		}
	}

	private void history(String fromDate, String toDate) {
		headerHistory();
		List<History> histList = this.daoImpl.getHistory(fromDate, toDate);
		for (History history : histList) {
			String entry = history.getDateCreated() + "\t\t" + history.getChatterName() + "\t\t"
					+ history.getMessage();
			System.out.println(entry);
		}
	}

	private void history(String fromDate) {
		headerHistory();
		List<History> histList = this.daoImpl.getHistory(fromDate);
		for (History history : histList) {
			String entry = history.getDateCreated() + "\t\t" + history.getChatterName() + "\t\t"
					+ history.getMessage();
			System.out.println(entry);
		}
	}

	private void history() {
		headerHistory();
		List<History> histList = this.daoImpl.getHistory();
		for (History history : histList) {
			String entry = history.getDateCreated() + "\t\t" + history.getChatterName() + "\t\t"
					+ history.getMessage();
			System.out.println(entry);
		}
	}

	private void generateFile() {
		FileHistory fileHistory = new FileHistory();
		fileHistory.createFile();
		fileHistory.importHistory();
	}

	private void showActive() {
		if (acc.size() > 0) {
			System.out.println("Active Users");
			for (Account account : acc) {
				System.out.println(account.getName());
			}
		} else {
			System.out.println("No active user yet.");
		}
	}
}
