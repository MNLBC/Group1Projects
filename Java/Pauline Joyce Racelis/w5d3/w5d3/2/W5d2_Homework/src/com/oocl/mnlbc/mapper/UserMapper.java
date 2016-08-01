package com.oocl.mnlbc.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.User;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum)throws SQLException {
		User user = new User();
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setAddress(rs.getString("address"));
		user.setContact(rs.getString("contact"));
		user.setEmail(rs.getString("email"));
		
		return user;
	}

}
