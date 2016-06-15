package homework3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestJUnit {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFactorial() {
		Factorial fact = new Factorial();
		assertEquals(5040,fact.getFactorial(7));
	}
	public void email(){
		Regex reg = new Regex();
		assertEquals(true,reg.email("pauracelis@gmail.com"));
	}

}
