/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Order;

/**
 * @author RACELPA
 * @author DELEOAN
 */
public interface OrderDAO {

	public void init();

	public List<Order> getAllOrder();

	public Order getOrderById(int id);
	
	public List<Order> getOrderByUserId(int id);

	public Order addOrder(Order order);

	public EntityManager getEntityManager();

}
