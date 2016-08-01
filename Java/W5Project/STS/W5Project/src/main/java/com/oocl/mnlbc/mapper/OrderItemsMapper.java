/**
 * 
 */
package com.oocl.mnlbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.OrderItems;

/**
 * RowMapper implementation class OrderItemsMapper. Maps every record in query
 * to OrderItems model.
 * 
 * @author Group 1 
 * @since 07-18-2016
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
