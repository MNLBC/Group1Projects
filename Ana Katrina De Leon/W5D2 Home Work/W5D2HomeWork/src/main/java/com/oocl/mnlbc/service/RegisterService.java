package com.oocl.mnlbc.service;

public class RegisterService {
	public boolean validateRegistration(String username, String password, String firstname, String lastname,
			String address, String cpassword, String email) {
		return !(username.equals("") || password.equals("") || cpassword.equals("") || firstname.equals("")
				|| lastname.equals("") || address.equals("") || email.equals(""));
	}

	public boolean confirmPass(String password, String cpassword) {
		return password.equals(cpassword);
	}
}
