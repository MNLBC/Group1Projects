/**
 * 
 */
package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.AbstractJPADAO;
import com.oocl.mnlbc.dao.GenericDAO;
import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.entity.Meal;
import com.oocl.mnlbc.entity.Order;

/**
 * @author RACELPA
 * @author DELEOAN
 * @author BARREPE
 *
 */
public class OrderDAOImpl  extends AbstractJPADAO<Order> implements OrderDAO{
	
	public OrderDAOImpl(){
		setClazz(Order.class );
	}
	
	@Override
	public List<Order> getOrderByUserId(int id) {
		return null;
	}

}
