package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.db.DBConnect;
import com.oocl.mnlbc.model.User;

public class UserDaoImpl implements UserDao {
	static DBConnect db = new DBConnect();

	public boolean addUser(User user) {
		Connection conn = db.getConn();
		String sql = "insert into USERS (firstName,lastName,username,password,address,contact,email) values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getContact());
			pstmt.setString(7, user.getEmail());

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

	public boolean isUserExisting(User users) {
		Connection conn = db.getConn();
		String sql = "SELECT * from USERS where username = '" + users.getUsername() + "'";

		PreparedStatement pstmt;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
