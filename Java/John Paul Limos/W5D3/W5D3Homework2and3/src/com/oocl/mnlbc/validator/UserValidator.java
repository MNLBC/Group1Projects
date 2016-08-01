package com.oocl.mnlbc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

public class UserValidator implements Validator{
	@Override
	public boolean supports(Class clazz) {
		//just validate the User instances
		return User.class.isAssignableFrom(clazz);
	}
	
	//validate page 1, userName
	public void validatePage1Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
		        "required.username", "User name is required.");
	}
	
	//validate page 2, password
	public void validatePage2Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
			"required.password", "Password is required.");
	}
	
	//validate page 3, firstname
	public void validatePage3Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
			"required.firstName", "First name is required.");
	}
	//validate page 4, lastname
	public void validatePage4Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
			"required.lastName", "Last name is required.");
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		validatePage1Form(target, errors);
		validatePage2Form(target, errors);
		validatePage3Form(target, errors);
		validatePage4Form(target, errors);
	}


}
