package com.oocl.mnlbc.jUnit;

public class JunitTestingService {
	public boolean testingRegistration(String lastName, String firstName, String userName, String password,
			String confPassword, String email) {
		return (firstName != "" || lastName != "" || userName != "" || password != "" );
	}

	public boolean testingPassword(String password, String confPassword) {
		return password.equals(confPassword);
	}
}
