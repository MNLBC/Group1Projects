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
	public void validateUserNameForm(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", "Field name is required.");
	}

	// validate page 2, password
	public void validatePasswordForm(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");
	}

	// validate page 3, fname
	public void validateFirstNameForm(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "required.fname", "Field name is required.");
	}

	// validate page 4, lname
	public void validateLastNameForm(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "required.lname", "Field name is required.");
	}

	// validate page 5, email
	public void validateEmailForm(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Field name is required.");
	}

	@Override
	public void validate(Object target, Errors errors) {

		validateUserNameForm(target, errors);
		validatePasswordForm(target, errors);
		validateFirstNameForm(target, errors);
		validateLastNameForm(target, errors);
		validateEmailForm(target, errors);

	}

}