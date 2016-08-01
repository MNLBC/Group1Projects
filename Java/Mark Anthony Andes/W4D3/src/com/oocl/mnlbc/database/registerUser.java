package com.oocl.mnlbc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.model.Register;

public class registerUser {
	static DBConnect db = new DBConnect();
	public void insert(Register register){
		Connection conn = db.getConn();
		String sql = "insert into REGISTER (FIRSTNAME,LASTNAME,EMAIL,USERNAME,PASSWORD) values(?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, register.getFirstName());
			pstmt.setString(2, register.getLastName());
			pstmt.setString(3, register.getEmail());
			pstmt.setString(4, register.getUserName());
			pstmt.setString(5, register.getPassword());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean cheakIfExists (Register reg) throws SQLException{
		Connection conn = db.getConn();
		String sql = "SELECT USERNAME FROM REGISTER WHERE  USERNAME='"+reg.getUserName()+"'";
		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
}
