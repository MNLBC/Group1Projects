package com.oocl.mnlbc.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.dao.OrderItemsDAO;
import com.oocl.mnlbc.mapper.MealMapper;
import com.oocl.mnlbc.mapper.OrderMapper;
import com.oocl.mnlbc.model.Meal;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderItems;

public class OrderDAOImpl implements OrderDAO {
	private DataSource dataSource;
	private PlatformTransactionManager transactionManager;
	private JdbcTemplate jdbcTemplateObject;

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	@Override
	public List<Order> getAllOrder() {
		String query = "SELECT * FROM ORDERITEMS";
		List<Order> orderItems = jdbcTemplateObject.query(query, new OrderMapper());
		return orderItems;
	}

	@Override
	public List<Order> getAllOrderByUserID(int id) {
		String query = "SELECT * FROM ORDERITEMS WHERE USERS_ID = " + id;
		List<Order> orders = jdbcTemplateObject.query(query, new OrderMapper());
		for (Order order : orders) {
			OrderItemsDAO orderItemsDAO = new OrderItemsDAOImpl();
			List<OrderItems> orderItems = orderItemsDAO.getAllOrderItemsByOrderID(order.getId());
			order.setOrderItemList(orderItems);
		}
		return orders;
	}

	@Override
	public Order getOrderByID(int id) {
		String query = "SELECT * FROM users WHERE ID = " + id;
		Order order= jdbcTemplateObject.queryForObject(query, new OrderMapper());
		return order;
	}

	@Override
	public Order addOrderItem(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
