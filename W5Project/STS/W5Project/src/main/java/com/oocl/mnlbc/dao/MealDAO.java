package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.Meal;

public interface MealDAO {
	public void setDataSource(DataSource ds);

	public List<Meal> getAllMeals();

	public Meal getMealByID(int id);

	public Meal getMealByCode(String mealname);

	public Meal addMeal(Meal meal);

}
