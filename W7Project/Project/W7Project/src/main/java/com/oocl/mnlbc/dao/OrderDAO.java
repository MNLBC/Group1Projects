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
public interface OrderDAO extends GenericDAO<Order>{

	public List<Order> getOrderByUserId(int id);

}
