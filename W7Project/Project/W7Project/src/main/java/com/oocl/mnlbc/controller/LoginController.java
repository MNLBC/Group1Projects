/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.impl.LoginService;
import com.oocl.mnlbc.util.PasswordHashing;

/**
 * @author LIMOSJO
 *
 */
@Controller
public class LoginController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	UserDAO userDAO;
	
	@ResponseBody
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public User login(@RequestParam(required = true) String username, @RequestParam(required = true) String password,
			HttpSession session) {
		
		password = PasswordHashing.getInstance().hashPassword(password);
	
		List<User> users = userDAO.getAll();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

				ServletContext context = session.getServletContext();

				List<User> logged = (List<User>) context.getAttribute("logged");
				if (logged == null) {
					logged = new ArrayList<User>();
				}

				if (user.getIsDisabled() == 0) {
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
					logger.info("Client" + user.getUsername() + " is successfully logged in.");
				} else {
					logger.info("Client" + user.getUsername() + " is blocked.");
				}
				return user;
			}
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session) {
		User user = (User) session.getAttribute("user");

		ServletContext context = session.getServletContext();

		List<User> logged = (List<User>) context.getAttribute("logged");
		if (logged == null) {
			logged = new ArrayList<User>();
		}

		logged.remove(user);
		session.invalidate();
		context.setAttribute("logged", logged);

		logger.info("Client" + user.getUsername() + " was logged out.");
		return "logged" + String.valueOf(logged.size());
	}

	private String hashPassword(String password) {
		String md5 = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(password.getBytes(), 0, password.length());
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
}
