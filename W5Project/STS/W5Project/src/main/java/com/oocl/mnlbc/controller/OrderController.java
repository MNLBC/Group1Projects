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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.dao.OrderItemsDAO;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.User;

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

	@Autowired
	OrderItemsDAO orderItemsDAO;

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

	@ResponseBody
	@RequestMapping(value = { "/addOrder" }, method = RequestMethod.POST)
	public String addOrderItem(@RequestParam(required = true) String order, HttpSession session) {
		ObjectMapper mapper = new ObjectMapper();
		Order orderMapped = null;
		try {
			orderMapped = mapper.readValue(order, Order.class);
			User user = (User) session.getAttribute("user");
			orderMapped.setUserId(user.getId());
			orderDAO.addOrder(orderMapped);
			orderMapped.setId(orderDAO.getCurrSeq());
			orderItemsDAO.addOrderItems(orderMapped.getId(), orderMapped.getOrderItemList());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "DONE";
	}
}
