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
public class FactorialTest {

	@Test
	public void testCalculateFactorial() {
		Factorial fact = new Factorial();
		assertEquals(3628800, fact.calculateFactorial(10));
	}

}
