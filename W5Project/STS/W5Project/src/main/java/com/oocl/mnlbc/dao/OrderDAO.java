package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.Order;

public interface OrderDAO {
	public void setDataSource(DataSource ds);

	public List<Order> getAllOrder();

	public List<Order> getAllOrderByUserID(int id);

	public Order getOrderByID(int id);

	public Order addOrderItem(Order order);
}
