/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author RACELPA
 *
 */
public interface OrderItemDAO {
	public void init();
	
	public List<OrderItem> getAllOrderItems();
	
	public List<OrderItem> getAllOrderItemsByOrderId(int id);
	
	public OrderItem getOrderItemsById(int id);
	
	public boolean addOrderItem(List<OrderItem> orderItem);
	
	public List<OrderItem> addOrderItem(int orderId, List<OrderItem> orderItem);
	
	public EntityManager getEntityManager();
	

}
