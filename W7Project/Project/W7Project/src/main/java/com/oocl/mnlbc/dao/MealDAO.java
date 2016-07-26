/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.Meal;
import com.oocl.mnlbc.entity.Order;

/**
 * @author LIMOSJO
 *
 */
public interface MealDAO extends GenericDAO<Meal>{
	
	public Meal getMealByCode(String mealname);
	
}
