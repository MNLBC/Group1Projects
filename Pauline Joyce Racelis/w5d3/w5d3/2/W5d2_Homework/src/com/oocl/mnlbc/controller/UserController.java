package com.oocl.mnlbc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.oocl.mnlbc.jdbc.UserJDBCTemplate;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.validator.UserValidator;

public class UserController extends AbstractWizardFormController{

	public UserController(){
		setCommandName("userForm");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
		throws Exception {
		
		return new User();
	}
	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {
		
		User user = (User) command;
		String name = user.getName();
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();
		String contact = user.getContact();
		String address = user.getAddress();

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/oocl/mnlbc/beans/beans.xml");

		UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("UserJDBCTemplate");
		userJDBCTemplate.create(name,username,password,email,contact,address);

		return new ModelAndView("ResultForm", "user", user);
	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {
		
		//where is the cancel page?
		return new ModelAndView("WelcomePage");
	}
	
	@Override
	protected void validatePage(Object command, Errors errors, int page) {
		
		UserValidator validator = (UserValidator) getValidator();
		
		//page is 0-indexed
		switch (page) {
		   case 0: //if page 1 , go validate with validatePage1Form
			validator.validatePage1Form(command, errors);
			break;
		   case 1: //if page 2 , go validate with validatePage2Form
			validator.validatePage2Form(command, errors);
			break;
		   case 2: //if page 3 , go validate with validatePage3Form
			validator.validatePage3Form(command, errors);
			break;
		   case 3: //if page 4, go validate with validatePage4Form
			validator.validatePage4Form(command, errors);
			break;
		   case 4: //if page 5, go validate with validatePage5Form
			validator.validatePage5Form(command, errors);
			break;
		   case 5: //if page 6, go validate with validatePage6Form
			validator.validatePage6Form(command, errors);
			break;
			
			
		}
	}
}
