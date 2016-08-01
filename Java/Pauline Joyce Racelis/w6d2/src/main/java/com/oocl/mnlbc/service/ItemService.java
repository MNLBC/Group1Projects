package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Item;


public class ItemService {
	
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
