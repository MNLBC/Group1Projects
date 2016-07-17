package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.Order;

/**
 * Serves as interface class for Order Implementation. Shows functions to be used
 * in database transactions related to user's order.
 * 
 * @author Group 1 
 * @since 07-18-2016
 */
public interface OrderDAO {
	public void setDataSource(DataSource ds);

	public List<Order> getAllOrder();

	public List<Order> getAllOrderByUserID(int id);

	public Order getOrderByID(int id);

	public Order addOrder(Order order);

	public int getCurrSeq();
}
