/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.OrderItems;

/**
 * Serves as interface class for OrderItems Implementation. Shows functions to
 * be used in database transactions related to the ordered items per order of
 * the user.
 * 
 * @author Group 1 
 * @since 07-18-2016
 */
public interface OrderItemsDAO {
	public void setDataSource(DataSource ds);

	public List<OrderItems> getAllOrderItems();

	public List<OrderItems> getAllOrderItemsByOrderID(int id);

	public OrderItems getOrderItemsByID(int id);

	public OrderItems addOrderItem(OrderItems orderItem);

	public List<OrderItems> addOrderItems(int orderId, List<OrderItems> orderItems);
}
