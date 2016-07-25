/**
 * 
 */
package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.MealDAO;
import com.oocl.mnlbc.entity.Meal;

/**
 * @author LIMOSJO
 *
 */
public class MealDAOImpl implements MealDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.MealDAO#getAllMeals()
	 */

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	@Override
	public List<Meal> getAllMeals() {
		Query query = entityManager.createQuery("select m from Meal m");
		List<Meal> mealList = query.getResultList();
		return mealList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.MealDAO#getMealByID(int)
	 */
	@Override
	public Meal getMealByID(int id) {

		Meal meal = (Meal) entityManager.find(Meal.class, id);
		return meal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.MealDAO#getMealByCode(java.lang.String)
	 */
	@Override
	public Meal getMealByCode(String code) {
		Query query = entityManager.createQuery("select m from Meal m where m.code = :code");
		query.setParameter("code", code);
		Meal meal = (Meal) query.getSingleResult();
		return meal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.MealDAO#addMeal(com.oocl.mnlbc.entity.Meal)
	 */
	@Override
	public Meal addMeal(Meal meal) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.MealDAO#init()
	 */
	@Override
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();
	}

}
