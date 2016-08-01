package com.oocl.mnlbc.num2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
	@Test
	public void testFactorial(){
		App app = new App();
		assertEquals(5040, app.getFactorial(7));
	}

}
