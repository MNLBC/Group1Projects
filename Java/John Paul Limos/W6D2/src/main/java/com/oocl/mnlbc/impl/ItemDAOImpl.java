package com.oocl.mnlbc.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.ItemDAO;
import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.service.ItemServices;

public class ItemDAOImpl implements ItemDAO{

	@Override
	public Item getItemById(String id) {

		ItemServices itemServices = new ItemServices();
		itemServices.init();
		EntityManager em = itemServices.getEntityManager();
		Item returnItem = em.find(Item.class, id);

		return returnItem;

	}

}
