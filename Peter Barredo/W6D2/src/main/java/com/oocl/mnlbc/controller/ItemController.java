package com.oocl.mnlbc.controller;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.ItemDAO;
import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.impl.ItemDAOImpl;

@Controller
public class ItemController {
	
	@Autowired
	ItemDAO dao;
	
	@ResponseBody
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public Item getItemById(@PathVariable("id") String id) {
		dao.init();
		EntityManager em = dao.getEntityManager();
		Item item = dao.getOrderById(em, id);
		
		return item;
	}
	
}
