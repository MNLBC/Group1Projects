package com.oocl.mnlbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.util.PasswordHashing;

@Service
public class LoginService {

	final static Logger logger = Logger.getLogger(LoginService.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserService userService;

	public User login(String username, HttpSession session) {
		ServletContext context = session.getServletContext();
		List<User> loggedUsers = getAllLoggedUsers(context);
		User user = userDAO.getUserByUsername(username);

		if (user == null) {
			logger.info("User" + user.getUsername() + " does not exist.");
			return null;
		}

		logger.info("Client " + user.getUsername() + " has successfully logged in.");

		loggedUsers.add(user);
		context.setAttribute("logged", loggedUsers);
		session.setAttribute("user", user);

		return user;
	}

	public String checkLoggedIn(String username, String password, HttpSession session) {
		password = PasswordHashing.getInstance().hashPassword(password);
		ServletContext context = session.getServletContext();
		List<User> loggedUsers = getAllLoggedUsers(context);
		boolean isExist = userService.isUsernameExisting(username);
		boolean isLoggedIn = checkUserLoggedIn(username, loggedUsers);

		User user = null;
		if (isExist) {
			user = userDAO.getUserByUsername(username);
		}

		if (user == null) {
			logger.info("User" + username + " does not exist.");
			return "null";
		}

		if (!user.getPassword().equals(password)) {
			logger.info("Client " + user.getUsername() + "  has entered wrong password.");
			return "password";
		}

		if (user.getIsDisabled() == 1) {
			logger.info("Client " + user.getUsername() + "  is blocked.");
			return "block";
		}

		if (isLoggedIn) {
			logger.info("Client " + user.getUsername() + " has already logged in.");
			return "logged";
		}

		return "success";
	}

	public String logout(HttpSession session) {
		User user = (User) session.getAttribute("user");

		ServletContext context = session.getServletContext();

		List<User> logged = getAllLoggedUsers(context);

		logged.remove(user);
		session.invalidate();
		context.setAttribute("logged", logged);

		logger.info("Client " + user.getUsername() + " has logged out.");
		return "success";
	}

	private List<User> getAllLoggedUsers(ServletContext context) {
		List<User> logged = (List<User>) context.getAttribute("logged");
		if (logged == null) {
			logged = new ArrayList<User>();
		}
		return logged;
	}

	private boolean checkUserLoggedIn(String username, List<User> logged) {
		boolean flag = false;
		for (User name : logged) {
			if (name.getUsername().equals(username)) {
				flag = true;
			}
		}
		return flag;
	}
}
