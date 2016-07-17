/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.OrderItems;

/**
 * @author BARREPE
 *
 */
public interface OrderItemsDAO {
	public void setDataSource(DataSource ds);

	public List<OrderItems> getAllOrderItems();

	public List<OrderItems> getAllOrderItemsByOrderID(int id);

	public OrderItems getOrderItemsByID(int id);

	public OrderItems addOrderItem(OrderItems orderItem);
	
	public List<OrderItems> addOrderItems(int orderId, List<OrderItems> orderItems);
}
