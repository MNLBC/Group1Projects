/**
 * 
 */
package com.oocl.mnlbc.hw2.num1.junit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.oocl.mnlbc.hw2.num1.model.Order;
import com.oocl.mnlbc.hw2.num1.model.OrderItem;
import com.oocl.mnlbc.hw2.num1.model.User;
import com.oocl.mnlbc.hw2.num1.service.UserService;

/**
 * @author DEQUIAL
 *
 */
public class UserServiceTest {

	@Test
	public void test() {
		UserService rs = new UserService();
		EntityManager em = rs.getEntityManager();

		List<Order> orders1 = new ArrayList<Order>();
		List<User> users1 = new ArrayList<User>();

		User user1 = new User(1, "ALJUN", "DEQUILLA", "BACOOR");
		OrderItem prod1 = new OrderItem(1, "CRACKERS", 10);
		OrderItem prod2 = new OrderItem(2, "BISCUIT", 9);
		OrderItem prod3 = new OrderItem(3, "JUICE", 15);
		Order order1 = new Order(user1, prod1);
		Order order2 = new Order(user1, prod2);
		Order order3 = new Order(user1, prod3);

		orders1.add(order1);
		orders1.add(order2);
		orders1.add(order3);
		users1.add(user1);

		user1.setOrders(orders1);
		order1.setUser(user1);
		order2.setUser(user1);
		order3.setUser(user1);

		Integer test = new Integer(1);
		Integer id = rs.createUser(em, user1);
		assertEquals(test, id);
		System.out.println("User - Order - Order Item Created");

		User userDb = rs.getUser(em, id);
		assertEquals(user1, userDb);
		System.out.println("Retrieved User");

		rs.removeUser(em, userDb);
		System.out.println("Removed User");
		em.close();
	}

}
