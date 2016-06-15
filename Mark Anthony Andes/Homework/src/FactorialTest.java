import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 */

/**
 * @author andesma
 *
 */
public class FactorialTest {

	@Test
	public void testCalculate1() {
		Factorial factorial = new Factorial();
		assertEquals(120, factorial.calculate1(5));
	}

}
