package com.oocl.mnlbc;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

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

	@Autowired
	UserDAO userDao;

	@ResponseBody
	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		userDao.init();
		EntityManager em = userDao.getEntityManager();
		User user = userDao.getUserById(id);
		return user;
	}

	@ResponseBody
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUser() {
		userDao.init();
		EntityManager em = userDao.getEntityManager();
		List<User> userList = userDao.getAllUsers();
		return userList;
	}

	@ResponseBody
	@RequestMapping(value = "/getUserByUserName/{username}", method = RequestMethod.GET)
	public User getUserByUserName(@PathVariable("username") String username) {
		userDao.init();
		EntityManager em = userDao.getEntityManager();
		User userReturn = userDao.getUserByUsername(username);
		return userReturn;
	}

	@ResponseBody
	@RequestMapping(value = "/userCheck/{username}", method = RequestMethod.POST)
	public boolean checkUsernameExistence(@PathVariable("username") String username) {
		userDao.init();
		EntityManager em = userDao.getEntityManager();
		List<User> users = userDao.getAllUsers();
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
		userDao.init();
		EntityManager em = userDao.getEntityManager();
		List<User> users = userDao.getAllUsers();
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
		userDao.init();
		
		user.setIsDisabled(0);
		user.setGender(user.getGender().toUpperCase());
		user.setType("customer");
		user.setPoints(0);
		user.setUserLevel(0);

		switch (isUsernameEmailExist(user.getUsername(), user.getEmail())) {
		case 1:
			// logger.info("Client try to register Username: " + username + " is
			// already in used.");
			return "username";
		case 2:
			// logger.info("Client try to register Email: " + email + " is
			// already in used.");
			return "email";
		default:
			userDao.addUser(user);
			return "success";
		}

	}

	private int isUsernameEmailExist(String username, String email) {
		userDao.init();
		EntityManager em = userDao.getEntityManager();
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
