package homework3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitTester {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmail() {
		Regex reg = new Regex();
		assertEquals(true,Regex.email("pauracelis@gmail.com"));
	}

	@Test
	public void testMobile() {
		Regex reg = new Regex();
		assertEquals(true,Regex.mobile("+639271369104"));
	}

	@Test
	public void testReplaceChar() {
		Regex reg = new Regex();
		assertEquals("AdAm",Regex.replaceChar("adam"));
	}

	@Test
	public void testMonth() {
		Regex reg = new Regex();
		assertEquals("Jun",Regex.month("Tue Jun 14 21:30:31 CST 2016"));
	}

}
