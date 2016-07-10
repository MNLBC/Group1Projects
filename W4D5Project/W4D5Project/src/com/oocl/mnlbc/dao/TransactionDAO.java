/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.models.ComboMeal;
import com.oocl.mnlbc.models.Meal;
import com.oocl.mnlbc.models.Order;
import com.oocl.mnlbc.models.OrderItems;
import com.oocl.mnlbc.models.User;

/**
 * @author Group1
 *
 */
public interface TransactionDAO {

	// Insert
	boolean insertUser(User user);

	boolean insertMeal(Meal meal);

	boolean insertComboMeal(ComboMeal comboMeal);

	boolean insertProductGroup(int comboMealId, Meal listMeal);

	boolean insertOrder(Order order);

	boolean insertOrderItem(int orderId, List<OrderItems> orderItemsList);

	boolean isUsernameExisting(String qUsername);

	boolean isEmailExisting(String qEmail);

	// Per Object
	Meal getMealByMealCode(String qCode);

	Meal getMealByMealName(String qName);

	ComboMeal getComboMealByComboCode(String qCode);

	ComboMeal getComboMealByComboMealName(String qName);

	int getMealIdByMealCode(String qCode);

	int getComboMealIdByComboCode(String qCode);

	User getUserByUserName(String qUserName);

	// Collection
	List<User> getUsers();

	List<Meal> getMealsByComboId(int qId);

	List<Meal> getMealsByName(String qName);

	List<Meal> getMealsByCategory(String qCategory);

	List<ComboMeal> getComboMeals();

	List<Order> getOrders();

	List<OrderItems> getOrderItems();

	// Delete

	boolean removeUser(int qId);
	
	// Update
	
	boolean updateUser(User user);
}
