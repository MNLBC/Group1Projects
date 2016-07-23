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

/**
 * @author LIMOSJO
 *
 */
public class TrayDAOImpl implements TrayDAO{
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.TrayDAO#init()
	 */
	@Override
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();
	}

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.TrayDAO#getTrayByUserId(int)
	 */
	@Override
	public Tray getTrayByUserId(int id) {
		Query query = entityManager.createQuery("select t from tray where t.user.id = :id");
		query.setParameter("id", id);
		Tray tray = (Tray) query.getSingleResult();
		return tray;
	}

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.TrayDAO#getEntityManager()
	 */
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
		
	}

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.TrayDAO#addTray(com.oocl.mnlbc.entity.Tray)
	 */
	@Override
	public Tray addTray(Tray tray) {
		entityManager.getTransaction().begin();
		entityManager.persist(tray);
		entityManager.getTransaction().commit();
		return tray;
	}

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.TrayDAO#removeTrayByUserId(int)
	 */
	@Override
	public Tray removeTrayByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
