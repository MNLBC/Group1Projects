package com.oocl.mnlbc.controller;

import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.service.ItemService;

@RestController
public class ItemController {
	@RequestMapping(value = "/GET/item/{id}", method = RequestMethod.GET)
	public Item getItemById(@PathVariable("id") String id) {
		ItemService is = new ItemService();
		is.init();
		EntityManager em = is.getEntityManager();

		Item item = is.getItem(em, id);
		System.out.println(item);
		return item;
	}

}