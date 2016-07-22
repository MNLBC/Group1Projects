/**
 * 
 */
package com.oocl.mnlbc;

import java.util.List;

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
	@Autowired
	MealDAO mealDAO;

	@ResponseBody
	@RequestMapping(value = { "/getAllMeals" }, method = RequestMethod.GET)
	public List<Meal> getAllMeals() {
		mealDAO.init();
		List<Meal> meals = mealDAO.getAllMeals();
//		logger.info("Getting all list of Meals");
		return meals;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getMealByID/{id}" }, method = RequestMethod.GET)
	public Meal getMealByID(@PathVariable("id") int id) {
		mealDAO.init();
		Meal meal =  mealDAO.getMealByID(id);
//		logger.info("Getting all list of Meals");
		return meal;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getMealByCode/{code}" }, method = RequestMethod.GET)
	public Meal getMealByCode(@PathVariable("code") String code) {
		mealDAO.init();
		Meal meal = mealDAO.getMealByCode(code);
//		logger.info("Getting all list of Meals");
		return meal;
	}
}
