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
	private static Timestamp time = new Timestamp(date.getTime());

	@Override
	public boolean insertUser(User user) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO USERS " + "(FIRSTNAME, MIDDLENAME, LASTNAME, ADDRESS, CONTACTS, EMAIL, GENDER, "
				+ " USERNAME, PASSWORD, TYPE, IMAGE, IS_DISABLED) " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getMiddleName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getContact());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getGender());
			pstmt.setString(8, user.getUserName());
			pstmt.setString(9, user.getPassword());
			pstmt.setString(10, user.getType());
			pstmt.setString(11, user.getImage());
			if (user.isDisabled()) {
				pstmt.setInt(12, 1);
			} else {
				pstmt.setInt(12, 0);
			}
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
	public boolean insertMeal(Meal meal) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO MEAL(CODE, NAME, DESCRIPTION, CATEGORY, PRICE, IMAGE) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, meal.getCode());
			pstmt.setString(2, meal.getName());
			pstmt.setString(3, meal.getDescription());
			pstmt.setString(4, meal.getCategory());
			pstmt.setDouble(5, meal.getPrice());
			pstmt.setString(6, meal.getImage());
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
		String sql = "INSERT INTO COMBO_MEAL(CODE, NAME, DESCRIPTION, PRICE, IMAGE) values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, comboMeal.getCode());
			pstmt.setString(2, comboMeal.getName());
			pstmt.setString(3, comboMeal.getDescription());
			pstmt.setDouble(4, comboMeal.getPrice());
			pstmt.setString(5, comboMeal.getImage());
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
	public boolean insertProductGroup(int comboMealId, Meal meal) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO PRODUCT_GROUP(COMBO_MEAL_ID, MEAL_ID) values(?, ?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, comboMealId);
			pstmt.setInt(2, meal.getId());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertOrder(Order order) {
		Connection conn = db.getConn();
		String sql = "INSERT INTO ORDERS(USER_ID, STATUS) values(?, ?)";
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, order.getUserId());
			pstmt.setString(2, order.getStatus());
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
		String sql = "INSERT INTO ORDER_ITEMS(TYPE, ORDER_ID, MEAL_ID, QUANTITY) values(?, ?, ?, ?)";
		PreparedStatement pstmt;
		try {
			for (OrderItems orderItem : orderItemsList) {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, orderItem.getType());
				pstmt.setInt(2, orderId);
				pstmt.setInt(3, orderItem.getMealId());
				pstmt.setInt(4, orderItem.getQuantity());
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
	public boolean isUsernameExisting(String userName) {
		Connection conn = db.getConn();
		String sql = "SELECT USERNAME FROM USERS WHERE USERNAME = '" + userName + "'";
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

	@Override
	public boolean isEmailExisting(String email) {
		Connection conn = db.getConn();
		String sql = "SELECT EMAIL FROM USERS WHERE EMAIL = '" + email + "'";
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

	@Override
	public List<User> getUsers() {
		Connection conn = db.getConn();
		String sql = "SELECT ID, FIRSTNAME, MIDDLENAME, LASTNAME, ADDRESS, CONTACTS, EMAIL, GENDER, "
				+ " USERNAME, PASSWORD, TYPE, IMAGE, IS_DISABLED FROM USERS ORDER BY ID";
		PreparedStatement pstmt;
		List<User> userList = new ArrayList<User>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String firstName = rs.getString("FIRSTNAME");
				String middleName = rs.getString("MIDDLENAME");
				String lastName = rs.getString("LASTNAME");
				String address = rs.getString("ADDRESS");
				String contact = rs.getString("CONTACTS");
				String email = rs.getString("EMAIL");
				String gender = rs.getString("GENDER");
				String userName = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String type = rs.getString("TYPE");
				String image = rs.getString("IMAGE");
				int disabled = rs.getInt("IS_DISABLED");
				boolean isDisabled = false;
				if (disabled == 1) {
					isDisabled = true;
				}

				User user = new User(firstName, lastName, middleName, address, contact, type, email, userName, password,
						gender, image, isDisabled);
				user.setId(id);
				userList.add(user);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<Meal> getMealsByName(String qName) {
		Connection conn = db.getConn();
		String sql = "SELECT CODE, ID, NAME, DESCRIPTION, CATEGORY, PRICE, IMAGE FROM MEAL WHERE NAME LIKE '%" + qName
				+ "%' ORDER BY ID";
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

				Meal meal = new Meal(id, code, name, description, category, price, image);
				mealList.add(meal);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mealList;
	}

	@Override
	public List<Meal> getMealsByCategory(String qCategory) {
		Connection conn = db.getConn();
		String sql = "SELECT CODE, ID, NAME, DESCRIPTION, CATEGORY, PRICE, IMAGE FROM MEAL WHERE CATEGORY LIKE '%"
				+ qCategory + "%' ORDER BY ID";
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

				Meal meal = new Meal(id, code, name, description, category, price, image);
				mealList.add(meal);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mealList;
	}

	@Override
	public List<Meal> getMealsByComboId(int qId) {
		Connection conn = db.getConn();
		String sql = "SELECT ML.* FROM PRODUCT_GROUP PG " + "JOIN COMBO_MEAL CM ON PG.COMBO_MEAL_ID = CM.ID "
				+ "JOIN MEAL ML ON PG.MEAL_ID = ML.ID" + " WHERE CM.ID = " + qId + "  ORDER BY ID";
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

				Meal meal = new Meal(id, code, name, description, category, price, image);
				mealList.add(meal);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mealList;
	}

	@Override
	public Meal getMealByMealCode(String qCode) {
		Connection conn = db.getConn();
		String sql = "SELECT ID, NAME, DESCRIPTION, CATEGORY, PRICE, IMAGE, CODE FROM MEAL WHERE CODE = '" + qCode
				+ "' ORDER BY ID";
		PreparedStatement pstmt;
		Meal meal = null;
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

				meal = new Meal(id, code, name, description, category, price, image);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return meal;
	}

	@Override
	public Meal getMealByMealName(String qName) {
		Connection conn = db.getConn();
		String sql = "SELECT ID, NAME, DESCRIPTION, CATEGORY, PRICE, IMAGE, CODE FROM MEAL WHERE NAME = '" + qName
				+ "' ORDER BY ID";
		PreparedStatement pstmt;
		Meal meal = null;
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

				meal = new Meal(id, code, name, description, category, price, image);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return meal;
	}

	@Override
	public ComboMeal getComboMealByComboCode(String qCode) {
		Connection conn = db.getConn();
		String sql = "SELECT ID, NAME, DESCRIPTION, PRICE, IMAGE, CODE FROM COMBO_MEAL WHERE CODE = '" + qCode
				+ "' ORDER BY ID";
		PreparedStatement pstmt;
		ComboMeal comboMeal = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String code = rs.getString("CODE");
				String name = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");
				Double price = rs.getDouble("PRICE");
				String image = rs.getString("IMAGE");

				comboMeal = new ComboMeal(id, code, name, description, price, image);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comboMeal;
	}

	@Override
	public ComboMeal getComboMealByComboMealName(String qName) {
		Connection conn = db.getConn();
		String sql = "SELECT ID, NAME, DESCRIPTION, PRICE, IMAGE, CODE FROM COMBO_MEAL WHERE NAME = '" + qName
				+ "' ORDER BY ID";
		PreparedStatement pstmt;
		ComboMeal comboMeal = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String code = rs.getString("CODE");
				String name = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");
				Double price = rs.getDouble("PRICE");
				String image = rs.getString("IMAGE");

				comboMeal = new ComboMeal(id, code, name, description, price, image);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comboMeal;
	}

	@Override
	public int getMealIdByMealCode(String qCode) {
		Connection conn = db.getConn();
		String sql = "SELECT ID FROM MEAL WHERE CODE = '" + qCode + "'  ORDER BY ID";
		PreparedStatement pstmt;
		int id = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("ID");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int getComboMealIdByComboCode(String qCode) {
		Connection conn = db.getConn();
		String sql = "SELECT ID FROM COMBO_MEAL WHERE CODE = '" + qCode + "' ORDER BY ID";
		PreparedStatement pstmt;
		int id = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("ID");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public User getUserByUserName(String qUserName) {
		Connection conn = db.getConn();
		String sql = "SELECT ID, FIRSTNAME, MIDDLENAME, LASTNAME, ADDRESS, CONTACTS, EMAIL, GENDER, "
				+ " USERNAME, PASSWORD, TYPE, IMAGE, IS_DISABLED FROM USERS WHERE USERNAME = '" + qUserName
				+ "' ORDER BY ID";
		PreparedStatement pstmt;
		User user = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String firstName = rs.getString("FIRSTNAME");
				String middleName = rs.getString("MIDDLENAME");
				String lastName = rs.getString("LASTNAME");
				String address = rs.getString("ADDRESS");
				String contact = rs.getString("CONTACTS");
				String email = rs.getString("EMAIL");
				String gender = rs.getString("GENDER");
				String userName = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String type = rs.getString("TYPE");
				String image = rs.getString("IMAGE");
				boolean isDisable = false;
				if (rs.getInt("IS_DISABLED") == 1) {
					isDisable = true;
				}
				user = new User(firstName, lastName, middleName, address, contact, type, email, userName, password,
						gender, image, isDisable);
				user.setId(id);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<ComboMeal> getComboMeals() {
		Connection conn = db.getConn();
		String sql = "SELECT ID, NAME, DESCRIPTION, PRICE, IMAGE, CODE FROM COMBO_MEAL ORDER BY ID";
		PreparedStatement pstmt;
		List<ComboMeal> comboMealList = new ArrayList<ComboMeal>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String code = rs.getString("CODE");
				String name = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");
				Double price = rs.getDouble("PRICE");
				String image = rs.getString("IMAGE");

				ComboMeal comboMeal = new ComboMeal(id, code, name, description, price, image);
				comboMealList.add(comboMeal);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comboMealList;
	}

	@Override
	public List<Order> getOrders() {
		Connection conn = db.getConn();
		String sql = "SELECT ID, USER_ID, STATUS FROM ORDERS ORDER BY ID";
		PreparedStatement pstmt;
		List<Order> orderList = new ArrayList<Order>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				int userId = rs.getInt("USER_ID");
				String status = rs.getString("STATUS");

				Order order = new Order(userId, status);
				orderList.add(order);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public List<OrderItems> getOrderItems() {
		Connection conn = db.getConn();
		String sql = "SELECT ID, TYPE, QUANTITY, MEAL_ID FROM ORDER ORDER BY ID";
		PreparedStatement pstmt;
		List<OrderItems> orderItemList = new ArrayList<OrderItems>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				int mealId = rs.getInt("MEAL_ID");
				String type = rs.getString("TYPE");
				int quantity = rs.getInt("QUANTITY");

				OrderItems orderItem = new OrderItems(id, type, quantity, mealId);
				orderItemList.add(orderItem);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Override
	public boolean removeUser(int qId) {
		Connection conn = db.getConn();
		String sql = "DELETE FROM USERS WHERE ID = ?";
		PreparedStatement pstmt;
		boolean isSuccess = false;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, qId);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public boolean updateUser(User user) {
		Connection conn = db.getConn();
		String sql = "UPDATE FROM USERS SET " + " FIRSTNAME = ?, MIDDLENAME = ?, LASTNAME = ?, "
				+ " ADDRESS = ?, CONTACTS = ?, EMAIL = ?, GENDER = ?, "
				+ " USERNAME = ?, PASSWORD = ?, TYPE = ?, IMAGE = ?, IS_DISABLED = ? " + "WHERE ID = ?";
		PreparedStatement pstmt;
		boolean isSuccess = false;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getMiddleName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getContact());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getGender());
			pstmt.setString(8, user.getUserName());
			pstmt.setString(9, user.getPassword());
			pstmt.setString(10, user.getType());
			pstmt.setString(11, user.getImage());
			if (user.isDisabled()) {
				pstmt.setInt(12, 1);
			} else {
				pstmt.setInt(12, 0);
			}
			pstmt.setInt(13, 1);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

}
