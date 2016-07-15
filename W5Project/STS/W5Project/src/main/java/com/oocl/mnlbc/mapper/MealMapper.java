/**
 * 
 */
package com.oocl.mnlbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.Meal;

/**
 * @author BARREPE
 *
 */
public class MealMapper implements RowMapper<Meal> {

	@Override
	public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
		Meal meal = new Meal();
		meal.setId(rs.getInt("ID"));
		meal.setCode(rs.getString("Code"));
		meal.setName(rs.getString("Name"));
		meal.setDescription(rs.getString("Description"));
		return meal;
	}

}
