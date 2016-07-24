/**
 * 
 */
package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.TrayDAO;
import com.oocl.mnlbc.entity.Tray;
import com.oocl.mnlbc.models.TrayReturnModel;

/**
 * @author LIMOSJO
 *
 */
public class TrayDAOImpl implements TrayDAO {
	
	EntityManagerFactory entityManagerFactory;
	
	EntityManager entityManager;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.TrayDAO#init()
	 */
	@Override
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.TrayDAO#getEntityManager()
	 */
	@Override
	public EntityManager getEntityManager() {
		return entityManager;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.TrayDAO#addTray(com.oocl.mnlbc.entity.Tray)
	 */
	@Override
	public boolean addTray(Tray tray) {
		entityManager.getTransaction().begin();
		entityManager.persist(tray);
		entityManager.getTransaction().commit();
		return true;
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
	 * @see com.oocl.mnlbc.dao.TrayDAO#removeTrayByUserId(int)
	 */
	@Override
	public boolean removeTray(Tray tray) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(tray);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			return false;
		}
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

}
