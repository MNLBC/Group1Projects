/**
 * 
 */
package com.oocl.mnlbc.impl;

import javax.persistence.Query;

import com.oocl.mnlbc.dao.AbstractJPADAO;
import com.oocl.mnlbc.dao.MealDAO;
import com.oocl.mnlbc.entity.Meal;

/**
 * @author LIMOSJO
 *
 */
public class MealDAOImpl extends AbstractJPADAO<Meal> implements MealDAO {

	public MealDAOImpl() {
		setClazz(Meal.class);
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

}
