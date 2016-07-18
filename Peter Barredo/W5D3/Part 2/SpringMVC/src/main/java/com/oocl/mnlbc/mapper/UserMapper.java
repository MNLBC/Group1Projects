package com.oocl.mnlbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.model.User;

public class UserMapper {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();

		user.setFname(rs.getString("fname"));
		user.setLname(rs.getString("lname"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setAddress(rs.getString("address"));

		return user;
	}
}
