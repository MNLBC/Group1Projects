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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.service.OrderItemService;

/**
 * This is a controller for Order Item requests
 * 
 * @author RACELPA
 * @since 07/22/16
 */

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	/**
	 * Automatic instantiation of Order Item Service
	 */
	@Autowired
	OrderItemService orderItemService;

	/**
	 * This request is for getting all the order items.
	 * 
	 * @return the list of all order items
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllOrderItem", method = RequestMethod.GET)
	public List<OrderItem> getAllOrderItem() {
		return orderItemService.getAllOrderItem();
	}

	/**
	 * This request is for getting all the order items.
	 * 
	 * @param id
	 *            the id of the order to be retrieved
	 * @return the list of all order items
	 */
	@ResponseBody
	@RequestMapping(value = { "/getAllOrderItemsByOrderId" }, method = RequestMethod.POST)
	public List<OrderItem> getAllOrderItemsById(@RequestParam(required = true) int id) {
		return orderItemService.getAllOrderItemsById(id);
	}

	/**
	 * This request is for getting the order using the id.
	 * 
	 * @param id
	 *            the id of the order item to be retrieved
	 * @return an object of OrderItem
	 */
	@ResponseBody
	@RequestMapping(value = "/getOrderItemById/{id}", method = RequestMethod.GET)
	public OrderItem getOrderItemById(@PathVariable("id") int id) {
		return orderItemService.getOrderItemById(id);
	}

}
