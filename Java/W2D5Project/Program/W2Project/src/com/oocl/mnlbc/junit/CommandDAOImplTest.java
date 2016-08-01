/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oocl.mnlbc.dao.CommandDAO;
import com.oocl.mnlbc.dao.CommandDAOImpl;
import com.oocl.mnlbc.model.History;
import com.oocl.mnlbc.model.Logs;

/**
 * @author Group 1
 *
 */
public class CommandDAOImplTest {

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
	 * Test method for {@link com.oocl.mnlbc.dao.CommandDAOImpl#insert(com.oocl.mnlbc.model.History)}.
	 */
	@Test
	public void testSuccessInsertHistory() {
		CommandDAO daoImpl = new CommandDAOImpl();
		History history = new History("tester", "success input");
		daoImpl.insert(history);
		assertEquals(0,daoImpl.insert(history));
	}

	/**
	 * Test method for {@link com.oocl.mnlbc.dao.CommandDAOImpl#insert(com.oocl.mnlbc.model.Logs)}.
	 */
	@Test
	public void testSuccessInsertLogs() {
		CommandDAO daoImpl = new CommandDAOImpl();
		Logs logs = new Logs("test message");
		assertEquals(0,daoImpl.insert(logs));
	}
}
