package com.oocl.mnlbc.num3;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {
	App app ;
	@Test
	public void testEmailValidator() {
		app = new App();
		assertEquals(true, app.checkEmail("limos@sil.com"));
	}
	
	@Test
	public void testMobilePhoneValidator() {
		app = new App();
		assertEquals(true, app.checkMobilePhone("+63-9854875847"));
	}
	
	@Test
	public void testReplacer() {
		app = new App();
		assertEquals("AAssAA",app.replaceChar("aassaa"));
	}
	
	@Test
	public void testGetDate() {
		app = new App();
		assertEquals("Jan",app.getDateFromString("Tue Jan 14 21:30:31 CST 2016"));
	}
	

}
