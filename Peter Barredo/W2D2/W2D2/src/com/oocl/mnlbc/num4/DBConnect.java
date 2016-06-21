package com.oocl.mnlbc.num4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author barrepe
 *
 */
public class DBConnect {
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String USERNAME = "system";
	static final String PASSWORD = "admin";
	
	Connection con;
	Statement st;
	ResultSet rs;
	
	public DBConnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * This gets all the employees in the database
	 * @return List<Employee>
	 */
	
	public List<Employee> getAllEmployee(){
		List<Employee> emp = new ArrayList<Employee>();
		
		try {
			rs = st.executeQuery("SELECT * FROM EMPLOYEE");
			int col = rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				int id = rs.getInt("ID");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				int mGrid = rs.getInt("MGRID");
				double salary = rs.getDouble("SALARY");
				
				emp.add(new Employee(id,firstname,lastname,mGrid,salary));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	/**
	 * This method accepts Employee as parameter in adding data to database
	 * @param Employee
	 */
	
	public void insertToDB(Employee emp){
	    String query = "INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,MGRID,SALARY) VALUES (?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	    	pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, emp.getId());
	        pstmt.setString(2, emp.getFirst_name());
	        pstmt.setString(3, emp.getLast_name());
	        pstmt.setInt(4, emp.getMgrid());
	        pstmt.setDouble(5, emp.getSalary());
	        
	        pstmt.executeUpdate();
	        pstmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }
	}
	
	/**
	 * This method finds employee using its last name. Accepts string and return Employee
	 * @param String
	 * @return Employee
	 */
	
	public Employee findEmployeeByLastname(String lastName){
		Employee emp = null;		
		try {
			rs = st.executeQuery("SELECT * FROM EMPLOYEE WHERE LAST_NAME LIKE '%"+ lastName + "%'");
			int col = rs.getMetaData().getColumnCount();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				int mGrid = rs.getInt("MGRID");
				double salary = rs.getDouble("SALARY");

				emp = new Employee(id, firstname, lastname, mGrid, salary);
			}
			return emp;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}
	
	/**
	 * Update record of the database with the given Employee object and new last name string
	 * @param Employee
	 * @param String
	 * 
	 */
	
	public void updateRecordLastName(Employee emp, String newLastname){
	    String query = "UPDATE EMPLOYEE SET LAST_NAME='"+ newLastname +"' WHERE ID = '" + emp.getId()+"'"; 
	    PreparedStatement pstmt;
	    try {
	    	pstmt = con.prepareStatement(query);
	    	pstmt.executeUpdate();
	        pstmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}

