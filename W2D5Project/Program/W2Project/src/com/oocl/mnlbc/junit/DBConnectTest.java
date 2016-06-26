/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oocl.mnlbc.db.DBConnect;

/**
 * @author Group 1
 *
 */
public class DBConnectTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.db.DBConnect#tryConnect(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testSuccessConnectDB() {
		DBConnect db = new DBConnect();
		assertTrue(db.tryConnect("system", "admin123"));
	}

	@Test
	public void testFailUsernameConnectDB() {
		DBConnect db = new DBConnect();
		assertFalse(db.tryConnect("admin", "admin123"));
	}

	@Test
	public void testFailPasswordConnectDB() {
		DBConnect db = new DBConnect();
		assertFalse(db.tryConnect("system", "password1"));
	}

	@Test
	public void testFailBothConnectDB() {
		DBConnect db = new DBConnect();
		assertFalse(db.tryConnect("admin", "password1"));
	}
}
