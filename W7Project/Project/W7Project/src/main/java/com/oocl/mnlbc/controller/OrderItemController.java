/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrderItemDAO;
import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author RACELPA
 *
 */

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	final static Logger logger = Logger.getLogger(OrderItemController.class);
	@Autowired
	OrderItemDAO orderItemDAO;

	@ResponseBody
	@RequestMapping(value = "/getAllOrderItem", method = RequestMethod.GET)
	public List<OrderItem> getAllOrderItem() {
		logger.info("Getting all order items");
		List<OrderItem> orderItemList = orderItemDAO.getAll();

		return orderItemList;
	}

	@ResponseBody
	@RequestMapping(value = { "/getAllOrderItemsByOrderId" }, method = RequestMethod.POST)
	public List<OrderItem> getAllOrderItemsById(@RequestParam(required = true) int id) {
		List<OrderItem> orderItemList = orderItemDAO.getAllOrderItemsByOrderId(id);
		logger.info("Getting all order items by Id");
		return orderItemList;
	}

	@ResponseBody
	@RequestMapping(value = "/getOrderItemById/{id}", method = RequestMethod.GET)
	public OrderItem getOrderItemById(@PathVariable("id") int id) {
		logger.info("Getting all orderItems by Id");
		OrderItem orderItem = orderItemDAO.find(id);
		return orderItem;
	}

}
