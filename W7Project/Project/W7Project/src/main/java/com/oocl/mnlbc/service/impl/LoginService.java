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

	public User login(String username, String password) {
		password = PasswordHashing.getInstance().hashPassword(password);

		User user = userDAO.getUserByUsername(username);
		if (user == null) {
			logger.info("User" + user.getUsername() + " does not exist.");
			return null;
		}

		if (user.getPassword().equals(password)) {
			if (user.getIsDisabled() == 0) {
				logger.info("Client " + user.getUsername() + " has successfully logged in.");
				return user;
			}
			logger.info("Client " + user.getUsername() + " is blocked.");
		}
		return null;
	}

	public String checkLoggedIn(String username, HttpSession session) {
		User user = userDAO.getUserByUsername(username);
		if (user == null) {
			logger.info("User" + user.getUsername() + " does not exist.");
			return "null";
		}

		ServletContext context = session.getServletContext();

		List<User> loggedUsers = getAllLoggedUsers(context);

		boolean isLoggedIn = checkUserLoggedIn(username, loggedUsers);

		if (isLoggedIn) {
			logger.info("Client " + user.getUsername() + " has already logged in.");
			return "logged";
		}

		loggedUsers.add(user);
		context.setAttribute("logged", loggedUsers);
		session.setAttribute("user", user);

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
