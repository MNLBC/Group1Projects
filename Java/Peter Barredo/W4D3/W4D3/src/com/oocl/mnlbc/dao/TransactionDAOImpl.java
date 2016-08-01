package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.db.DBConnect;
import com.oocl.mnlbc.model.User;

public class TransactionDAOImpl implements TransactionDAO{
	static DBConnect db = new DBConnect();
	
	@Override
	public boolean save(User user) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO users (firstname,middlename,lastname,username,password,email) VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getMiddlename());
			pstmt.setString(3, user.getLastname());
			pstmt.setString(4, user.getUsername());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getEmail());
			success = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (success > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isExisting(String username) {
		Connection conn = db.getConn();
		String sql = "SELECT * FROM users WHERE username = '"+ username +"'";
		PreparedStatement pstmt;

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
