package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oocl.mnlbc.db.DBConnect;
import com.oocl.mnlbc.model.History;
import com.oocl.mnlbc.model.Logs;
/**
 * The purpose of the CommandDAOImpl is where we put all the methods.
 * @author Group 1
 *
 */
public class CommandDAOImpl implements CommandDAO {
	static DBConnect db = new DBConnect();
/**
 * <p>The purpose of the following methods is for the insertion and displaying of
 * data for the chat history and chat logs.</p>
 */
	public void insert(History history) throws SQLException {
		Connection conn = db.getConn();
		Date date = new Date();
		String sql = "insert into HISTORY (CHATTER_NAME,MESSAGE,DATE_CREATED) values(?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, history.getChatterName());
			pstmt.setString(2, history.getMessage());
			pstmt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<History> getHistory() throws SQLException {
		Connection conn = db.getConn();
		DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
		Date dateobj = new Date();
		String currentDate = df.format(dateobj);

		String sql = "SELECT * FROM HISTORY  WHERE  date_created >= to_timestamp('" + currentDate
				+ " 00:00:00','dd-mm-yyyy hh24:mi:ss')";

		PreparedStatement pstmt;
		List<History> history = new ArrayList<History>();
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("chatter_name");
				String message = rs.getString("message");
				Timestamp date = rs.getTimestamp("date_created");

				History hs = new History(id, name, message, date);
				history.add(hs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return history;
	}

	public List<History> getHistory(String fromDate) throws SQLException {

		Connection conn = db.getConn();

		String sql = "SELECT * FROM HISTORY  WHERE  date_created >= to_timestamp('" + fromDate
				+ " 00:00:00','dd-mm-yyyy hh24:mi:ss')";

		PreparedStatement pstmt;
		List<History> history = new ArrayList<History>();
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("chatter_name");
				String message = rs.getString("message");
				Timestamp date = rs.getTimestamp("date_created");

				History hs = new History(id, name, message, date);
				history.add(hs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return history;

	}

	public List<History> getHistory(String fromDate, String toDate) throws SQLException {
		Connection conn = db.getConn();

		String sql = "SELECT * FROM HISTORY  WHERE  date_created BETWEEN to_timestamp('" + fromDate
				+ " 00:00:00','dd-mm-yyyy hh24:mi:ss') AND to_timestamp('" + toDate
				+ " 00:00:00','dd-mm-yyyy hh24:mi:ss') ";

		PreparedStatement pstmt;
		List<History> history = new ArrayList<History>();
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("chatter_name");
				String message = rs.getString("message");
				Timestamp date = rs.getTimestamp("date_created");

				History hs = new History(id, name, message, date);
				history.add(hs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return history;

	}

	public void insert(Logs logs) throws SQLException {
		Connection conn = db.getConn();
		Date date = new Date();
		String sql = "insert into LOGS (MESSAGE,DATE_CREATED) values(?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, logs.getMessage());
			pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Logs> getLogs() throws SQLException {
		Connection conn = db.getConn();
		String sql = "SELECT * FROM LOGS";
		PreparedStatement pstmt;

		List<Logs> logs = new ArrayList<Logs>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String message = rs.getString("message");
				Timestamp date = rs.getTimestamp("date_created");

				Logs log = new Logs(id, message, date);
				logs.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logs;
	}

	public List<Logs> getLogs(String fromDate) throws SQLException {
		Connection conn = db.getConn();

		String sql = "SELECT * FROM LOGS  WHERE  date_created >= to_timestamp('" + fromDate
				+ " 00:00:00','dd-mm-yyyy hh24:mi:ss')";

		PreparedStatement pstmt;
		List<Logs> log = new ArrayList<Logs>();
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String message = rs.getString("message");
				Timestamp date = rs.getTimestamp("date_created");

				Logs logs = new Logs(id, message, date);
				log.add(logs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return log;

	}

	public List<Logs> getLogs(String fromDate, String toDate) throws SQLException {
		Connection conn = db.getConn();

		String sql = "SELECT * FROM LOGS  WHERE  date_created BETWEEN to_timestamp('" + fromDate
				+ " 00:00:00','dd-mm-yyyy hh24:mi:ss') AND to_timestamp('" + toDate
				+ " 00:00:00','dd-mm-yyyy hh24:mi:ss') ";

		PreparedStatement pstmt;
		List<Logs> log = new ArrayList<Logs>();
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String message = rs.getString("message");
				Timestamp date = rs.getTimestamp("date_created");

				Logs logs = new Logs(id, message, date);
				log.add(logs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return log;
	}

}
