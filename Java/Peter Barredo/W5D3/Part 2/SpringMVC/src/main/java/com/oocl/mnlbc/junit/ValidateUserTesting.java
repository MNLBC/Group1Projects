package com.oocl.mnlbc.junit;


import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.validator.UserValidator;

import junit.framework.TestCase;

/**
 * 
 * @author BARREPE
 * @since 2016-07-12
 */

public class ValidateUserTesting extends TestCase {
	public void testSupportsUser() {
		UserValidator userValidator = new UserValidator();
		assertTrue(userValidator.supports(User.class));
	}
	
	public void testSupportsString() {
		UserValidator userValidator = new UserValidator();
		assertFalse(userValidator.supports(String.class));
	}
}
