package com.oocl.mnlbc.app;

import java.sql.SQLException;
import java.util.List;

import com.oocl.mnlbc.dao.CommandDAOImpl;
import com.oocl.mnlbc.model.History;
import com.oocl.mnlbc.model.Logs;

/**
 * The purpose of the App class is for the displaying of the recent date ,
 * preferred date, and custom dates of History and Logs.
 * 
 * @author Group 1
 *
 */
public class App {
	/**
	 * The main method for the App class.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		CommandDAOImpl cdao = new CommandDAOImpl();

		List<History> history = cdao.getHistory();
		for (History history2 : history) {
			System.out
					.println(history2.getChatterName() + " " + history2.getMessage() + " " + history2.getDateCreated());
		}

		List<History> preferredDateHistory = cdao.getHistory("24-06-2016");
		for (History history2 : preferredDateHistory) {
			System.out
					.println(history2.getChatterName() + " " + history2.getMessage() + " " + history2.getDateCreated());
		}

		List<History> CustomDateHistory = cdao.getHistory("24-06-2016", "24-07-2016");
		for (History history2 : CustomDateHistory) {
			System.out
					.println(history2.getChatterName() + " " + history2.getMessage() + " " + history2.getDateCreated());
		}
		List<Logs> logs = cdao.getLogs();
		for (Logs logs2 : logs) {
			System.out.println(logs2.getMessage() + " " + logs2.getDateCreated());
		}
		List<Logs> prefferedDateLogs = cdao.getLogs("24-06-2016");
		for (Logs logs2 : prefferedDateLogs) {
			System.out.println(logs2.getMessage() + " " + logs2.getDateCreated());
		}
		List<Logs> customDateLogs = cdao.getLogs("24-06-2016", "26-07-2016");
		for (Logs logs2 : customDateLogs) {
			System.out.println(logs2.getMessage() + " " + logs2.getDateCreated());
		}

		// cdao.insert(new Logs("FROM JAVA"));
	}

}
