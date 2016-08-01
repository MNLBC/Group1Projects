package com.oocl.mnlbc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oocl.demo.el.model.Customer;
import com.oocl.demo.el.service.DemoWithSpringService;
import com.oocl.mnlbc.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class OrderTesting extends TestCase {
	@Autowired
	private OrderService orderService;
	
	public OrderTesting(){
		super();
	}
	
	@Test
	public void testSearchingOfOrder(){
		
		Order order = OrderService.getOrder(1);
		assertNotNull(order);
		
	}
}
