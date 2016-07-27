package com.oocl.mnlbc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.consumer.Consumer;
import com.oocl.mnlbc.listener.Listener;
import com.oocl.mnlbc.provider.Provider;

/**
 * Handles requests for the application home page.
 * 
 * @author DEQUILLA
 */
@Controller
public class HomeController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);
	private static Provider provider;
	private static Consumer consumer;
	private static Listener listener;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startHomeConsumer() {
		consumer = new Consumer();
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
	public String startConsumer() {
		consumer = new Consumer();
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/viewMessage", produces = "application/json")
	public List<String> viewMessage() {
		List<String> messages = consumer.getMessages();
		if (messages == null || messages.size() < 1) {
			return null;
		}
		return messages;
	}

	@ResponseBody
	@RequestMapping(value = "/receiveMessage", produces = "application/json")
	public String receiveMessage() {
		String adminMessage = listener.getAdminMessage();
		if (adminMessage == null || adminMessage.isEmpty()) {
			return null;
		}
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
