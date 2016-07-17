package com.oocl.mnlbc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	final static Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Accessing homepage");
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = { "/getLoggedUsers" }, method = RequestMethod.POST)
	public List<User> getAllLoggedUsers(HttpSession session) {
		logger.info("Getting all logged in users");
		ServletContext context = session.getServletContext();
		List<User> logged = (List<User>) context.getAttribute("logged");
		if (logged == null) {
			logged = new ArrayList<User>();
		}
		return logged;
	}

	@ResponseBody
	@RequestMapping(value = { "/visitor" }, method = RequestMethod.POST)
	public int getVisitors(HttpSession session) {
		logger.info("Getting number of current number visitors");
		ServletContext context = session.getServletContext();
		List<String> visitor = (List<String>) context.getAttribute("visitor");
		if (visitor == null) {
			visitor = new ArrayList<String>();
		}
		return visitor.size();
	}

	@ResponseBody
	@RequestMapping(value = { "/hasLogged" }, method = RequestMethod.POST)
	private boolean hasSession(HttpSession session) {
		logger.info("Checking if session has logged in user");
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
}
