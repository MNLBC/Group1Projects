package com.oocl.mnlbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.impl.UserDAOImpl;
import com.oocl.mnlbc.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@ResponseBody
	@RequestMapping(value = { "/getAllUsers" })
	public String login(){
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = { "/addUser" })
	public String addUser(){
		UserDAO userDAO = new UserDAOImpl(); 
		User user = new User();
		
		user.setFirstname("Aljun");
		user.setLastname("Aljun");
		user.setMiddlename("Aljun");
		user.setAddress("Aljun");
		user.setContact("Aljun");
		user.setDisabled(false);
		user.setGender("Aljun");
		user.setEmail("JAVAMAN");
		user.setType("admin");
		user.setUsername("JAVAMAN");
		user.setPassword("peter");
		
		
		return userDAO.addUser(user);
	}
}
