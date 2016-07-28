/**
 * 
 */
package com.oocl.mnlbc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.impl.LoginService;

/**
 * @author LIMOSJO
 *
 */
@Controller
public class LoginController {

	/**
	 * Automatic instantiation of login Service
	 */
	@Autowired
	LoginService loginService;

	/**
	 * This request is for success logging in using POST request.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public User login(@RequestParam(required = true) String username, String password, HttpSession session) {
		return loginService.login(username, session);
	}

	/**
	 * This request is for checking if user logging in using POST request.
	 * 
	 */

	@ResponseBody
	@RequestMapping(value = { "/checkLoggedIn" }, method = RequestMethod.POST)
	public String checkLoggedIn(@RequestParam(required = true) String username,
			@RequestParam(required = true) String password, HttpSession session) {
		return loginService.checkLoggedIn(username, password, session);
	}

	/**
	 * This request is for logging out using POST request.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session) {
		return loginService.logout(session);
	}

}
