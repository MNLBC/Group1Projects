package w1d3_3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class w1d3_3Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidEmail() {
		assertEquals(true, w1d3_3.validEmail("abs.efg@oocl.com"));
	}

	@Test
	public void testValidNumCP() {
		assertEquals(true, w1d3_3.validNumCP("09123456789"));
	}

	@Test
	public void testReplaceA() {
		assertEquals("AbAkAdA", w1d3_3.replaceA("abakada"));
	}

	@Test
	public void testGetMonth() {
		assertEquals("Jun", w1d3_3.getMonth("Tue Jun 14 21:30:31 CST 2016"));
	}

}
