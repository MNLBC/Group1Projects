package com.oocl.mnlbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnect Class
 * 
 * @author Group 1
 * 
 * @since 2016-07-11
 *
 */
public class DBConnect {
	public Connection getConn() {
		  String driver = Config.getConfigValue("driver");
	      String url = Config.getConfigValue("url");
	      String username = Config.getConfigValue("user");
	      String password = Config.getConfigValue("pass");
	      Connection conn = null;
	      try {
	         Class.forName(driver);
	         conn = (Connection) DriverManager.getConnection(url, username, password);
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return conn;
	}
}
