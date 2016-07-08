package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.oocl.mnlbc.db.DBConnect;
import com.oocl.mnlbc.models.ComboMeal;
import com.oocl.mnlbc.models.Meal;
import com.oocl.mnlbc.models.Order;
import com.oocl.mnlbc.models.OrderItems;
import com.oocl.mnlbc.models.User;

/**
 * 
 * @author Group 1
 *
 */
public class TransactionDAOImpl implements TransactionDAO {
	private static DBConnect db = new DBConnect();
	
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertMeal(Meal meal) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO MEAL(NAME,DESCRIPTION,CATEGORY,PRICE,IMAGE,DATE_CREATED,DATE_UPDATED) values(?,?,?,?,?,?,?)";
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1,meal.getName());
			pstmt.setString(2,meal.getDesc());
			pstmt.setString(3,meal.getCategory());
			pstmt.setDouble(4,meal.getPrice());
			pstmt.setString(5,meal.getImage());
			pstmt.setTimestamp(6, time);
			pstmt.setTimestamp(7, time);
			success = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (success > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean insertComboMeal(ComboMeal comboMeal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertOrderItem(OrderItems orderItems) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meal> getMeals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboMeal> getComboMeals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItems> getOrderItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
