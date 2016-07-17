package com.oocl.mnlbc.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserDAO userDAO;

	@ResponseBody
	@RequestMapping(value = { "/getAllUsers" })
	public List<User> getAllUsers() {
		List<User> users = userDAO.getAllUsers();
		return users;
	}

	@ResponseBody
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String addUser(@RequestParam(required = true) String username,
			@RequestParam(required = true) String password, @RequestParam(required = true) String firstname,
			@RequestParam(required = false) String middlename, @RequestParam(required = true) String lastname,
			@RequestParam(required = true) String address, @RequestParam(required = true) String contactno,
			@RequestParam(required = true) String email, @RequestParam(required = true) String gender,
			HttpSession session) {

		User user = new User();

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setMiddlename(middlename);
		user.setAddress(address);
		user.setContact(contactno);
		user.setDisabled(false);
		user.setGender(gender.toUpperCase());
		user.setEmail(email);
		user.setType("customer");
		user.setUsername(username);
		user.setPassword(hashPassword(password));

		switch (isUsernameEmailExist(user.getUsername(), user.getEmail())) {
		case 1:
			logger.info("Client try to register Username: " + username + " is already in used.");
			return "username";
		case 2:
			logger.info("Client try to register Email: " + email + " is already in used.");
			return "email";
		default:
			userDAO.addUser(user);
			return "success";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	public User getUserByID(@RequestParam(required = true) int id, HttpSession session) {
		logger.info("Client tried to search user by ID: " + id);
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/getUserByUsername", method = RequestMethod.POST)
	public User getUserByUsername(@RequestParam(required = true) String username) {
		logger.info("Client tried to search user by Username: " + username);
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/userCheck", method = RequestMethod.POST)
	public boolean checkUsernameExistence(@RequestParam(required = true) String username) {
		List<User> users = userDAO.getAllUsers();
		for (User userL : users) {
			if (userL.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = "/emailCheck", method = RequestMethod.POST)
	public boolean checkEmailExistence(@RequestParam(required = true) String email) {
		List<User> users = userDAO.getAllUsers();
		for (User userL : users) {
			if (userL.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
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

	private int isUsernameEmailExist(String username, String email) {
		boolean isUserNameExist = userDAO.checkUsernameExistence(username);
		boolean isEmailAlreadyInUse = userDAO.checkEmailExistence(email);

		if (isUserNameExist) {
			return 1;
		} else if (!isUserNameExist && isEmailAlreadyInUse) {
			return 2;
		} else {
			return 0;
		}
	}
}
