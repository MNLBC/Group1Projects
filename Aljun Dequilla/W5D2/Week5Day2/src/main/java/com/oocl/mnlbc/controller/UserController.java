package com.oocl.mnlbc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.oocl.mnlbc.model.UserModel;
import com.oocl.mnlbc.validator.UserValidator;

public class UserController extends AbstractWizardFormController {

	public UserController() {
		setCommandName("userForm");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		return new UserModel();

	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		UserModel user = (UserModel) command;
		return new ModelAndView("ResultForm", "user", user);
	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		return new ModelAndView("WelcomePage");
	}

	@Override
	protected void validatePage(Object command, Errors errors, int page) {

		UserValidator validator = (UserValidator) getValidator();

		switch (page) {
		case 0:
			validator.validatePage1Form(command, errors);
			break;
		case 1:
			validator.validatePage2Form(command, errors);
			break;
		}
	}
}