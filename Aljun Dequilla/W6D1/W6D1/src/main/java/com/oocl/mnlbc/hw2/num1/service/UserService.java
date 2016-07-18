/**
 * 
 */
package com.oocl.mnlbc.hw2.num1.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.hw2.num1.model.User;

/**
 * @author DEQUIAL
 *
 */
public class UserService {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	/**
	 * 
	 */
	public UserService() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());
	}

	public Integer createUser(EntityManager em, User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user.getId();
	}

	public User getUser(EntityManager em, Integer id) {
		User user = em.find(User.class, id);
		return user;
	}

	public void removeUser(EntityManager em, User user) {
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
