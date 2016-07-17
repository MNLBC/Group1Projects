/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.model.Order;

/**
 * @author BARREPE
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	final static Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	OrderDAO orderDAO;

	@ResponseBody
	@RequestMapping(value = { "/getAllOrder" })
	public String getAllOrder() {
		List<Order> orderItems = orderDAO.getAllOrder();
		StringBuffer buffer = new StringBuffer();
		for (Order orderItem : orderItems) {
			buffer.append(orderItem).append("\n");
		}
		logger.info("Getting all list of Order");
		return buffer.toString();
	}

	@ResponseBody
	@RequestMapping(value = { "/getAllOrderByUser" }, method = RequestMethod.POST)
	public List<Order> getAllOrderByUserID(@RequestParam(required = true) int userId) {
		List<Order> orders = orderDAO.getAllOrderByUserID(userId);
		logger.info("Getting all order by User ID");
		return orders;
	}

	@RequestMapping(value = "/getOrderById", method = RequestMethod.POST)
	@ResponseBody
	public Order getOrderByID(@RequestParam(required = true) int id) {
		Order order = orderDAO.getOrderByID(id);
		logger.info("Getting all order by ID");
		return order;
	}
}
