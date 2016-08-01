package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.db.DBConnect;
import com.oocl.mnlbc.models.User;

public class CommandDAOImpl implements CommandDAO {

	static DBConnect db = new DBConnect();

	@Override
	public boolean insertUser(User user) {
		Connection conn = db.getConn();
		String sql = "insert into userInfo(fname, lname, email, password, username, gender) values(?,?,?,?,?,?)";
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFname());
			pstmt.setString(2, user.getLname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getUsername());
			pstmt.setString(6, user.getGender());
			success = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (success > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean isUserExisting(User user) {
		Connection conn = db.getConn();
		String sql = "SELECT * FROM USERINFO WHERE USERNAME = \'" + user.getUsername() + "\'";
		PreparedStatement pstmt;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
