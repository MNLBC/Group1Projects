package com.oocl.mnlbc.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

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
	
	public DataSource executeTestSource() {
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
		String query = "SELECT * FROM ORDERS WHERE USERS_ID = " + id;
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
	public Order addOrder(Order order) {
//		TransactionTemplate tt = new TransactionTemplate(getTransactionManager());
//		tt.execute(new TransactionCallback() {
//			public Object doInTransaction(TransactionStatus status) {
//				JdbcTemplate jt = new JdbcTemplate(executeTestSource());
//				StringBuilder query = new StringBuilder();
//				query.append(
//						"INSERT INTO USERS (USERNAME,PASSWORD,FIRSTNAME,MIDDLENAME,LASTNAME,GENDER,EMAIL,ADDRESS,CONTACTS,IS_DISABLED,TYPE) VALUES (");
//				query.append("'" + user.getUsername() + "',");
//				query.append("'" + user.getPassword() + "',");
//				query.append("'" + user.getFirstname() + "',");
//				query.append("'" + user.getMiddlename() + "',");
//				query.append("'" + user.getLastname() + "',");
//				query.append("'" + user.getGender() + "',");
//				query.append("'" + user.getEmail() + "',");
//				query.append("'" + user.getAddress() + "',");
//				query.append("'" + user.getContact() + "',");
//				query.append(user.isDisabled() ? "1" : "0" + ",");
//				query.append("'" + user.getType() + "')");
//				jt.update(query.toString());
//
//				return null;
//			}
//		});
//
//		return user;
	}

}
