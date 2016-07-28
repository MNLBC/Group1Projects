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
 * @author RACELPA
 *
 */

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;

	@ResponseBody
	@RequestMapping(value = "/getAllOrderItem", method = RequestMethod.GET)
	public List<OrderItem> getAllOrderItem() {
		return orderItemService.getAllOrderItem();
	}

	@ResponseBody
	@RequestMapping(value = { "/getAllOrderItemsByOrderId" }, method = RequestMethod.POST)
	public List<OrderItem> getAllOrderItemsById(@RequestParam(required = true) int id) {
		return orderItemService.getAllOrderItemsById(id);
	}

	@ResponseBody
	@RequestMapping(value = "/getOrderItemById/{id}", method = RequestMethod.GET)
	public OrderItem getOrderItemById(@PathVariable("id") int id) {
		return orderItemService.getOrderItemById(id);
	}

}
