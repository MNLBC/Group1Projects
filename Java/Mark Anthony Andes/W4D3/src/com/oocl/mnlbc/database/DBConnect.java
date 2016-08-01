package com.oocl.mnlbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public Connection getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "JustC0d3";
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
	
	public boolean tryConnect(String un, String pw) {
		if (un == "system" && pw == "JustC0d3") {
			return true;
		} else {
			return false;
		}
	}
}
