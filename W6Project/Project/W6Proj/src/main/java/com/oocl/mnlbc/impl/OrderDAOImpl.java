/**
 * 
 */
package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.User;

/**
 * @author RACELPA
 * @author DELEOAN
 *
 */
public class OrderDAOImpl implements OrderDAO {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	@Override
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();

	}

	@Override
	public List<Order> getAllOrder() {
		Query query = entityManager.createQuery("select o from Order o");
		@SuppressWarnings("unchecked")
		List<Order> orderList = query.getResultList();
		return orderList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderDAO#getAllOrderByOrderID(javax.persistence.
	 * EntityManager, int)
	 */
	public Order getOrderByUserId(int id) {
		Order order = (Order) entityManager.find(Order.class, id);
		return order;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderDAO#addOrder(com.oocl.mnlbc.entity.Order)
	 */
	@Override
	public Order addOrder(Order order) {
		entityManager.getTransaction().begin();
		entityManager.persist(order);
		entityManager.getTransaction().commit();
		return order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderDAO#getEntityManager()
	 */
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
}
