package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.User;

/**
 * Serves as interface class for User Implementation. Shows functions to be used
 * in database transactions related to registration, login and user data. Also
 * contains checking of username and email are already in use.
 * 
 * @author Group 1 
 * @since 07-18-2016
 */
public interface UserDAO {

	public void setDataSource(DataSource ds);

	public List<User> getAllUsers();

	public User getUserByID(int id);

	public User getUserByUsername(String username);

	public User addUser(User user);

	public boolean checkUsernameExistence(String username);

	public boolean checkEmailExistence(String email);

}
