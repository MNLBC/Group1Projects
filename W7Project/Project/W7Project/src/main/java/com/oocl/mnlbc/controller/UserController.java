package com.oocl.mnlbc.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.User;

/**
 * 
 * @author LIMOSJO
 * @author DELEOAN
 *
 */
@Controller
@RequestMapping(value ="/user")
public class UserController {
	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserDAO userDao;

	@ResponseBody
	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		User user = userDao.find(id);
		return user;
	}

	@ResponseBody
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUser() {
		List<User> userList = userDao.getAll();
		return userList;
	}

	@ResponseBody
	@RequestMapping(value = "/getUserByUserName/{username}", method = RequestMethod.GET)
	public User getUserByUserName(@PathVariable("username") String username) {
		User userReturn = userDao.getUserByUsername(username);
		return userReturn;
	}

	@ResponseBody
	@RequestMapping(value = "/userCheck/{username}", method = RequestMethod.POST)
	public boolean checkUsernameExistence(@PathVariable("username") String username) {
		List<User> users = userDao.getAll();
		for (User userL : users) {
			if (userL.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = "/emailCheck/{email}", method = RequestMethod.POST)
	public boolean checkEmailExistence(@PathVariable("email") String email) {
		List<User> users = userDao.getAll();
		for (User userL : users) {
			if (userL.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		user.setPassword(hashPassword(user.getPassword()));
		user.setIsDisabled(0);
		user.setGender(user.getGender().toUpperCase());
		user.setType("customer");
		user.setPoints(0);
		user.setUserLevel(0);

		switch (isUsernameEmailExist(user.getUsername(), user.getEmail())) {
		case 1:
			logger.info("Client try to register Username: " + user.getUsername() + " is already in used.");
			return "username";
		case 2:
			 logger.info("Client try to register Email: " + user.getEmail() + " is already in used.");
			return "email";
		default:
			userDao.add(user);
			return "success";
		}

	}
	
	@ResponseBody
	@RequestMapping(value = { "/updateUser" }, method = RequestMethod.POST)
	public boolean updateUser(@RequestBody User user) {
		userDao.update(user);
		logger.info("User has been updated");
		return true;
	}
	
	
	
	
	
	

	private int isUsernameEmailExist(String username, String email) {
		boolean isUserNameExist = userDao.checkUsernameExistence(username);
		boolean isEmailAlreadyInUse = userDao.checkEmailExistence(email);

		if (isUserNameExist) {
			return 1;
		} else if (!isUserNameExist && isEmailAlreadyInUse) {
			return 2;
		} else {
			return 0;
		}
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
