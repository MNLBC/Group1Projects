package com.oocl.mnlbc.impl;

import javax.persistence.Query;

import com.oocl.mnlbc.dao.AbstractJPADAO;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;

/**
 * 
 * @author LIMOSJO
 *
 */
public class UserDAOImpl extends AbstractJPADAO<User> implements UserDAO {

	public UserDAOImpl() {
		setClazz(User.class);
	}

	@Override
	public User getUserByUsername(String username) {
		Query query = entityManager.createQuery("select u from User u where u.username = :username");
		query.setParameter("username", username);
		User userReturn = (User) query.getSingleResult();
		return userReturn;
	}

	@Override
	public User getUserByEmail(String email) {
		Query query = entityManager.createQuery("select u from User u where u.email = :email");
		query.setParameter("email", email);
		User userReturn = (User) query.getSingleResult();
		return userReturn;
	}

}
