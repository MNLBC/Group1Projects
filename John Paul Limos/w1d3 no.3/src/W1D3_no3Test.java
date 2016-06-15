import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class W1D3_no3Test {
	
	W1D3_no3 myClass = new W1D3_no3();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMailValidate() {
	assertEquals(true,myClass.mailValidate("limosjohnpaul@gmail.com"));
	}

	@Test
	public void testPhoneValidate() {
		assertEquals(true,myClass.phoneValidate("09166178702"));
	}

	@Test
	public void testReplaceA() {
		assertEquals("AAA",myClass.replaceA("aaa"));
	}

	@Test
	public void testGetMonth() {
		assertEquals("Jun",myClass.getMonth("Tue Jun 14 21:30:31 CST 2016"));
	}

}
