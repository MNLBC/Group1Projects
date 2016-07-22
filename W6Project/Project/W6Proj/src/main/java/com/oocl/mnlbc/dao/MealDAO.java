/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.Meal;

/**
 * @author LIMOSJO
 *
 */
public interface MealDAO {
	public List<Meal> getAllMeals();

	public Meal getMealByID(int id);

	public Meal getMealByCode(String mealname);

	public Meal addMeal(Meal meal);

	public void init();
}
