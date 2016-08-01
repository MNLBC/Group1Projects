/**
 * 
 */
package com.oocl.mnlbc.testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.oocl.mnlbc.service.RegistrationService;

/**
 * Junit RegistrationServiceTest
 * 
 * @author ANDESMA
 * 
 *@since 07/12/2016
 */

public class RegistrationServiceTest {
	RegistrationService  rs = new RegistrationService();
	/**
	 * Test method for {@link com.oocl.mnlbc.service.RegistrationService#testingRegistration(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testTestingRegistrationSuccess() {
		boolean testingRegister = rs.testingRegistration("Andes", "Mark", "andesma", "123", "123", "andesonline20@gmail.com");
		assertTrue(testingRegister);
		
	}
	@Test
	public void testTestingRegistrationFailed() {
		boolean testingRegister = rs.testingRegistration("", "", "", "", "", "");
		assertFalse(testingRegister);
		
	}

	
	
	/**
	 * Test method for {@link com.oocl.mnlbc.service.RegistrationService#testingPassword(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testTestingPasswordSuccess() {
		boolean testPassword = rs.testingPassword("123", "123");
		assertTrue(testPassword);
	}
	
	@Test
	public void testTestingPasswordFailed() {
		boolean testPassword = rs.testingPassword("123", "qwerty");
		assertFalse(testPassword);
	}

}
