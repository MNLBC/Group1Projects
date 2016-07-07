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

	boolean insertUser(User user);

	boolean insertMeal(Meal meal);

	boolean insertComboMeal(ComboMeal comboMeal);

	boolean insertOrder(Order order);

	boolean insertOrderItem(OrderItems orderItems);

	List<User> getUsers();

	List<Meal> getMeals();

	List<ComboMeal> getComboMeals();

	List<Order> getOrders();

	List<OrderItems> getOrderItems();

}
