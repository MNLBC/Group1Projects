package com.oocl.mnlbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.User;

/**
 * RowMapper implementation class MealMapper. Maps every record in query to User
 * model.
 * 
 * @author Group 1 
 * @since 07-18-2016
 */
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
		user.setContact(rs.getString("CONTACTS"));
		user.setType(rs.getString("TYPE"));
		user.setGender(rs.getString("GENDER"));
		user.setAddress(rs.getString("ADDRESS"));
		if (rs.getInt("IS_DISABLED") == 1) {
			user.setDisabled(true);
		} else {
			user.setDisabled(false);
		}
		return user;
	}

}