package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oocl.mnlbc.dao.TransactionDAO;
import com.oocl.mnlbc.dao.TransactionDAOImpl;

public class TransactionTest {
	TransactionDAO trans = new TransactionDAOImpl();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsUsernameExistingFail() {
		assertTrue(trans.isUsernameExisting("dequial"));
	}
	
	@Test
	public void testIsUsernameExistingSuccess() {
		assertFalse(trans.isUsernameExisting("walaganito"));
	}

	@Test
	public void testIsEmailExistingFail() {
		assertTrue(trans.isEmailExisting("test3@email.com"));
	}
	
	@Test
	public void testIsEmailExistingSuccess() {
		assertFalse(trans.isEmailExisting("wqesdaasd@sad.life"));
	}
}
