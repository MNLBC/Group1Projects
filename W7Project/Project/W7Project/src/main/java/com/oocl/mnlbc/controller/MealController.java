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
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Meal;
import com.oocl.mnlbc.service.impl.MealService;


/**
 * @author LIMOSJO
 *
 */
@Controller
@RequestMapping("/meal")
public class MealController {

	@Autowired
	MealService mealService;
	
	@ResponseBody
	@RequestMapping(value = { "/getAllMeals" }, method = RequestMethod.GET)
	public List<Meal> getAllMeals() {
		return mealService.getAllMeals();
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getMealByID/{id}" }, method = RequestMethod.GET)
	public Meal getMealByID(@PathVariable("id") int id) {
		return mealService.getMealByID(id);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getMealByCode/{code}" }, method = RequestMethod.GET)
	public Meal getMealByCode(@PathVariable("code") String code) {
		return mealService.getMealByCode(code);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/addMeal" }, method = RequestMethod.POST)
	public boolean addMeal(@RequestBody Meal meal) {
		return mealService.addMeal(meal);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/updateMeal" }, method = RequestMethod.POST)
	public boolean updateMeal(@RequestBody Meal meal) {
		return mealService.updateMeal(meal);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/deleteMeal" }, method = RequestMethod.POST)
	public boolean deleteMeal(@RequestBody Meal meal) {
		return mealService.deleteMeal(meal);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/deleteMealById/{id}" }, method = RequestMethod.GET)
	public boolean deleteMealById(@PathVariable("id") int id) {
		return mealService.deleteById(id);
	}
}
