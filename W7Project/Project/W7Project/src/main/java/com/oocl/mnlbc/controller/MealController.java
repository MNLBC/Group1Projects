/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.MealDAO;
import com.oocl.mnlbc.entity.Meal;


/**
 * @author LIMOSJO
 *
 */
@Controller
@RequestMapping("/meal")
public class MealController {
	final static Logger logger = Logger.getLogger(MealController.class);
	@Autowired
	MealDAO mealDAO;

	@ResponseBody
	@RequestMapping(value = { "/getAllMeals" }, method = RequestMethod.GET)
	public List<Meal> getAllMeals() {
		List<Meal> meals = mealDAO.getAll();
		logger.info("Getting all list of Meals");
		return meals;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getMealByID/{id}" }, method = RequestMethod.GET)
	public Meal getMealByID(@PathVariable("id") int id) {
		Meal meal =  mealDAO.find(id);
		logger.info("Getting all list of Meals");
		return meal;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getMealByCode/{code}" }, method = RequestMethod.GET)
	public Meal getMealByCode(@PathVariable("code") String code) {
		Meal meal = mealDAO.getMealByCode(code);
		logger.info("Getting all list of Meals");
		return meal;
	}
}
