/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Meal;
import com.oocl.mnlbc.service.MealService;

/**
 * This is a controller for Meal requests
 * 
 * @author LIMOSJO
 * @since 07/22/16
 */
@Controller
@RequestMapping("/meal")
public class MealController {

	/**
	 * Automatic instantiation of Meal Service
	 */
	@Autowired
	MealService mealService;

	/**
	 * This request is for getting all the meals using GET.
	 * 
	 * @return the list of all meals
	 */
	@ResponseBody
	@RequestMapping(value = { "/getAllMeals" }, method = RequestMethod.GET)
	public List<Meal> getAllMeals() {
		return mealService.getAllMeals();
	}

	/**
	 * This request is for getting all the meals using GET.
	 * 
	 */
	// @ResponseBody
	// @RequestMapping(value = { "/upload" }, method = RequestMethod.GET)
	// public List<Meal> getAllMeals() {
	// return mealService.getAllMeals();
	// }

	/**
	 * This request is for getting meal using id by GET.
	 * 
	 * @param id
	 *            the id of the meal to be retrieved
	 * @return an object of Meal
	 */
	@ResponseBody
	@RequestMapping(value = { "/getMealByID/{id}" }, method = RequestMethod.GET)
	public Meal getMealByID(@PathVariable("id") int id) {
		return mealService.getMealByID(id);
	}

	/**
	 * This request is for getting meal using code by GET.
	 * 
	 * @param code
	 *            the code of the meal to be retrieved
	 * @return an object of Meal
	 */
	@ResponseBody
	@RequestMapping(value = { "/getMealByCode/{code}" }, method = RequestMethod.GET)
	public Meal getMealByCode(@PathVariable("code") String code) {
		return mealService.getMealByCode(code);
	}

	/**
	 * This request is for adding meal using POST.
	 * 
	 * @param meal
	 *            the meal to be inserted
	 * @return a boolean result of insertion
	 */
	@ResponseBody
	@RequestMapping(value = { "/addMeal" }, method = RequestMethod.POST)
	public boolean addMeal(@RequestBody Meal meal) {
		return mealService.addMeal(meal);
	}

	/**
	 * This request is for checking meal code if already exists using POST.
	 * 
	 * @param code
	 *            the code to be checked
	 * @return a boolean of checking
	 */
	@ResponseBody
	@RequestMapping(value = { "/checkMealCode" }, method = RequestMethod.POST)
	public boolean checkMealCode(@RequestParam(required = true) String code) {
		return mealService.checkMealCode(code);
	}

	/**
	 * This request is for updating meal
	 * 
	 * @param meal
	 *            the meal to be updated
	 * @return a boolean result of update
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateMeal" }, method = RequestMethod.POST)
	public boolean updateMeal(@RequestBody Meal meal) {
		return mealService.updateMeal(meal);
	}

	/**
	 * This request is for removing meal
	 * 
	 * @param meal
	 *            the meal to be removed
	 * @return a boolean result of deletion
	 */
	@ResponseBody
	@RequestMapping(value = { "/deleteMeal" }, method = RequestMethod.POST)
	public boolean deleteMeal(@RequestBody Meal meal) {
		return mealService.deleteMeal(meal);
	}

	/**
	 * This request is for removing meal using Id
	 * 
	 * @param id
	 *            the id of the meal to be removed
	 * @return a boolean result of deletion
	 */
	@ResponseBody
	@RequestMapping(value = { "/deleteMealById/{id}" }, method = RequestMethod.GET)
	public boolean deleteMealById(@PathVariable("id") int id) {
		return mealService.deleteById(id);
	}
}
