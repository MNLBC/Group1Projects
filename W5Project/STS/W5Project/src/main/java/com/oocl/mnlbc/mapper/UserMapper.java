package com.oocl.mnlbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("ID"));
		user.setFirstname(rs.getString("firstname"));
		user.setMiddlename(rs.getString("middlename"));
		user.setLastname(rs.getString("lastname"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("EMAIL"));
		if (rs.getInt("IS_DISABLED") == 1) {
			user.setDisabled(true);
		} else {
			user.setDisabled(false);
		}
		return user;
	}

}