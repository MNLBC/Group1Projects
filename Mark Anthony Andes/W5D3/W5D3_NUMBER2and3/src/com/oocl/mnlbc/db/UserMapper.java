package com.oocl.mnlbc.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.User;

public class UserMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs,int rowNum)throws SQLException{
		User user = new User();
		user.setUserName(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		return user;
		
		
	}
	

}
