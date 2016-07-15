/***
 * 
 */
package com.oocl.mnlbc.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.oocl.mnlbc.dao.OrderItemsDAO;
import com.oocl.mnlbc.mapper.OrderItemsMapper;
import com.oocl.mnlbc.model.OrderItems;

/***
 * @author BARREPE
 *
 */
public class OrderItemsDAOImpl implements OrderItemsDAO {
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

	/**
	 * 
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemsDAO#setDataSource(javax.sql.DataSource)
	 */
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	/**
	 * 
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemsDAO#getAllOrderItems()
	 */
	@Override
	public List<OrderItems> getAllOrderItems() {
		String query = "SELECT * FROM ORDERITEMS";
		List<OrderItems> orderItems = jdbcTemplateObject.query(query, new OrderItemsMapper());
		return orderItems;
	}

	/**
	 * 
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemsDAO#getAllOrderItemsByOrderID(int)
	 */
	@Override
	public List<OrderItems> getAllOrderItemsByOrderID(int id) {
		String query = "SELECT * FROM ORDERITEMS WHERE ORDER_ID = " + id;
		List<OrderItems> orderItems = jdbcTemplateObject.query(query, new OrderItemsMapper());
		return orderItems;
	}

	/**
	 * 
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemsDAO#getOrderItemsByID(int)
	 */
	@Override
	public OrderItems getOrderItemsByID(int id) {
		String query = "SELECT * FROM users WHERE ID = " + id;
		OrderItems orderItem = jdbcTemplateObject.queryForObject(query, new OrderItemsMapper());
		return orderItem;
	}

	/**
	 * 
	 * 
	 * @see com.oocl.mnlbc.dao.OrderItemsDAO#addOrderItem(com.oocl.mnlbc.model.
	 *      OrderItems)
	 */
	@Override
	public OrderItems addOrderItem(OrderItems orderItem) {
		// TODO Auto-generated method stub
		return null;
	}

}
