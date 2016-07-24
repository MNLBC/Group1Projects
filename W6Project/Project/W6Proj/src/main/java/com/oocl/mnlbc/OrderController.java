/**
 * 
 */
package com.oocl.mnlbc;

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

import com.oocl.mnlbc.dao.MealDAO;
import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.dao.OrderItemDAO;
import com.oocl.mnlbc.entity.Meal;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author DELEOAN
 * @author LIMOSJO
 *
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {
	final static Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	OrderDAO orderDao;

	@Autowired
	OrderItemDAO orderItemDao;

	@ResponseBody
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
	public List<Order> getAllOrder() {
		orderDao.init();
		// logger.info("Getting all list of Order");
		List<Order> orderList = orderDao.getAllOrder();
		return orderList;
	}

	@ResponseBody
	@RequestMapping(value = { "/getAllOrderByUserId" }, method = RequestMethod.POST)
	public List<Order> getAllOrderByUserID(@RequestParam(required = true) int userId) {
		orderDao.init();
		List<Order> orderList = orderDao.getOrderByUserId(userId);
		// logger.info("Getting all order by User ID");
		return orderList;
	}

	@ResponseBody
	@RequestMapping(value = "/getOrderById/{id}", method = RequestMethod.GET)
	public Order getOrderById(@PathVariable("id") int id) {
		orderDao.init();
		/// logger.info("Getting all order by ID");
		Order order = orderDao.getOrderById(id);
		return order;
	}

	@ResponseBody
	@RequestMapping(value = { "/addOrder" }, method = RequestMethod.POST)
	public String addOrderItem(@RequestBody Order order) {
		orderDao.init();
		orderItemDao.init();
//		mealDao.init();
//		for(OrderItem item : order.getOrderItemList()){
//			Meal meal = mealDao.getMealByID(item.getMeal().getId());
//			item.setMeal(meal);
//		}
		List<OrderItem> orderItems = order.getOrderItemList();
		order.setOrderItemList(null);
		orderDao.addOrder(order);
		
		for (OrderItem orderItem : orderItems) {
			orderItem.setId(order.getId());
		}
		orderItemDao.addOrderItem(orderItems);
		return "success";
	}



}
