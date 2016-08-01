import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FactorialTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFactorMe() {
		Factorial factorial = new Factorial();
		assertEquals(5040,factorial.factorMe(7));
	}

}
