package com.oocl.mnlbc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	UserDAO userDao;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Accessing Client homepage");
		return "index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		logger.info("Accessing Client homepage");
		return "index";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		logger.info("Accessing Admin homepage");
		return "admin";
	}

	@ResponseBody
	@RequestMapping(value = { "/getLoggedUsers" }, method = RequestMethod.GET)
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
	@RequestMapping(value = { "/getUserSession" }, method = RequestMethod.GET)
	private User getUserSession(HttpSession session) {
		logger.info("Getting session of logged in user");
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return null;
		} else {
			return user;
		}
	}

	@ResponseBody
	@RequestMapping(value = { "/visitor" }, method = RequestMethod.GET)
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
	@RequestMapping(value = { "/hasLogged" }, method = RequestMethod.GET)
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
