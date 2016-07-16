package com.oocl.mnlbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
//@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDAO userDAO;

	@ResponseBody
	@RequestMapping(value = { "/getAllUsers" })
	public String login() {
		List<User> users = userDAO.getAllUsers();
		StringBuffer buffer = new StringBuffer();
		for (User user : users) {
			buffer.append(user.getFirstname());
		}
		return buffer.toString();
	}

	@ResponseBody
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public User addUser(@RequestParam(required = true) String username, @RequestParam(required = true) String password, @RequestParam(required = true) String firstname,
			@RequestParam(required = false) String middlename, @RequestParam(required = true) String lastname, @RequestParam(required = true) String address, @RequestParam(required = true) String contactno,
			@RequestParam(required = true) String email,@RequestParam(required = true) String gender, HttpSession session) {
		User user = new User();

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setMiddlename(middlename);
		user.setAddress(address);
		user.setContact(contactno);
		user.setDisabled(false);
		user.setGender(gender);
		user.setEmail(email);
		user.setType("customer");
		user.setUsername(username);
		user.setPassword(password);

		return user;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserByID(@PathVariable("id") int id) {
		List<User> users = userDAO.getAllUsers();
		User user = null;
		for (User userL : users) {
			if (userL.getId() == id) {
				user = userL;
			}
		}
		return user;
	}

	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserByUsername(@PathVariable("username") String username) {
		List<User> users = userDAO.getAllUsers();
		User user = null;
		for (User userL : users) {
			if (userL.getUsername().equals(username)) {
				user = userL;
			}
		}
		return user;
	}

	@RequestMapping(value = "/userCheck/{username}", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkUsernameExistence(@PathVariable("username") String username) {
		List<User> users = userDAO.getAllUsers();
		boolean check = false;
		for (User userL : users) {
			if (userL.getUsername().equals(username)) {
				check = true;
			}
		}
		return check;
	}
	
	@RequestMapping(value = "/emailCheck/{email}", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkEmailExistence(@PathVariable("email") String email){
		List<User> users = userDAO.getAllUsers();
		boolean check = false;
		for (User userL : users) {
			if (userL.getEmail().equals(email)) {
				check = true;
			}
		}
		return check;
	}
}
