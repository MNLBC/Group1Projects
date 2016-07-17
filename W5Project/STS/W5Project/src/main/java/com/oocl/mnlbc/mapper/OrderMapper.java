/**
 * 
 */
package com.oocl.mnlbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.dao.OrderItemsDAO;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderItems;

/**
 * @author BARREPE
 *
 */
public class OrderMapper implements RowMapper<Order> {
	@Autowired
	OrderItemsDAO orderItemsDAO;

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setId(rs.getInt("ID"));
		order.setUserId(rs.getInt("USER_ID"));
		order.setStatus(rs.getString("STATUS"));
		List<OrderItems> orderItems = orderItemsDAO.getAllOrderItemsByOrderID(rs.getInt("ID"));
		order.setOrderItemList(orderItems);
		return order;
	}

}
