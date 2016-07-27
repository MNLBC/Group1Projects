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

	public User login(String username, String password, HttpSession session) {

		password = PasswordHashing.getInstance().hashPassword(password);

		User user = userDAO.getUserByUsername(username);
		if (user == null) {
			return null;
		}

		if (user.getPassword().equals(password)) {
			ServletContext context = session.getServletContext();

			List<User> logged = getAllLoggedUsers(context);

			if (user.getIsDisabled() == 0) {
				boolean check = isUserLoggedIn(username, logged);

				if (!check) {
					logged.add(user);
				}

				context.setAttribute("logged", logged);
				session.setAttribute("user", user);

				logger.info("Client " + user.getUsername() + " has successfully logged in.");

				return user;

			} else {
				logger.info("Client " + user.getUsername() + " is blocked.");
			}
		}
		return null;
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

	private boolean isUserLoggedIn(String username, List<User> logged) {
		boolean flag = false;
		for (User name : logged) {
			if (name.equals(username)) {
				flag = true;
			}
		}
		return flag;
	}
}
