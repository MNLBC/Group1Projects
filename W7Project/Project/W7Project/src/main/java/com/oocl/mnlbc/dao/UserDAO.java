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
public interface UserDAO extends GenericDAO<User>{

	public User getUserByUsername(String username);

	public boolean checkUsernameExistence(String username);

	public boolean checkEmailExistence(String email);

}
