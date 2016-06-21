package w2d2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBC {
	public static Connection getConn() {
//	    String driver = "com.mysql.jdbc.Driver";
//	    String url = "jdbc:mysql://localhost:3306/samp_db";
//	    String username = "root";
//	    String password = "";
	    Connection conn = null;
	    try {
//	        Class.forName(driver); //classLoader,加载对应驱动
//	        conn = (Connection) DriverManager.getConnection(url, username, password);

	        //Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");  
            
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
	    String sql = "insert into employee (ID,FIRST_NAME,LAST_NAME,MGRID,SALARY) values(?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setInt(1, employee.getId());
	        pstmt.setString(2, employee.getFirst_Name());
	        pstmt.setString(3, employee.getLast_Name());
	        pstmt.setInt(4,employee.getMGRID() );
	        pstmt.setFloat(5, employee.getSalary());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static int update(String string, String string2String ) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update employee set Last_Name='" + string + "' where Last_Name='" + string2String + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("result " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}

	public static Integer getAll() {
	    Connection conn = getConn();
	    String sql = "select * from employee order by id";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        System.out.println("ID	" + "FirstName	" + "LastName " + "MGRID	" + "SALARY	");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
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
}
