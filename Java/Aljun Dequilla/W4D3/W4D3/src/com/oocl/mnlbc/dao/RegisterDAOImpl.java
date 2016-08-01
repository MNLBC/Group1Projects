package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.db.RegisterDB;
import com.oocl.mnlbc.models.RegisterUser;

public class RegisterDAOImpl implements RegisterDAO {
	private static RegisterDB db = new RegisterDB();

	@Override
	public boolean insert(RegisterUser user) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO REGISTERUSER (USERID,FNAME,LNAME,PASSWORD) values(?,?,?,?)";
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1,user.getuId());
			pstmt.setString(2,user.getfName());
			pstmt.setString(3,user.getlName());
			pstmt.setString(4,user.getpWord());
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
	public List<RegisterUser> getUsers() {
		Connection conn = db.getConn();
		String sql = "SELECT * FROM REGISTERUSER";
		PreparedStatement pstmt;
		List<RegisterUser> listUser = new ArrayList<RegisterUser>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("USERID");
				String fn = rs.getString("FNAME");
				String ln = rs.getString("LNAME");
				String pw = rs.getString("PASSWORD");

				RegisterUser user = new RegisterUser(id, fn, ln, pw);
				listUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
}
