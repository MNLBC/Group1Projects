/**
 * 
 */
package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.Query;

import com.oocl.mnlbc.dao.AbstractJPADAO;
import com.oocl.mnlbc.dao.TrayDAO;
import com.oocl.mnlbc.entity.Tray;

/**
 * @author LIMOSJO
 *
 */
public class TrayDAOImpl extends AbstractJPADAO<Tray> implements TrayDAO {

	public TrayDAOImpl() {
		setClazz(Tray.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.TrayDAO#addTray(com.oocl.mnlbc.entity.Tray)
	 */
	@Override
	public boolean addListTray(List<Tray> trays) {

		entityManager.getTransaction().begin();
		for (Tray tray : trays) {
			entityManager.persist(tray);
		}
		entityManager.getTransaction().commit();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.TrayDAO#getAllTrayByUserId(int)
	 */
	@Override
	public List<Tray> getAllTrayByUserId(int id) {
		Query query = entityManager.createQuery("select t from Tray t where t.user.id = :id");
		query.setParameter("id", id);
		List<Tray> trays = query.getResultList();

		return trays;
	}

	@Override
	public List<Tray> getAllTrayByMealId(int id) {
		Query query = entityManager.createQuery("select t from Tray t where t.meal.id = :id");
		query.setParameter("id", id);
		List<Tray> trays = query.getResultList();
		return trays;
		
	}

}
