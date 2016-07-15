package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.User;

public interface UserDAO {
	
	public void setDataSource(DataSource ds);
	
	public List<User> getAllUsers();

	public User getUserByID(int id);

	public User getUserByUsername(String username);
	
	public User addUser(User user);
	
	public boolean checkUsernameExistence(String username);
	
	public boolean checkEmailExistence(String email);

}
