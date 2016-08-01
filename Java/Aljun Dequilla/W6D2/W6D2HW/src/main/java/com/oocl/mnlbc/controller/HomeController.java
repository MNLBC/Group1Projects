package com.oocl.mnlbc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/GET/item/{id}", method = RequestMethod.GET)
	public Item getItemById(@PathVariable("id") String id) {
		ItemService itemService = new ItemService();
		EntityManager entityManager = itemService.getEntityManager();

		Item item = (Item) itemService.getItem(entityManager, id);

		return item;
	}
}
