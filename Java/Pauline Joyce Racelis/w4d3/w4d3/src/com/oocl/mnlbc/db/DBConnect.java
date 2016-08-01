package com.oocl.mnlbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public Connection getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "password";
		Connection conn = null;
		try {
			Class.forName(driver);
			if (tryConnect(username, password)) {
				conn = (Connection) DriverManager.getConnection(url, username, password);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Tries to make the connection.
	 * 
	 * @param un
	 *            UserName
	 * @param pw
	 *            Password
	 * @return
	 */
	public boolean tryConnect(String un, String pw) {
		if (un == "system" && pw == "password") {
			return true;
		} else {
			return false;
		}
	}

}
