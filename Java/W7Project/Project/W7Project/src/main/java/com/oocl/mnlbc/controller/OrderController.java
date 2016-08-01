/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.service.OrderService;

/**
 * 
 * This is a controller for Order requests
 * 
 * @author DELEOAN
 * @author LIMOSJO
 * @since 07/22/16
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {
	/**
	 * Automatic instantiation of Order Service
	 */
	@Autowired
	OrderService orderService;

	/**
	 * This request is for getting all the orders.
	 * 
	 * @return the list of all orders
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
	public List<Order> getAllOrder() {
		return orderService.getAllOrder();
	}

	/**
	 * This request is for getting all the orders.
	 * 
	 * @param userId
	 *            the id of the user to be retrieved
	 * @return the list of all orders
	 */
	@ResponseBody
	@RequestMapping(value = { "/getAllOrderByUserId/{userId}" }, method = RequestMethod.GET)
	public List<Order> getAllOrderByUserID(@PathVariable("userId") int userId) {
		return orderService.getAllOrderByUserID(userId);
	}

	/**
	 * This request is for getting the order using the id.
	 * 
	 * @param id
	 *            the id of the order to be retrieved
	 * @return an object of Order
	 */
	@ResponseBody
	@RequestMapping(value = "/getOrderById/{id}", method = RequestMethod.GET)
	public Order getOrderById(@PathVariable("id") int id) {
		return orderService.getOrderById(id);
	}
	/**
	 * This request is for adding order
	 * 
	 * @param feedback
	 *            the feedback to be inserted
	 * @return a boolean result of insertion
	 */
	@ResponseBody
	@RequestMapping(value = { "/addOrder" }, method = RequestMethod.POST)
	public boolean addOrderItem(@RequestBody Order order) {
		return orderService.addOrderItem(order);
	}
	
	/**
	 * This request is for updating order
	 * 
	 * @param feedback
	 *            the feedback to be order
	 * @return a boolean result of update
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateOrder" }, method = RequestMethod.POST)
	public boolean updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}

}
