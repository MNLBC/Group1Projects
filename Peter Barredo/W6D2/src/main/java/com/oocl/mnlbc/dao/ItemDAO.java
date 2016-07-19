package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Item;

public interface ItemDAO {

	public void init();

	public Item getOrderById(EntityManager em, String id);

	public List<Item> getAll(EntityManager em, String id);

	public EntityManager getEntityManager();

}
