package com.oocl.mnlbc.junit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.oocl.mnlbc.service.RegistrationService;
public class SpringTest {
	RegistrationService rs = new RegistrationService();

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.service.RegistrationService#testingRegistration(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testTestingRegistrationSuccess() {
		boolean testingRegister = rs.testingRegistration("Pau","password", "Pau", "pauracelis@gmail.com", "ZHA", "123");
		assertTrue(testingRegister);

	}

	@Test
	public void testTestingRegistrationFailed() {
		boolean testingRegister = rs.testingRegistration("", "", "", "", "", "");
		assertFalse(testingRegister);

	}
}
