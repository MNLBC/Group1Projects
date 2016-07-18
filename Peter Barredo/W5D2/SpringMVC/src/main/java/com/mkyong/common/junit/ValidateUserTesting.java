package com.mkyong.common.junit;

import com.mkyong.common.model.User;
import com.mkyong.common.validator.UserValidator;

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
