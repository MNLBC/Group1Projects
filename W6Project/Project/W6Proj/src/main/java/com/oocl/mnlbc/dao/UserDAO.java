/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.User;

/**
 *
 */
public interface UserDAO {

	public void init();

	public User getUserById(int id);

	public List<User> getAllUsers();

	public User getUserByUsername(String username);

	public User addUser(User user);

	public boolean checkUsernameExistence(String username);

	public boolean checkEmailExistence(String email);
	
	public boolean updateUser(User user);

	public EntityManager getEntityManager();
}
