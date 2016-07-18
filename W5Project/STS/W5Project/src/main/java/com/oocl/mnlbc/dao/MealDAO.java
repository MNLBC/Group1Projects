package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.Meal;

/**
 * Serves as interface class for Meal Implementation. Shows functions to be used
 * in database transactions related to meals.
 * 
 * @author Group 1 
 * @since 07-18-2016
 */

public interface MealDAO {
	public void setDataSource(DataSource ds);

	public List<Meal> getAllMeals();

	public Meal getMealByID(int id);

	public Meal getMealByCode(String mealname);

	public Meal addMeal(Meal meal);

}
