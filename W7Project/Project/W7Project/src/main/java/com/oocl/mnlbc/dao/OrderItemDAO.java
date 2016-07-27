/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author RACELPA
 *
 */
public interface OrderItemDAO extends GenericDAO<OrderItem> {

	public List<OrderItem> getAllOrderItemsByOrderId(int id);

	public boolean addOrderItems(List<OrderItem> orderItem);
}
