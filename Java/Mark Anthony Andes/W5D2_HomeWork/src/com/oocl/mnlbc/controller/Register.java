package com.oocl.mnlbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class Register {
	
	/**
	 * Register Class
	 * 
	 * @author ANDESMA
	 * 
	 *@since 07/12/2016
	 */

	@RequestMapping(method=RequestMethod.GET)
	public String register(){
		return "register";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(@RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String userName,
			@RequestParam String password,@RequestParam String confPassword,
			@RequestParam String email, ModelMap model){
		
		if(firstName != "" || lastName != "" || userName != "" || password != "" || confPassword != "" || email != "" ){
			if(password.equals(confPassword)){
				model.put("fullname", lastName +  ", " + firstName );
				model.put("user", userName);
				model.put("email", email);

				return "userInfo";
				
			}else{
				model.put("errorMsg", "Password mismatch.");
				return "register";
			}
		}else{
			model.put("errorMsg", "Fields must have a value");
			return "register";
		}
		
		
		
	}
}
