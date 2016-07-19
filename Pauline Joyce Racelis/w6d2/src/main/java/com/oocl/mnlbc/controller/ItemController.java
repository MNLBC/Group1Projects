package com.oocl.mnlbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.ItemDAO;
import com.oocl.mnlbc.dao.ItemDAOImpl;
import com.oocl.mnlbc.entity.Item;


@Controller
public class ItemController {
	@ResponseBody
	@RequestMapping("/GET/item/{id}")
	public Item getItem(@PathVariable("id") String id){
		Item item = new Item();
		ItemDAO itemDAO = new ItemDAOImpl();
		item = itemDAO.getItems(id);
				
				
		return item;
		
	}
	
	

}
