import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDetails {

	private String ID;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String MGRID;
	private String SALARY;

	static String driverName = "oracle.jdbc.driver.OracleDriver";
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		Connection conn = null;
		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "system";
		String password = "admin123";
		try {
			conn = DriverManager.getConnection(URL, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {

		System.out.println("======================INITIAL DB CONTENT===================");
		getAll();
		EmployeeDetails empDetails = new EmployeeDetails("6", "Alex", "Lee", "1", "4500");
		int i = insert(empDetails);
		if (i != 0) {
			System.out.println("======================AFTER ADDING ALEX===================");
		} else {
			System.out.println("======================FAILED TO ADD WITH ID " +empDetails.getID() + "===================");
		}
		getAll();
		update();
		System.out.println("======================AFTER UPDATE OF JONES===================");
		getAll();

	}

	private static int insert(EmployeeDetails empDetails) {
		Connection conn = getConn();
		String query = "insert into employee values(?,?,?,?,?)";
		PreparedStatement pStatement;
		int i = 0;
		try {
			pStatement = conn.prepareStatement(query);
			pStatement.setString(1, empDetails.getID());
			pStatement.setString(2, empDetails.getFIRST_NAME());
			pStatement.setString(3, empDetails.getLAST_NAME());
			pStatement.setString(4, empDetails.getMGRID());
			pStatement.setString(5, empDetails.getSALARY());
			i = pStatement.executeUpdate();
			pStatement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Must create record with unique id");
		}
		return i;
	}

	private static int update() {
		int i = 0;
		Connection conn = getConn();
		String query = "update employee set LAST_NAME = 'Tate' where LAST_NAME='Jones'";
		try {
			PreparedStatement pStatement = conn.prepareStatement(query);
			i = pStatement.executeUpdate();
			pStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static Integer getAll() {
		Connection conn = getConn();
		String query = "select * from employee";
		PreparedStatement pStatement;
		try {
			Statement sqlStatement = conn.createStatement();
			ResultSet result = sqlStatement.executeQuery("select * from employee");
			while (result.next()) {
				System.out.println(result.getString("NAME") + "\t" + result.getString("FIRST_NAME") + "\t"
						+ result.getString("LAST_NAME") + "\t" + result.getString("MGRID") + "\t"
						+ result.getString("SALARY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public EmployeeDetails(String iD, String fIRST_NAME, String lAST_NAME, String mGRID, String sALARY) {
		ID = iD;
		FIRST_NAME = fIRST_NAME;
		LAST_NAME = lAST_NAME;
		MGRID = mGRID;
		SALARY = sALARY;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getMGRID() {
		return MGRID;
	}

	public void setMGRID(String mGRID) {
		MGRID = mGRID;
	}

	public String getSALARY() {
		return SALARY;
	}

	public void setSALARY(String sALARY) {
		SALARY = sALARY;
	}

	public static String getDriverName() {
		return driverName;
	}

	public static void setDriverName(String driverName) {
		EmployeeDetails.driverName = driverName;
	}

}
