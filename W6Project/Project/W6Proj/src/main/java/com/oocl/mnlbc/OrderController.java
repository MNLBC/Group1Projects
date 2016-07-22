/**
 * 
 */
package com.oocl.mnlbc;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.User;


/**
 * @author DELEOAN
 * @author RACELPA
 *
 */
@Controller
@RequestMapping(value ="/order")
public class OrderController {

	@Autowired
	OrderDAO orderDao;
	
	@ResponseBody
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
	public List<Order> getAllOrder() {
		orderDao.init();
//		EntityManager em = orderDao.getEntityManager();
		List<Order> orderList = orderDao.getAllOrder();
		return orderList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getOrderById/{id}", method = RequestMethod.GET)
	public Order getOrderByUserId(@PathVariable("id") int id){
		orderDao.init();
//		EntityManager em = orderDao.getEntityManager();
		Order order = orderDao.getOrderByUserId(id);
		return order;
	}
	
	@ResponseBody
	@RequestMapping(value= {"/addOrder" }, method = RequestMethod.POST)
	public String addOrder(@RequestBody Order order) {
		orderDao.init();
		order.setStatus("DONE");
//		User user = new User();
//		order.setUser(user);
//		order.setId(0);
//		order.setStatus("WAITING");
		orderDao.addOrder(order);
		return "success";
	}

}
