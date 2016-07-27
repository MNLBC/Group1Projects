package com.oocl.mnlbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.consumer.AdminConsumer;
import com.oocl.mnlbc.consumer.ClientConsumer;
import com.oocl.mnlbc.listener.AdminListener;
import com.oocl.mnlbc.listener.Listener;
import com.oocl.mnlbc.provider.Provider;

/**
 * Handles requests for the application home page.
 * 
 * @author DEQUILLA
 */
@Controller
public class HomeController {

	private static Provider provider;

	private static AdminConsumer adminConsumer;
	private ClientConsumer clientConsumer;
	private Listener listener;
	private Map<Integer, ClientConsumer> userMap = new HashMap<Integer, ClientConsumer>();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startHomeConsumer() {
		adminConsumer = new AdminConsumer();
		return "home";
	}

	@ResponseBody
	@RequestMapping(value = { "/sendMessage" }, method = RequestMethod.POST)
	public String sendMessage(@RequestParam(value = "message") String message) {
		provider = new Provider();
		provider.sendMessage(message);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "/startConsumer")
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

	// @ResponseBody
	// @RequestMapping(value = "/removeMessage", method = RequestMethod.POST)
	// public String removeMessage(@RequestBody MessageDetails messageDetails) {
	// List<MessageDetails> messageList = consumer.getMessageList();
	// if (messageList == null || messageList.size() < 1) {
	// return null;
	// } else {
	// if (messageList.contains(messageDetails)) {
	// messageList.remove(messageDetails);
	// return "success";
	// }
	// }
	// return "fail";
	// }
}
