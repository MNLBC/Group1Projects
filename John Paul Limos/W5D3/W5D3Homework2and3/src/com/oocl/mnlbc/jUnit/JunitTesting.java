package com.oocl.mnlbc.jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTesting {

	JunitTestingService service = new JunitTestingService();

	@Test
	public void testTestingRegistrationSuccess() {
		boolean testingRegister = service.testingRegistration("Last Name", "First Name", "UserName", "123", "123",
				"email@sample.com");
		assertTrue(testingRegister);

	}

	@Test
	public void testTestingRegistrationFailed() {
		boolean testingRegister = service.testingRegistration("", "", "", "", "", "");
		assertFalse(testingRegister);

	}

	@Test
	public void testTestingPasswordSuccess() {
		boolean testPassword = service.testingPassword("123", "123");
		assertTrue(testPassword);
	}

	@Test
	public void testTestingPasswordFailed() {
		boolean testPassword = service.testingPassword("123", "qwerty");
		assertFalse(testPassword);
	}

}
