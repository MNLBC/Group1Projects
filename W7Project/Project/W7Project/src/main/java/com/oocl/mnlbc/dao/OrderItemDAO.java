/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author RACELPA
 *
 */
public interface OrderItemDAO extends GenericDAO<OrderItem>{
	
	public List<OrderItem> getAllOrderItemsByOrderId(int id);
	
}
