package com.oocl.mnlbc.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ItemServices {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
