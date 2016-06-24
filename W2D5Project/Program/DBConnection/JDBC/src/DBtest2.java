import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBtest2 {

	static String driverName = "oracle.jdbc.driver.OracleDriver";
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String un = "system";
		String pw = "password";
		Connection con = null;
		Statement sql;
		ResultSet result = null;
		try {
			con = DriverManager.getConnection(URL, un, pw);
			sql = con.createStatement();
			result = sql.executeQuery("SELECT * FROM users");
			while (result.next()) {
				System.out.println(result.getString("NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.close();
		con.close();
	}

}
