/**
 * 
 */
package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
	
	
	public OrderItemDAOImpl(){
		setClazz(OrderItem.class );
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


}
