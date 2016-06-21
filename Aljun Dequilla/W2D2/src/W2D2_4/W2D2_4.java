package W2D2_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class W2D2_4 {

	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	static String un = "system";
	static String pw = "admin123";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		W2D2_4 app = new W2D2_4();
		Connection con = null;
		Statement sql;
		try {
			con = DriverManager.getConnection(URL, un, pw);
			sql = con.createStatement();
			
			app.displayDB();
			System.out.println();
			
			sql.executeUpdate("INSERT INTO EMPLOYEE VALUES (6,'Alex','Lee',1,4500)");
//			sql.executeUpdate("DELETE FROM EMPLOYEE WHERE FIRST_NAME = 'Alex'");
			System.out.println("After Insert Alex");
			app.displayDB();
			
			sql.executeUpdate("UPDATE EMPLOYEE SET LAST_NAME = 'Tate' WHERE LAST_NAME = 'Jones'");
//			sql.executeUpdate("UPDATE EMPLOYEE SET LAST_NAME = 'Jones' WHERE LAST_NAME = 'Tate'");
			System.out.println("\nAfter Update Matha");
			app.displayDB();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayDB() throws SQLException {
		Connection con = DriverManager.getConnection(URL, un, pw);
		Statement sql = con.createStatement();
		ResultSet result = null;
		result = sql.executeQuery("SELECT * FROM EMPLOYEE ORDER BY ID");
		int col = result.getMetaData().getColumnCount();
		System.out.println("ID\tFIRST_NAME\tLAST_NAME\tMGRID\tSALARY");
		while (result.next()) {
			for (int i = 1; i <= col; i++) {
				System.out.print(result.getString(i) + "\t");
				if (((i == 2) || (i == 3)) &&(result.getString(i).length() < 8)) {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		result.close();
		sql.close();
		con.close();
	}
}
