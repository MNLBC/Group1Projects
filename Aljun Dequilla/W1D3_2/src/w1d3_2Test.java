import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author DEQUIAL
 *
 */
public class w1d3_2Test {

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
	 * Test method for {@link w1d3_2#facto(int)}.
	 */
	@Test
	public void testFacto() {
//		fail("Not yet implemented");
		w1d3_2 w = new w1d3_2();
		assertEquals(5040, w.facto(7));
	}

}
