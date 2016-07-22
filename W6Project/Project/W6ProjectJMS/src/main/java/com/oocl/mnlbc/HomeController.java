package com.oocl.mnlbc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.consumer.Consumer;
import com.oocl.mnlbc.provider.Provider;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static Provider provider;
	private static Consumer consumer;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public String sendMessage(@RequestParam(required = true) String form) {
		provider = new Provider();
		provider.sendMessage(form);
		return form;
	}

	@ResponseBody
	@RequestMapping(value = "/startConsumer")
	public String startConsumer() {
		consumer = new Consumer();
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/viewMessage")
	public List<String> viewMessage() {
		List<String> messageList = consumer.getMessageList();
		if (messageList == null || messageList.size() < 1) {
			return null;
		}
		System.out.println(messageList);
		return messageList;
	}
}
