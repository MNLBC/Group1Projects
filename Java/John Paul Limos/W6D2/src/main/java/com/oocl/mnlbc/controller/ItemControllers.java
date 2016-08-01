package com.oocl.mnlbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.ItemDAO;
import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.impl.ItemDAOImpl;

@Controller
public class ItemControllers {

	@ResponseBody
	@RequestMapping("/GET/item/{id}")
	public Item itemReturn(@PathVariable("id") String id) {
		Item itemReturn = new Item();
		ItemDAO item = new ItemDAOImpl();
		itemReturn = item.getItemById(id);
		return itemReturn;
	}
}
