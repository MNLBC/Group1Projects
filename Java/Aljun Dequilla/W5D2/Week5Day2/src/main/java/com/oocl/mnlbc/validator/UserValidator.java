package com.oocl.mnlbc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.UserModel;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the User instances
		return UserModel.class.isAssignableFrom(clazz);
	}
	
	//validate page 1, input for Fullname, Address and Email
	public void validatePage1Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.name", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
				"required.address", "Field address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "Field email is required.");
	}
	
	//validate page 2,input for username and password
	public void validatePage2Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"required.userName", "Field Username is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field Password is required.");
	}

	
	@Override
	public void validate(Object target, Errors errors) {
		
		validatePage1Form(target, errors);
		validatePage2Form(target, errors);
	
	}
	
}