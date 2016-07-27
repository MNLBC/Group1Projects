/**
 * 
 */
package com.oocl.mnlbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;

/**
 * @author BARREPE
 *
 */
@Service
public class HomeService {
	@Autowired
	UserDAO userDao;

	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);

	public String home() {
		logger.info("Accessing Client homepage");
		return "index";
	}

	public String index() {
		logger.info("Accessing Client homepage");
		return "index";
	}

	public String admin() {
		logger.info("Accessing Admin homepage");
		return "admin";
	}

	public List<User> getAllLoggedUsers(HttpSession session) {
		logger.info("Getting all logged in users");
		ServletContext context = session.getServletContext();
		List<User> logged = (List<User>) context.getAttribute("logged");
		if (logged == null) {
			logged = new ArrayList<User>();
		}
		return logged;
	}

	public User getUserSession(HttpSession session) {
		logger.info("Getting session of logged in user");
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return null;
		} else {
			return user;
		}
	}

	public int getVisitors(HttpSession session) {
		logger.info("Getting number of current number visitors");
		ServletContext context = session.getServletContext();
		List<String> visitor = (List<String>) context.getAttribute("visitor");
		if (visitor == null) {
			visitor = new ArrayList<String>();
		}
		return visitor.size();
	}

	public boolean hasSession(HttpSession session) {
		logger.info("Checking if session has logged in user");
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
}
