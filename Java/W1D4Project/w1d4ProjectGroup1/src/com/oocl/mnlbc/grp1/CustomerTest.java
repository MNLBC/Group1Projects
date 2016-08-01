/**
 * 
 */
package com.oocl.mnlbc.grp1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author DEQUIAL
 *
 */
public class CustomerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.oocl.mnlbc.grp1.Customer#hasEnoughStocks(com.oocl.mnlbc.grp1.Warehouse, com.oocl.mnlbc.grp1.Product, int)}.
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NumberFormatException 
	 */
	@Test
	public void testHasEnoughStocks() throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		Customer cust = new Customer(0, "Juan", "Dela Cruz", "09123456789", "jdcruz", "123", "type", "asd@asd.com",
				200.50);
		Warehouse wh = new Warehouse(5, 5, 5, 4);
		assertEquals(true,cust.hasEnoughStocks(wh, wh.getProducts().get(0), 5));
	}

}
