package com.oocl.mnlbc.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.model.User;

@Controller
// @RequestMapping("/login")
public class LoginController {
	@Autowired
	UserDAO userDAO;

	@ResponseBody
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public User login(@RequestParam(required = true) String username, @RequestParam(required = true) String password,
			HttpSession session) {
		password = hashPassword(password);
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

				session.setMaxInactiveInterval(60);
				ServletContext context = session.getServletContext();

				List<User> logged = (List<User>) context.getAttribute("logged");
				if (logged == null) {
					logged = new ArrayList<User>();
				}

				if (!user.isDisabled()) {
					boolean flag = false;
					for (User name : logged) {
						if (name.equals(username)) {
							flag = true;
						}
					}
					if (!flag) {
						logged.add(user);
					}

					context.setAttribute("logged", logged);
					session.setAttribute("user", user);
				}
				return user;
			}
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logout(HttpSession session) {
		User user = (User) session.getAttribute("user");

		ServletContext context = session.getServletContext();

		List<User> logged = (List<User>) context.getAttribute("logged");
		if (logged == null) {
			logged = new ArrayList<User>();
		}

		logged.remove(user);
		context.setAttribute("logged", logged);

		return "logged" + String.valueOf(logged.size());
	}

	private String hashPassword(String password) {
		String md5 = "";
		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// Update input string in message digest
			digest.update(password.getBytes(), 0, password.length());
			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
}
