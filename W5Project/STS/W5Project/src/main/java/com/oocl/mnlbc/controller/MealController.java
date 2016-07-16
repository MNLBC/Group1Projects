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
	@RequestMapping(value = { "/getAllMeals" })
	public List<Meal>  getAllMeals() {
		List<Meal> meals = mealDAO.getAllMeals();
		logger.info("Getting all list of Meals");
		return meals;
	}

	@RequestMapping(value = "/mealId/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Meal getMealById(@PathVariable("id") int id) {
		List<Meal> meals = mealDAO.getAllMeals();
		Meal meal = null;
		for (Meal mealL : meals) {
			if (mealL.getId() == id) {
				meal = mealL;
			}
		}
		logger.info("Getting the meal by ID");
		return meal;
	}

	@RequestMapping(value = "/mealCode/{code}", method = RequestMethod.GET)
	@ResponseBody
	public Meal checkMealnameExistence(@PathVariable("code") String code) {
		List<Meal> meals = mealDAO.getAllMeals();
		Meal meal = null;
		for (Meal mealL : meals) {
			if (mealL.getCode().equals(code)) {
				meal = mealL;
			}
		}
		
		logger.info("Checking the emeal if Existing");
		return meal;
	}
}
