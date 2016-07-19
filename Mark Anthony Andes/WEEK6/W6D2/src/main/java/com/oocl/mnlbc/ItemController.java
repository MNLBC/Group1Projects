package com.oocl.mnlbc;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.model.Item;
import com.oocl.mnlbc.service.ItemService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ItemController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@ResponseBody
	@RequestMapping(value = "GET/item/{id}", method = RequestMethod.GET )
	public Item getItemById(@PathVariable("id") String id) {
		
		ItemService itemService = new ItemService();
		itemService.init();
		 EntityManager em =  itemService.getEntityManager();
		Item item = new Item();
		item = itemService.getItem(em, id);
		
		return item;
	}
	

	
}
