/**
 * 
 */
package com.oocl.mnlbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.Meal;

/**
 * RowMapper implementation class MealMapper. Maps every record in query to meal
 * model.
 * 
 * @author Group 1 
 * @since 07-18-2016
 */
public class MealMapper implements RowMapper<Meal> {

	@Override
	public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
		Meal meal = new Meal();
		meal.setId(rs.getInt("ID"));
		meal.setCode(rs.getString("Code"));
		meal.setName(rs.getString("Name"));
		meal.setDescription(rs.getString("Description"));
		meal.setCategory(rs.getString("CATEGORY"));
		meal.setImage(rs.getString("IMAGE"));
		meal.setPrice(rs.getDouble("PRICE"));
		return meal;
	}

}
