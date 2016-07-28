package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.UserService;

/**
 * This is a controller for User requests
 * 
 * @author LIMOSJO
 * @author DELEOAN
 * @since 07/22/16
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	/**
	 * Automatic instantiation of User Service
	 */
	@Autowired
	UserService userService;

	/**
	 * This request is for getting the user using the id.
	 * 
	 * @param id
	 *            the id of the user to be retrieved
	 * @return an object of User
	 */
	@ResponseBody
	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		return userService.find(id);
	}

	/**
	 * This request is for getting all the users.
	 * 
	 * @return the list of all user
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUser() {
		return userService.getAll();
	}

	/**
	 * This request is for getting the user by user name.
	 * 
	 * @param username
	 *            the user name of the user to be retrieved
	 * @return an object of User
	 */
	@ResponseBody
	@RequestMapping(value = "/getUserByUserName/{username}", method = RequestMethod.GET)
	public User getUserByUserName(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
	}

	/**
	 * This request is for checking if user name exist.
	 * 
	 * @param userId
	 *            the id of the user to be retrieved
	 * @return boolean result of checking
	 */
	@ResponseBody
	@RequestMapping(value = "/userCheck/{username}", method = RequestMethod.GET)
	public boolean checkUsernameExistence(@PathVariable("username") String username) {
		return userService.isUsernameExisting(username);
	}

	/**
	 * This request is for checking if email exist .
	 * 
	 * @param userId
	 *            the userId of the user to be retrieved
	 * @return boolean result of checking
	 */
	@ResponseBody
	@RequestMapping(value = "/emailCheck/{email}", method = RequestMethod.GET)
	public boolean checkEmailExistence(@PathVariable("email") String email) {
		return userService.isEmailExisting(email);
	}

	/**
	 * This request is for adding user
	 * 
	 * @param user
	 *            the user to be inserted
	 * @return a boolean result of insertion
	 */
	@ResponseBody
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	/**
	 * This request is for updating user
	 * 
	 * @param user
	 *            the user to be updated
	 * @return a boolean result of update
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateUser" }, method = RequestMethod.POST)
	public boolean updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	/**
	 * This request is for user change password
	 * 
	 * @param currentPass
	 *            the current password
	 * @param newPass
	 *            the new password to be set
	 * @param username
	 *            the user name
	 * @return boolean result of change password
	 */
	@ResponseBody
	@RequestMapping(value = { "/changePassword" }, method = RequestMethod.POST)
	public String changePassword(@RequestParam(required = true) String currentPass,
			@RequestParam(required = true) String newPass, @RequestParam(required = true) String username) {
		return userService.changePassword(currentPass, newPass, username);
	}

}
