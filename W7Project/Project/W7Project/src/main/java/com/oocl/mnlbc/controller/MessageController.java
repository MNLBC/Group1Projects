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
 * This is a controller for Message requests
 * 
 * @author DEQUIAL
 * @since 07/28/16
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {
	/**
	 * Automatic instantiation of Message Service
	 */
	@Autowired
	MessageService messageService;

	/**
	 * This request is for starting the consumer of admin.
	 * 
	 * @return a string of success
	 */
	@ResponseBody
	@RequestMapping(value = "/startAdmin", method = RequestMethod.GET)
	public String startHomeConsumer() {
		return messageService.startAdminConsumer();
	}

	/**
	 * This request is for sending the message of admin.
	 * 
	 * @param message
	 *            the message to be sent
	 * @return a string of success
	 */
	@ResponseBody
	@RequestMapping(value = { "/sendMessage" }, method = RequestMethod.POST)
	public String sendMessage(@RequestParam(value = "message") String message) {
		return messageService.sendMessage(message);
	}

	/**
	 * This request is for getting all messages sent by admin.
	 * 
	 * @return the list of string messages
	 */
	@ResponseBody
	@RequestMapping(value = "/viewMessage", produces = "application/json")
	public List<String> viewMessage() {
		return messageService.viewMessage();
	}

	/**
	 * This request is for closing consumer connection of admin.
	 * 
	 * @return the string of success
	 */
	@ResponseBody
	@RequestMapping(value = "/closeAdmin")
	public String closeAdmin() {
		return messageService.closeAdmin();
	}

	/**
	 * This request is for starting the consumer of client.
	 * 
	 * @param userId
	 *            the id of the user
	 * @return a string of success
	 */
	@ResponseBody
	@RequestMapping(value = "/startClient")
	public String startConsumer(@RequestParam(value = "userId") Integer userId) {
		return messageService.startClientConsumer(userId);
	}
	/**
	 * This request is for client to receive messages.
	 * 
	 * @param userId
	 *            the id of the user
	 * @return a string of success
	 */
	@ResponseBody
	@RequestMapping(value = "/receiveMessage")
	public String receiveMessage(@RequestParam(value = "userId") Integer userId) {
		return messageService.receiveMessage(userId);
	}
	/**
	 * This request is for closing consumer connection of admin
	 * 
	 * @param userId
	 *            the id of the user
	 * @return a string of success
	 */
	@ResponseBody
	@RequestMapping(value = "/closeClient")
	public String closeClient(@RequestParam(value = "userId") Integer userId) {
		return messageService.closeClient(userId);
	}
}
