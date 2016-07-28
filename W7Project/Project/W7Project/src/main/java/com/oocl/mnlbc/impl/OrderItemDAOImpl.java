/**
 * 
 */
package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.Query;

import com.oocl.mnlbc.dao.AbstractJPADAO;
import com.oocl.mnlbc.dao.OrderItemDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author RACELPA
 *
 */
public class OrderItemDAOImpl extends AbstractJPADAO<OrderItem> implements OrderItemDAO {

	public OrderItemDAOImpl() {
		setClazz(OrderItem.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemDAO#getAllOrderItemsByOrderId(int)
	 */
	@Override
	public List<OrderItem> getAllOrderItemsByOrderId(int id) {
		Query query = entityManager.createQuery("select oi from OrderItem oi where oi.order.id= :orderId");
		query.setParameter("orderId", id);
		List<OrderItem> orderItemList = query.getResultList();
		return orderItemList;
	}

	@Override
	public boolean addOrderItems(List<OrderItem> orderItems) {
		entityManager.getTransaction().begin();
		for (OrderItem orderItem : orderItems) {
			entityManager.persist(orderItem);
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	@Override
	public List<OrderItem> getOrderItemByMealId(int mealId) {
		Query query = entityManager.createQuery("select o from OrderItem o where o.meal.id = :mealId");
		query.setParameter("mealId", mealId);
		return query.getResultList();
	}

}
