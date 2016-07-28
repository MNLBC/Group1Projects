/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.impl.UserService;

/**
 * @author DEQUIAL
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UserServiceTest {

	@Autowired
	UserService userService;

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.service.impl.UserService#find(int)}.
	 */
	@Test
	public void testFindFail() {
		assertNull(userService.find(0));
	}

	@Test
	public void testFindSuccess() {
		assertNotNull(userService.find(100001));
	}

	@Test
	public void testFindSame() {
		assertEquals("admin", userService.find(100001).getUsername());
	}

	@Test
	public void testFindNotSame() {
		assertNotSame("andesma", userService.find(100001).getUsername());
	}

	@Test
	public void testFindIsNotDisabled() {
		assertEquals(0, userService.find(100001).getIsDisabled());
	}

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.service.impl.UserService#getUserByUsername(java.lang.String)}.
	 */
	@Test
	public void testGetUserByUsernameSuccess() {
		assertNotNull(userService.getUserByUsername("admin"));
	}

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.service.impl.UserService#isUsernameExisting(java.lang.String)}.
	 */
	@Test
	public void testIsUsernameExist() {
		assertTrue(userService.isUsernameExisting("andesma"));
	}

	@Test
	public void testIsUsernameDoesNotExist() {
		assertFalse(userService.isUsernameExisting("mamasapano"));
	}

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.service.impl.UserService#isEmailExisting(java.lang.String)}.
	 */
	@Test
	public void testIsEmailDoesNotExist() {
		assertFalse(userService.isEmailExisting("rockystar@email\\.com"));
	}

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.service.impl.UserService#updateUser(com.oocl.mnlbc.entity.User)}.
	 */
	@Test
	public void testUpdateUser() {
		User user = userService.getUserByUsername("rio");
		assertTrue(userService.updateUser(user));
	}

}
