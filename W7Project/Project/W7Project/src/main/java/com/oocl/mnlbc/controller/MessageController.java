/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.service.MessageService;

/**
 * @author DEQUIAL
 *
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {

	@Autowired
	MessageService messageService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@ResponseBody
	@RequestMapping(value = "/startAdmin", method = RequestMethod.GET)
	public String startHomeConsumer() {
		return messageService.startAdminConsumer();
	}

	@ResponseBody
	@RequestMapping(value = { "/sendMessage" }, method = RequestMethod.POST)
	public String sendMessage(@RequestParam(value = "message") String message) {
		return messageService.sendMessage(message);
	}

	@ResponseBody
	@RequestMapping(value = "/viewMessage", produces = "application/json")
	public List<String> viewMessage() {
		return messageService.viewMessage();
	}

	@ResponseBody
	@RequestMapping(value = "/closeAdmin")
	public String closeAdmin() {
		return messageService.closeAdmin();
	}
	
	@ResponseBody
	@RequestMapping(value = "/startClient")
	public String startConsumer(@RequestParam(value = "userId") Integer userId) {
		return messageService.startClientConsumer(userId);
	}

	@ResponseBody
	@RequestMapping(value = "/receiveMessage")
	public String receiveMessage(@RequestParam(value = "userId") Integer userId) {
		return messageService.receiveMessage(userId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/closeClient")
	public String closeClient(@RequestParam(value = "userId") Integer userId) {
		return messageService.closeClient(userId);
	}
}
