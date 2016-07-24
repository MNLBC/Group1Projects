/**
 * 
 */
package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.OrderItemDAO;
import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author RACELPA
 *
 */
public class OrderItemDAOImpl implements OrderItemDAO {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemDAO#init()
	 */
	@Override
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemDAO#getAllOrderItems()
	 */
	@Override
	public List<OrderItem> getAllOrderItems() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select oi from OrderItem oi");
		List<OrderItem> orderItemList = query.getResultList();
		return orderItemList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemDAO#getAllOrderItemsByOrderId(int)
	 */
	@Override
	public List<OrderItem> getAllOrderItemsByOrderId(int id) {
		Query query = entityManager.createQuery("select oi from OrderItem oi where oi.order.id= :orderItemId");
		query.setParameter("orderItemId", id);
		List<OrderItem> orderItemList = query.getResultList();
		return orderItemList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemDAO#getOrderItemsById(int)
	 */
	@Override
	public OrderItem getOrderItemsById(int id) {
		OrderItem orderItem = (OrderItem) entityManager.find(OrderItem.class, id);
		return orderItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemDAO#addOrderItem(com.oocl.mnlbc.entity.
	 * OrderItem)
	 */
	@Override
	public boolean addOrderItem(List<OrderItem> orderItems) {
		entityManager.getTransaction().begin();
		for (OrderItem orderItem : orderItems) {
			entityManager.persist(orderItem);
		}
		entityManager.getTransaction().commit();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemDAO#addOrderItem(int, java.util.List)
	 */
	@Override
	public List<OrderItem> addOrderItem(int orderId, List<OrderItem> orderItem) {
		entityManager.getTransaction().begin();
		entityManager.persist(orderItem);
		entityManager.getTransaction().commit();
		return orderItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemDAO#getEntityManager()
	 */
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
