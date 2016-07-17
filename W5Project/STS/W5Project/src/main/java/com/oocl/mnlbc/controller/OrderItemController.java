/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrderItemsDAO;
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
	@RequestMapping(value = { "/getAllOrderItems/{orderId}" })
	public String getAllOrderItemsByOrderID(@PathVariable("orderId") int orderId) {
		List<OrderItems> orderItems = orderItemDAO.getAllOrderItemsByOrderID(orderId);
		StringBuffer buffer = new StringBuffer();
		for (OrderItems orderItem : orderItems) {
			buffer.append(orderItem).append("\n");
		}
		logger.info("Getting all order items by ID");
		return buffer.toString();
	}

	@RequestMapping(value = "/orderItemId/{id}", method = RequestMethod.GET)
	@ResponseBody
	public OrderItems getOrderItemsByID(@PathVariable("id") int id) {
		List<OrderItems> orderItems = orderItemDAO.getAllOrderItems();
		OrderItems orderItem = null;
		for (OrderItems orderItemL : orderItems) {
			if (orderItemL.getId() == id) {
				orderItem = orderItemL;
			}
		}
		logger.info("Getting order items by ID");
		return orderItem;
	}

	@ResponseBody
	@RequestMapping(value = { "/addOrderItem" }, method = RequestMethod.POST)
	public String addOrderItem(@RequestParam(required = true) String orderItems, HttpSession session) {
		System.out.println("yey");
		
//		OrderItems[] a = (OrderItems[]) orderItems;
		// for (OrderItems orderItem : orderItems) {
		// if (orderItemL.getCode().equals(code)) {
		// orderItem = orderItemL;
		// }
		// }
		return orderItems;
	}
}
