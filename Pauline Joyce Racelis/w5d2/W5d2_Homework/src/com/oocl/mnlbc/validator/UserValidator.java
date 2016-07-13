package com.oocl.mnlbc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

public class UserValidator implements Validator {
	@Override
	public boolean supports(Class clazz) {
		// just validate the User instances
		return User.class.isAssignableFrom(clazz);
	}

	// validate page 1, userName
	public void validatePage1Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.userName", "Username is required.");
	}

	// validate page 2, password
	public void validatePage2Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Password is required.");
	}

	// validate page 3, firstname
	public void validatePage3Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.firstName", "Name is required.");
	}

	// validate page 4, email
	public void validatePage4Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Email is required.");
	}

	// validate page 5, contact
	public void validatePage5Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "required.contact", "Contact is required.");
	}

	// validate page 6, address
	public void validatePage6Form(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "Address is required.");

	}

	@Override
	public void validate(Object target, Errors errors) {
		validatePage1Form(target, errors);
		validatePage2Form(target, errors);
		validatePage3Form(target, errors);
		validatePage4Form(target, errors);
		validatePage5Form(target, errors);
		validatePage6Form(target, errors);
	}

}
