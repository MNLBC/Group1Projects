/**
 * 
 */
package com.oocl.mnlbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.oocl.mnlbc.controller.FeedbackController;
import com.oocl.mnlbc.jms.consumer.AdminConsumer;
import com.oocl.mnlbc.jms.consumer.ClientConsumer;
import com.oocl.mnlbc.jms.listener.AdminListener;
import com.oocl.mnlbc.jms.listener.Listener;
import com.oocl.mnlbc.jms.provider.Provider;

/**
 * @author DEQUIAL
 *
 */

@Service
public class MessageService {

	private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

	private static Provider provider;
	private static AdminConsumer adminConsumer;

	private ClientConsumer clientConsumer;
	private Listener listener;
	private Map<Integer, ClientConsumer> userMap = new HashMap<Integer, ClientConsumer>();

	/**
	 * Service for Message
	 */
	public String startAdminConsumer() {
		logger.info("Started admin consumer.");
		adminConsumer = new AdminConsumer();
		return "success";
	}

	public String sendMessage(String message) {
		logger.info("Admin has sent a message.");
		provider = new Provider();
		provider.sendMessage(message);
		return message;
	}

	public String startClientConsumer(Integer userId) {
		logger.info("Client consumer " + userId + " has started.");
		clientConsumer = new ClientConsumer();
		userMap.put(userId, clientConsumer);
		return "success";
	}

	public List<String> viewMessage() {
		logger.info("Getting all admin messages.");
		AdminListener adminListener = adminConsumer.getListener();
		List<String> messages = adminListener.getMessages();
		if (messages == null || messages.size() < 1) {
			return null;
		}
		return messages;
	}

	public String receiveMessage(@RequestParam(value = "userId") Integer userId) {
		logger.info("Client consumer " + userId + " tried to receive message.");
		clientConsumer = userMap.get(userId);
		listener = clientConsumer.getListener();
		String adminMessage = listener.getAdminMessage();
		if (adminMessage == null || adminMessage.isEmpty()) {
			return null;
		}
		listener.setAdminMessage(new String());
		return adminMessage;
	}
}
