/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrderItemsDAO;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderItems;

/**
 * @author BARREPE
 *
 */
@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	final static Logger logger = Logger.getLogger(OrderItemController.class);
	@Autowired
	OrderItemsDAO orderItemDAO;

	@ResponseBody
	@RequestMapping(value = { "/getAllOrderItems" })
	public List<OrderItems> getAllOrderItems() {
		List<OrderItems> orderItems = orderItemDAO.getAllOrderItems();
		logger.info("Getting all order items");
		return orderItems;
	}

	@ResponseBody
	@RequestMapping(value = { "/getAllOrderItemsById" }, method = RequestMethod.POST)
	public List<OrderItems> getAllOrderItemsByOrderID(@RequestParam(required = true) int orderId) {
		List<OrderItems> orderItems = orderItemDAO.getAllOrderItemsByOrderID(orderId);
		logger.info("Getting all order items by ID");
		return orderItems;
	}

	@ResponseBody
	@RequestMapping(value = "/orderItemId", method = RequestMethod.POST)
	public OrderItems getOrderItemsByID(@RequestParam(required = true) int id) {
		List<OrderItems> orderItems = orderItemDAO.getAllOrderItems();
		for (OrderItems orderItem : orderItems) {
			if (orderItem.getId() == id) {
				return orderItem;
			}
		}
		logger.info("Getting order items by ID");
		return null;
	}
	
}
