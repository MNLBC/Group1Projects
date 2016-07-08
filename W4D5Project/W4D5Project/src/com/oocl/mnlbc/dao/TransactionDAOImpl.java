package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
	private static Date date = new Date();

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertMeal(Meal meal) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO MEAL(CODE,NAME,DESCRIPTION,CATEGORY,PRICE,IMAGE,DATE_CREATED,DATE_UPDATED) values(?,?,?,?,?,?,?,?)";
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
	public boolean insertProductGroup(int comboMealId, List<Meal> listMeal) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO PRODUCT_GROUP(COMBOMEALCODE,MEALCODE,DATE_CREATED,DATE_UPDATED) values(?,?,?,?)";
		Timestamp time = new Timestamp(date.getTime());
		PreparedStatement pstmt;
		try {
			for (Meal meal : listMeal) {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setInt(1, comboMealId);
				pstmt.setInt(2, meal.getId());
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
		Connection conn = db.getConn();
		String sql = "INSERT INTO ORDERS(USER_ID,STATUS,DATE_CREATED,DATE_UPDATED) values(?,?,?,?)";
		Timestamp time = new Timestamp(date.getTime());
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, order.getUserId());
			pstmt.setString(2, order.getStatus());
			pstmt.setTimestamp(3, time);
			pstmt.setTimestamp(4, time);
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
	public boolean insertOrderItem(int orderId, List<OrderItems> orderItemsList) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO ORDER_ITEMS(TYPE,ORDER_ID,MEAL_ID,QUANTITY,DATE_CREATED,DATE_UPDATED) values(?,?,?,?,?,?)";
		Timestamp time = new Timestamp(date.getTime());
		PreparedStatement pstmt;
		try {
			for (OrderItems orderItem : orderItemsList) {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, orderItem.getType());
				pstmt.setInt(2, orderId);
				pstmt.setInt(3, orderItem.getMealId());
				pstmt.setDouble(4, orderItem.getQuantity());
				pstmt.setTimestamp(5, time);
				pstmt.setTimestamp(6, time);
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
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meal> getMealsByName(String qName) {
		Connection conn = db.getConn();
		String sql = "SELECT CODE, ID, NAME, DESCRIPTION, CATEGORY, PRICE, IMAGE FROM MEAL WHERE NAME LIKE '%" + qName + "%' ORDER BY CODE";
		PreparedStatement pstmt;
		List<Meal> mealList = new ArrayList<Meal>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String code = rs.getString("CODE");
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");
				String category = rs.getString("CATEGORY");
				Double price = rs.getDouble("PRICE");
				String image = rs.getString("IMAGE");
				
				Meal meal = new Meal(code, name, description, category, price, image);
				meal.setId(id);
				mealList.add(meal);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mealList;
	}
	
	public List<Meal> getMealsByCategory(String qCategory) {
		Connection conn = db.getConn();
		String sql = "SELECT CODE, ID, NAME, DESCRIPTION, CATEGORY, PRICE, IMAGE FROM MEAL WHERE CATEGORY LIKE '%" + qCategory + "%' ORDER BY CODE";
		PreparedStatement pstmt;
		List<Meal> mealList = new ArrayList<Meal>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String code = rs.getString("CODE");
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");
				String category = rs.getString("CATEGORY");
				Double price = rs.getDouble("PRICE");
				String image = rs.getString("IMAGE");
				
				Meal meal = new Meal(code, name, description, category, price, image);
				meal.setId(id);
				mealList.add(meal);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mealList;
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

	public boolean checkIfExists(User user) {
		Connection conn = db.getConn();
		String sql = "SELECT USERNAME FROM USERS WHERE  USERNAME='"+user.getUserName()+"'";
		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
