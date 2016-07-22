package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;

/**
 * 
 * @author LIMOSJO
 *
 */
public class UserDAOImpl implements UserDAO {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	@Override
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public User getUserById(int id) {
		User user = (User) entityManager.find(User.class, id);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Query query = entityManager.createQuery("select u from User u");
		List<User> userList = query.getResultList();
		return userList;
	}

	@Override
	public User getUserByUsername(String username) {
		Query query = entityManager.createQuery("select u from User u where u.username = :username");
		query.setParameter("username", username);
		User userReturn = (User) query.getSingleResult();
		return userReturn;
	}

	@Override
	public User addUser(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		return user;
	}

	@Override
	public boolean checkUsernameExistence(String username) {

		Query query = entityManager.createQuery("select u from User u where u.username = :username");
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkEmailExistence(String email) {
		Query query = entityManager.createQuery("select u from User u where u.email = :email");
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
