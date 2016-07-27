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

	@Autowired
	LoginService loginService;

	@ResponseBody
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public User login(@RequestParam(required = true) String username, @RequestParam(required = true) String password,
			HttpSession session) {
		return loginService.login(username, password, session);
	}

	@ResponseBody
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session) {
		return loginService.logout(session);
	}

}
