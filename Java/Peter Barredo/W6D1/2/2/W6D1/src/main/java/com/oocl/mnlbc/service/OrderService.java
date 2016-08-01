package com.oocl.mnlbc.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.Teacher;

public class OrderService {
	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        entityManager = entityManagerFactory.createEntityManager();

    }

    public  Order getOrder(EntityManager em, Integer id) {
    	Order order = em.find(Order.class, id);
        return order;
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
