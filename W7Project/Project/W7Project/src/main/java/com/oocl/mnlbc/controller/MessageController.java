/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.jms.consumer.AdminConsumer;
import com.oocl.mnlbc.jms.consumer.ClientConsumer;
import com.oocl.mnlbc.jms.listener.AdminListener;
import com.oocl.mnlbc.jms.listener.Listener;
import com.oocl.mnlbc.jms.provider.Provider;

/**
 * @author DEQUIAL
 *
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {
	private static Provider provider;

	private static AdminConsumer adminConsumer;
	private ClientConsumer clientConsumer;
	private Listener listener;
	private Map<Integer, ClientConsumer> userMap = new HashMap<Integer, ClientConsumer>();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@ResponseBody
	@RequestMapping(value = "/startAdmin", method = RequestMethod.GET)
	public String startHomeConsumer() {
		adminConsumer = new AdminConsumer();
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = { "/sendMessage" }, method = RequestMethod.POST)
	public String sendMessage(@RequestParam(value = "message") String message) {
		provider = new Provider();
		provider.sendMessage(message);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "/startClient")
	public String startConsumer(@RequestParam(value = "userId") Integer userId) {
		clientConsumer = new ClientConsumer();
		userMap.put(userId, clientConsumer);
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/viewMessage", produces = "application/json")
	public List<String> viewMessage() {
		AdminListener adminListener = adminConsumer.getListener();
		List<String> messages = adminListener.getMessages();
		if (messages == null || messages.size() < 1) {
			return null;
		}
		return messages;
	}

	@ResponseBody
	@RequestMapping(value = "/receiveMessage")
	public String receiveMessage(@RequestParam(value = "userId") Integer userId) {
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
