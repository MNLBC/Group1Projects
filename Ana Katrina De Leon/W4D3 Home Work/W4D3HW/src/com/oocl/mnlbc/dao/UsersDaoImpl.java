package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.dbconnection.DBConnect;
import com.oocl.mnlbc.models.UsersModel;

public class UsersDaoImpl implements UsersDao {

	static DBConnect db = new DBConnect();

	public boolean addUser(UsersModel users) {
		Connection conn = db.getConn();
		String sql = "insert into USERS (firstname,lastname,address,uname,pass,email) values(?,?,?,?,?,?)";
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, users.getFirstname());
			pstmt.setString(2, users.getLastname());
			pstmt.setString(3, users.getAddress());
			pstmt.setString(4, users.getUname());
			pstmt.setString(5, users.getPass());
			pstmt.setString(6, users.getEmail());

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

	public boolean isUserExisting(UsersModel users) {
		Connection conn = db.getConn();
		String sql = "SELECT * from USERS where uname = '" + users.getUname() + "'";

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
