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
import com.oocl.mnlbc.service.impl.OrderService;

/**
 * @author DELEOAN
 * @author LIMOSJO
 *
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@ResponseBody
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
	public List<Order> getAllOrder() {
		return orderService.getAllOrder();
	}

	@ResponseBody
	@RequestMapping(value = { "/getAllOrderByUserId/{userId}" }, method = RequestMethod.GET)
	public List<Order> getAllOrderByUserID(@PathVariable("userId") int userId) {
		return orderService.getAllOrderByUserID(userId);
	}

	@ResponseBody
	@RequestMapping(value = "/getOrderById/{id}", method = RequestMethod.GET)
	public Order getOrderById(@PathVariable("id") int id) {
		return orderService.getOrderById(id);
	}

	@ResponseBody
	@RequestMapping(value = { "/addOrder" }, method = RequestMethod.POST)
	public boolean addOrderItem(@RequestBody Order order) {
		return orderService.addOrderItem(order);
	}

}
