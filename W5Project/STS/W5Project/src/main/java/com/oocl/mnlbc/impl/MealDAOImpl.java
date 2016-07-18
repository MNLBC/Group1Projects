package com.oocl.mnlbc.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.oocl.mnlbc.dao.MealDAO;
import com.oocl.mnlbc.mapper.MealMapper;
import com.oocl.mnlbc.mapper.UserMapper;
import com.oocl.mnlbc.model.Meal;
import com.oocl.mnlbc.model.User;

/**
 * Implements the MealDAO to specify the actions that will be done by
 * each methods. 
 * 
 * @author Group 1 
 * @since 07-18-2016
 */
public class MealDAOImpl implements MealDAO {
	private DataSource dataSource;
	private PlatformTransactionManager transactionManager;
	private JdbcTemplate jdbcTemplateObject;

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public List<Meal> getAllMeals() {
		String query = "SELECT * FROM MEAL";
		List<Meal> meal = jdbcTemplateObject.query(query, new MealMapper());
		return meal;
	}

	@Override
	public Meal getMealByID(int id) {
		String query = "SELECT * FROM users WHERE ID = " + id;
		Meal meal = jdbcTemplateObject.queryForObject(query, new MealMapper());
		return meal;
	}

	@Override
	public Meal getMealByCode(String code) {
		String query = "SELECT * FROM users WHERE CODE = '" + code + "'";
		Meal meal = jdbcTemplateObject.queryForObject(query, new MealMapper());
		return meal;
	}

	@Override
	public Meal addMeal(Meal meal) {
		// TODO Auto-generated method stub
		return null;
	}

}
