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
import com.oocl.mnlbc.entity.User;

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
		Query query = entityManager.createQuery("select o from Order o where o.user.id = :userId");
		query.setParameter("userId", id);
		return query.getResultList();
	}

}
