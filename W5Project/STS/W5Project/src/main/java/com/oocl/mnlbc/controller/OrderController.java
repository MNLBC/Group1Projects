/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		return buffer.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getAllOrder/{userId}" })
	public String getAllOrderByOrderID(@PathVariable("userId") int userId) {
		List<Order> orderItems = orderDAO.getAllOrderByUserID(userId);
		StringBuffer buffer = new StringBuffer();
		for (Order orderItem : orderItems) {
			buffer.append(orderItem).append("\n");
		}
		return buffer.toString();
	}

	@RequestMapping(value = "/orderItemId/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Order getOrderByID(@PathVariable("id") int id) {
		List<Order> orderItems = orderDAO.getAllOrder();
		Order orderItem = null;
		for (Order orderItemL : orderItems) {
			if (orderItemL.getId() == id) {
				orderItem = orderItemL;
			}
		}
		return orderItem;
	}
}
