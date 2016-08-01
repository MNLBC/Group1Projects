package com.oocl.mnlbc.homework.w2.d2;

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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "JustC0d3");
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
		String sql = "INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,MGRID,SALARY) VALUES (?,?,?,?,?)";
		PreparedStatement pstmt;

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getFisrtName());
			pstmt.setString(3, employee.getLastName());
			pstmt.setString(4, employee.getMgird());
			pstmt.setInt(5, employee.getSalary());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int updateLastName(Employee employee) {
		Connection con = getConn();
		int i = 0;
		String sql = "UPDATE EMPLOYEE SET LAST_NAME='" + employee.getLastName() + "' WHERE ID='" + employee.getId()
				+ "'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("\t\tUpdate Complete!");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static Integer getAll() {
		Connection conn = getConn();
		String sql = "SELECT * FROM EMPLOYEE ORDER BY ID";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("-----------------------------------------");
			while (rs.next()) {
				for (int i = 1; i < col; i++) {
					System.out.print(rs.getString(i) + "\t");
					if ((i == 2) && rs.getString(i).length() < 8) {
						System.out.print("\t");
					}
					if ((i == 3) && rs.getString(i).length() < 8) {
						System.out.print("\t");
					}
				}
				System.out.println();
			}
			System.out.println("-----------------------------------------");
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
			System.out.println("\tSUCCESFULLY DELETE ALL DATA");
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
