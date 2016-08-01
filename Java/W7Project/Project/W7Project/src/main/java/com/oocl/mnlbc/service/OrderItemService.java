package com.oocl.mnlbc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.dao.MealDAO;
import com.oocl.mnlbc.dao.OrderItemDAO;
import com.oocl.mnlbc.entity.Meal;
import com.oocl.mnlbc.entity.OrderItem;

@Service
public class OrderItemService {
	
	final static Logger logger = Logger.getLogger(OrderItemService.class);
	
	@Autowired
	OrderItemDAO orderItemDao;
	
	@Autowired
	MealDAO mealDao;
	
	public List<OrderItem> getAllOrderItem(){
		logger.info("Getting all order items");
		return orderItemDao.getAll();
	}
	
	public List<OrderItem> getAllOrderItemsById(int id){
		List<OrderItem> orderItems = orderItemDao.getAllOrderItemsByOrderId(id);
		for (OrderItem orderItem : orderItems) {
			Meal meal = mealDao.find(orderItem.getMeal().getId());
			orderItem.setMeal(meal);
		}
		
		return orderItems;
	}
	
	public OrderItem getOrderItemById(int id){
		logger.info("Getting all orderItems by Id");
		return orderItemDao.find(id); 
	}
	
}
