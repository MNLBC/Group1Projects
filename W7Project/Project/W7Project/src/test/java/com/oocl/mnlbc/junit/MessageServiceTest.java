/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oocl.mnlbc.service.impl.MessageService;

/**
 * @author DEQUIAL
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MessageServiceTest {

	MessageService messageService = new MessageService();

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.service.impl.MessageService#startClientConsumer(java.lang.Integer)}.
	 */
	@Test
	public void testClientConsumer() {
		String start = messageService.startClientConsumer(100001);
		assertSame("success", start);
		assertEquals("success", start);

		String close = messageService.closeClient(100001);
		assertEquals("success", close);
	}

	/**
	 * Test method for
	 * {@link com.oocl.mnlbc.service.impl.MessageService#startAdminConsumer()}.
	 */
	@Test
	public void testAdminConsumer() {
		String start = messageService.startAdminConsumer();
		assertEquals("success", start);

		String sent = messageService.sendMessage("TestJunitMessage");
		assertEquals("TestJunitMessage", sent);

		List<String> sents = new ArrayList<String>();
		sents.add(sent);

		List<String> receive = messageService.viewMessage();
		assertEquals(sents, receive);

		String close = messageService.closeAdmin();
		assertEquals("success", close);
	}

}
