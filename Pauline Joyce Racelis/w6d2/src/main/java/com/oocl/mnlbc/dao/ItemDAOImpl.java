package com.oocl.mnlbc.dao;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.service.ItemService;

public class ItemDAOImpl implements ItemDAO{

	@Override
	public Item getItems(String itemId) {
		Item item = new Item();
		ItemService itemService = new ItemService();
		
		itemService.init();
		EntityManager em = itemService.getEntityManager();
		item = em.find(Item.class, itemId);
		
		
		return item;
	}

}
