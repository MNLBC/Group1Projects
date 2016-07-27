package com.oocl.mnlbc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.dao.OrderItemDAO;
import com.oocl.mnlbc.entity.OrderItem;

@Service
public class OrderItemService {
	
	final static Logger logger = Logger.getLogger(OrderItemService.class);
	
	@Autowired
	OrderItemDAO orderItemDao;
	
	public List<OrderItem> getAllOrderItem(){
		logger.info("Getting all order items");
		return orderItemDao.getAll();
	}
	
	public List<OrderItem> getAllOrderItemsById(int id){
		return orderItemDao.getAllOrderItemsByOrderId(id);
	}
	
	public OrderItem getOrderItemById(int id){
		logger.info("Getting all orderItems by Id");
		return orderItemDao.find(id); 
	}
	
}
