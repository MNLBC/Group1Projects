/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oocl.mnlbc.controller.WelcomeController;
import com.oocl.mnlbc.model.UserModel;
import com.oocl.mnlbc.validator.UserValidator;

/**
 * @author DEQUIAL
 *
 */
public class UserValidatorTest {

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.validator.UserValidator#supports(java.lang.Class)}.
	 */
	@Test
	public void testSupportsFail() {
		UserValidator validator = new UserValidator();
		WelcomeController welcome = new WelcomeController();
		assertFalse(validator.supports(welcome.getClass()));

	}
	
	@Test
	public void testSupportsSuccess() {
		UserValidator validator = new UserValidator();
		UserModel user = new UserModel();
		assertTrue(validator.supports(user.getClass()));

	}

}
