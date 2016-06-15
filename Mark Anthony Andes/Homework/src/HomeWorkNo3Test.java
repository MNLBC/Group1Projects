import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author andesma
 *
 */
public class HomeWorkNo3Test {

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
	 * Test method for {@link HomeWorkNo3#email(java.lang.String)}.
	 */
	@Test
	public void testEmail() {
		HomeWorkNo3 hm3 = new HomeWorkNo3();
	assertEquals(true, hm3.email("markanthony.andes@yahoo.com"));
	}

	/**
	 * Test method for {@link HomeWorkNo3#mobileNumber(java.lang.String)}.
	 */
	@Test
	public void testMobileNumber() {
		HomeWorkNo3 hm3 = new HomeWorkNo3();
	assertEquals(true, hm3.mobileNumber("+639335504839"));
	}

	/**
	 * Test method for {@link HomeWorkNo3#text(java.lang.String)}.
	 */
	@Test
	public void testText() {
		HomeWorkNo3 hm3 = new HomeWorkNo3();
		assertEquals("mArk Anthony s. Andes", hm3.text("mark anthony s. andes"));
	}

	/**
	 * Test method for {@link HomeWorkNo3#dateText(java.lang.String)}.
	 */
	@Test
	public void testDateText() {
		HomeWorkNo3 hm3 = new HomeWorkNo3();
		assertEquals("Jun", hm3.dateText("Tue Jun 14 21:30:31 CST 2016"));
	}

}
