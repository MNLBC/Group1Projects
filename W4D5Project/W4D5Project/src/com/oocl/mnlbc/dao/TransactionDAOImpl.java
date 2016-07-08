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
		String sql = "INSERT INTO MEAL(CODE,NAME,DESCRIPTION,CATEGORY,PRICE,IMAGE,DATE_CREATED,DATE_UPDATED) values(?,?,?,?,?,?,?,?)";
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, meal.getMealCode());
			pstmt.setString(2, meal.getName());
			pstmt.setString(3, meal.getDescription());
			pstmt.setString(4, meal.getCategory());
			pstmt.setDouble(5, meal.getPrice());
			pstmt.setString(6, meal.getImage());
			pstmt.setTimestamp(7, time);
			pstmt.setTimestamp(8, time);
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
		Connection conn = db.getConn();
		String sql = "INSERT INTO COMBOMEAL(CODE,NAME,DESCRIPTION,PRICE,IMAGE,DATE_CREATED,DATE_UPDATED) values(?,?,?,?,?,?,?,?)";
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, comboMeal.getComboMealCode());
			pstmt.setString(2, comboMeal.getName());
			pstmt.setString(3, comboMeal.getDescription());
			pstmt.setDouble(4, comboMeal.getPrice());
			pstmt.setString(5, comboMeal.getImage());
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
	public boolean insertProductGroup(String comboMealCode, List<Meal> listMeal) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO PRODUCT_GROUP(COMBOMEALCODE,MEALCODE,DATE_CREATED,DATE_UPDATED) values(?,?,?,?)";
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		PreparedStatement pstmt;
		try {
			for (Meal meal : listMeal) {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, comboMealCode);
				pstmt.setString(2, meal.getMealCode());
				pstmt.setTimestamp(3, time);
				pstmt.setTimestamp(4, time);
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
