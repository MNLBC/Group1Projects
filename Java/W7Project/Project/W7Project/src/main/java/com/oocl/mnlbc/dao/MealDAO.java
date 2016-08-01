/**
 * 
 */
package com.oocl.mnlbc.dao;

import com.oocl.mnlbc.entity.Meal;

/**
 * @author LIMOSJO
 *
 */
public interface MealDAO extends GenericDAO<Meal> {

	public Meal getMealByCode(String mealname);

}
