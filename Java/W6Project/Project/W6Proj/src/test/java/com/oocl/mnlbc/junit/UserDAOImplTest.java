/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oocl.mnlbc.dao.UserDAO;

/**
 * @author DEQUIAL
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UserDAOImplTest {
	@Autowired
	UserDAO userDao;

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.impl.UserDAOImpl#checkUsernameExistence(java.lang.String)}.
	 */
	@Test
	public void testCheckUsernameExistenceSuccess() {
		userDao.init();
		boolean check = userDao.checkUsernameExistence("dequial");
		assertTrue(check);
	}

	@Test
	public void testCheckUsernameExistenceFail() {
		userDao.init();
		boolean check = userDao.checkUsernameExistence("bebe");
		assertFalse(check);
	}

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.impl.UserDAOImpl#checkEmailExistence(java.lang.String)}.
	 */
	@Test
	public void testCheckEmailExistenceSuccess() {
		userDao.init();
		boolean check = userDao.checkEmailExistence("limosjo@oocl.com");
		assertTrue(check);

	}

	@Test
	public void testCheckEmailExistenceFail() {
		userDao.init();
		boolean check = userDao.checkEmailExistence("minime@qq.com");
		assertFalse(check);
	}
}
