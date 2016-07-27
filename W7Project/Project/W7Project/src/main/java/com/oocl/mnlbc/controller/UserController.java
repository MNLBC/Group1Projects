package com.oocl.mnlbc.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.impl.UserService;

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
	UserService userService;

	@ResponseBody
	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		return userService.find(id);
	}


	@ResponseBody
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUser() {
		return userService.getAll();
	}

	@ResponseBody
	@RequestMapping(value = "/getUserByUserName/{username}", method = RequestMethod.GET)
	public User getUserByUserName(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
	}

	@ResponseBody
	@RequestMapping(value = "/userCheck/{username}", method = RequestMethod.GET)
	public boolean checkUsernameExistence(@PathVariable("username") String username) {
		return userService.isUsernameExisting(username);
	}

	@ResponseBody
	@RequestMapping(value = "/emailCheck/{email}", method = RequestMethod.GET)
	public boolean checkEmailExistence(@PathVariable("email") String email) {
		return userService.isEmailExisting(email);
	}

	@ResponseBody
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/updateUser" }, method = RequestMethod.POST)
	public boolean updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}


}
