/**
 * 
 */
package com.oocl.mnlbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.OrderItems;

/**
 * @author BARREPE
 *
 */
public class OrderItemsMapper implements RowMapper<OrderItems> {

	@Override
	public OrderItems mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderItems orderItems = new OrderItems();
		orderItems.setId(rs.getInt("ID"));
		orderItems.setMealId(rs.getInt("MEAL_ID"));
		orderItems.setQuantity(rs.getInt("QUANTITY"));
		return orderItems;
	}

}
