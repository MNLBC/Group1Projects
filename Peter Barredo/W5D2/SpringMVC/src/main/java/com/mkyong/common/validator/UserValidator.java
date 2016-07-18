package com.mkyong.common.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mkyong.common.model.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class cls) {
		// just validate the User instances
		return User.class.isAssignableFrom(cls);
	}

	// validate page 1
	public void validatePage1Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.username", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");
	}

	// validate page 2
	public void validatePage2Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "required.fname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "required.lname", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required.phone", "Field name is required.");
	}

	// validate page 3
	public void validatePage3Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "Field name is required.");
	}

	@Override
	public void validate(Object target, Errors errors) {
		validatePage1Form(target, errors);
		validatePage2Form(target, errors);
		validatePage3Form(target, errors);
	}
	
}