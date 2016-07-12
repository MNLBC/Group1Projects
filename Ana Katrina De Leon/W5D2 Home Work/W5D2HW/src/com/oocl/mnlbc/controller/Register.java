package com.oocl.mnlbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oocl.mnlbc.service.RegisterService;

@Controller
@RequestMapping("/register")
public class Register {
	private RegisterService registerService = new RegisterService();
	
	@RequestMapping(method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(@RequestParam String username, @RequestParam String password, @RequestParam String cpassword, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam String address, @RequestParam String email, ModelMap model) {
		if (registerService.validateRegistration(username, password, firstname, lastname, address, cpassword, email)) {
			if(registerService.confirmPass(password, cpassword)) {
				model.put("errMsg", "Password Mismatched!");
				return "register";
			}
			
			model.put("username", username);
			return "welcome";

		} else {
			model.put("errMsg", "Please complete all fields!");
			return "register";
		}

	}
	
}
