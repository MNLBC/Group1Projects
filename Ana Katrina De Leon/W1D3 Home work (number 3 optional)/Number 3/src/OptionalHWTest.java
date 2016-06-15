import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author deleoan
 *
 */
public class OptionalHWTest {

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
	 * Test method for {@link OptionalHW#email(java.lang.String)}.
	 */
	@Test
	public void testEmail() {
		//fail("Not yet implemented");
		OptionalHW hw3 = new OptionalHW();
		assertEquals(true, hw3.email("anakatdeleon@gmail.com"));
	}

	/**
	 * Test method for {@link OptionalHW#number(java.lang.String)}.
	 */
	@Test
	public void testNumber() {
		//fail("Not yet implemented");
		OptionalHW hw3 = new OptionalHW();
		assertEquals(true, hw3.number("+09151237719"));
	}

	/**
	 * Test method for {@link OptionalHW#character(java.lang.String)}.
	 */
	@Test
	public void testCharacter() {
		//fail("Not yet implemented");
		OptionalHW hw3 = new OptionalHW();
		assertEquals("A", hw3.character("a"));
	}

	/**
	 * Test method for {@link OptionalHW#dateTime(java.lang.String)}.
	 */
	@Test
	public void testDateTime() {
		//fail("Not yet implemented");
		OptionalHW hw3 = new OptionalHW();
		assertEquals("Jun", hw3.dateTime("Tue Jun 14 21:30:31 CST 2016"));
	}

}
