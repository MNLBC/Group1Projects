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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.MealDAO;
import com.oocl.mnlbc.model.Meal;

/**
 * @author BARREPE
 *
 */
@Controller
@RequestMapping("/meal")
public class MealController {
	final static Logger logger = Logger.getLogger(MealController.class);
	@Autowired
	MealDAO mealDAO;

	@ResponseBody
	@RequestMapping(value = { "/getAllMeals" }, method = RequestMethod.POST)
	public List<Meal> getAllMeals() {
		List<Meal> meals = mealDAO.getAllMeals();
		logger.info("Getting all list of Meals");
		return meals;
	}

	@ResponseBody
	@RequestMapping(value = "/mealId", method = RequestMethod.POST)
	public Meal getMealById(@RequestParam(required = true) int id) {
		logger.info("Getting the meal by ID");
		List<Meal> meals = mealDAO.getAllMeals();
		for (Meal meal : meals) {
			if (meal.getId() == id) {
				return meal;
			}
		}
		return null;
	}

	@RequestMapping(value = "/mealCode", method = RequestMethod.POST)
	@ResponseBody
	public Meal getMealByCode(@RequestParam(required = true) String code) {
		logger.info("Getting the meal by Code");
		List<Meal> meals = mealDAO.getAllMeals();
		for (Meal meal : meals) {
			if (meal.getCode().equals(code)) {
				return meal;
			}
		}
		return null;
	}
}
