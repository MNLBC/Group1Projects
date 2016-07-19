package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.dao.ItemDAO;
import com.oocl.mnlbc.entity.Item;

public class ItemDAOImpl implements ItemDAO{
	
	EntityManagerFactory emfactory ;
	EntityManager entitymanager;
	
	@Override
	public void init(){
		emfactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entitymanager = emfactory.createEntityManager();
	}
	
	@Override
	public Item getOrderById(EntityManager em, String id) {
		Item order = (Item) em.find(Item.class, id);
		return order;
	}
	
	@Override
	public EntityManager getEntityManager() {
        return entitymanager;
    }

	@Override
	public List<Item> getAll(EntityManager em, String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
