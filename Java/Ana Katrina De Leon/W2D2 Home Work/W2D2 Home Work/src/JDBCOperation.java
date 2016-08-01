import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOperation {
	public static Connection getConn() {

	    Connection conn = null;
	    try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password1");  
            
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public static int insert(Employee employee) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into employee (ID, First_Name,Last_Name,Mgrid, Salary) values(?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setInt(1, employee.getId());
	        pstmt.setString(2, employee.getFirstName());
	        pstmt.setString(3, employee.getLastName());
	        pstmt.setInt(4, employee.getMgrid());
	        pstmt.setInt(5, employee.getSalary());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static int update(Employee employee) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update employee set Last_Name='" + employee.getLastName() + "' where ID='" + employee.getId() + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("result: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}

	public static Integer getAll() {
		 Connection conn = getConn();
		    String sql = "select * from employee order by ID";
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        int col = rs.getMetaData().getColumnCount();
		        System.out.println("============================");
		        while (rs.next()) {
		            for (int i = 1; i <= col; i++) {
		                System.out.print(rs.getString(i) + "\t");
		                if ((i == 2) && (rs.getString(i).length() < 8)) {
		                    System.out.print("\t");
		                }
		                if ((i == 3) && (rs.getString(i).length() < 8)) {
		                    System.out.print("\t");
		                }
		             }
		            System.out.println("");
		        }
		            System.out.println("============================");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return null;
		
	}
	public static int deleteAll() {
		Connection conn = getConn();
		int i = 0;
		String sql = "DELETE FROM EMPLOYEE";
		PreparedStatement pstmt;
		try {
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		i = pstmt.executeUpdate();
		System.out.println("Deleted Data");
		pstmt.close();
		conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return i;
		}
}
