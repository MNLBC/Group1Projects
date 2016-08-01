package com.oocl.mnlbc.junit;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.entity.User;

import edu.javacourse.jpa.service.UserService;
import junit.framework.TestCase;

public class UserServiceTest extends TestCase {

	@Test
	public void testCreateUser() {
		UserService rs = new UserService();
		rs.init();
		EntityManager em = rs.getEntityManager();
		
		List<Order> orderList = new ArrayList<Order>();
		List<OrderItem> itemList = new ArrayList<OrderItem>();


		User user = new User(100,"katrina","deloan");
		Order order = new Order(101,"11-12-2011","Laguna",user);		
		OrderItem item = new OrderItem(102,"Laptop",1000,20,order);
		OrderItem item2 = new OrderItem(103,"Phone",800,20,order);
		itemList.add(item);
		itemList.add(item2);
		order.setItemList(itemList);
		orderList.add(order);
		user.setOrderList(orderList);
		
		int id = rs.createUser(em, user);
		assertEquals(100,id);
		System.out.println("Creating User & his/her orders");
		
		assertEquals(rs.getUser(em, id),user);
		System.out.println("Deleting User's his/her orders");
		
		
	}

}
