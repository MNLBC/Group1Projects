package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.dao.MealDAO;
import com.oocl.mnlbc.entity.Meal;

@Service
public class MealService {
	
	final static Logger logger = Logger.getLogger(MealService.class);

	@Autowired
	MealDAO mealDao;
	
	public List<Meal> getAllMeals(){
		logger.info("Getting all list of Meals");
		return mealDao.getAll();
	}
	
	public Meal getMealByID(int id){
		logger.info("Getting all list of Meals");
		return mealDao.find(id);
	}
	
	public Meal getMealByCode(String code){
		logger.info("Getting all list of Meals");
		return mealDao.getMealByCode(code);
	}
	
	public boolean addMeal(Meal meal){
		logger.info("Adding new meal");
		mealDao.add(meal);
		return true;
	}
	
	public boolean updateMeal(Meal meal){
		mealDao.update(meal);
		logger.info("Updating meal");
		return true;
	}
	
	public boolean deleteMeal(Meal meal){
		mealDao.delete(meal);
		logger.info("Deleting meal");
		return true;
	}

	public boolean deleteById(int id) {
		mealDao.deleteById(id);
		logger.info("Deleting meal by ID");
		return true;
	}

	public boolean checkMealCode(String code) {
		
		try {
			mealDao.getMealByCode(code);
			return true;
		} catch (NoResultException e) {
			return false;
		}
		
		
	}
}
