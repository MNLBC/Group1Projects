/**
 * 
 */
package com.oocl.mnlbc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.dao.MealDAO;
import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.dao.OrderItemDAO;
import com.oocl.mnlbc.entity.Meal;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author BARREPE
 *
 */
@Service
public class OrderService {

	final static Logger logger = Logger.getLogger(OrderService.class);

	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	OrderItemDAO orderItemDao;
	
	@Autowired
	MealDAO mealDao;
	
	public List<Order> getAllOrder(){
		logger.info("Getting all list of Order");
		return orderDao.getAll();
	}
	
	public List<Order> getAllOrderByUserID(int userId){
		logger.info("Getting all order by User ID");
//		List<Order> orders = orderDao.getOrderByUserId(userId);
//		
//		for (Order order : orders) {
//			List<OrderItem> orderItems = order.getOrderItemList();
//			for (OrderItem orderItem : orderItems) {
//				Meal meal = mealDao.find(orderItem.getMeal().getId());
//				orderItem.setMeal(meal);
//			}
//		}
		
		return orderDao.getOrderByUserId(userId);
	}
	
	public Order getOrderById(int id){
		logger.info("Getting all order by ID");
		return orderDao.find(id);
	}
	
	public boolean addOrderItem(Order order){
		List<OrderItem> orderItems = order.getOrderItemList();
		order.setOrderItemList(null);
		orderDao.add(order);
		
		for (OrderItem orderItem : orderItems) {
			Order orderItemsOrder = orderItem.getOrder();
			orderItemsOrder.setId(order.getId());
		}
		orderItemDao.addOrderItems(orderItems);
		
		return true;
	}

	public boolean updateOrder(Order order) {
		orderDao.update(order);
		return true;
	}

}
