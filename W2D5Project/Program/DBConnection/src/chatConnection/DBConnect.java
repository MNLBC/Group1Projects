package chatConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBConnect {
	private static Connection getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String username = "system";
		String password = "password";
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

	public static int insert(History history) {
		Connection conn = getConn();
		Date date = new Date();
		int i = 0;
		String sql = "insert into HISTORY (ID,CHATTER_NAME,MESSAGE,DATE_CREATED) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, history.getId());
			pstmt.setString(2, history.getChatterName());
			pstmt.setString(3, history.getMessage());
			pstmt.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int insert(Logs logs) {
		Connection conn = getConn();
		Date date = new Date();
		int i = 0;
		String sql = "insert into LOGS (ID,MESSAGE,DATE_CREATED) values(?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, logs.getId());
			pstmt.setString(2, logs.getMessage());
			pstmt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static List<History> getAllHistory() {
		Connection conn = getConn();
		String sql = "SELECT * FROM HISTORY";
		PreparedStatement pstmt;
		List<History> history = new ArrayList<History>();
		try {
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name= rs.getString("chatter_name");
				String message = rs.getString("message");
				Timestamp date = rs.getTimestamp("date_created");
				
				History hs = new History(id,name,message,date);
				history.add(hs);
				System.out.println(hs.getId() +" " +hs.getMessage() + " " +hs.getChatterName() +" "+ hs.getDateCreated());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return history;
	}
	public static List<Logs> getAllLogs() {
		Connection conn = getConn();
		String sql = "SELECT * FROM LOGS";
		PreparedStatement pstmt;
		
		List<Logs> logs = new ArrayList<Logs>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				int id = rs.getInt("id");
				String message= rs.getString("message");
				Timestamp date = rs.getTimestamp("date_created");
				
				Logs log = new Logs(id,message,date);
				logs.add(log);
				System.out.println(log.getId() + " " + log.getMessage() + " " + log.getDateCreated());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logs;
	}
}
