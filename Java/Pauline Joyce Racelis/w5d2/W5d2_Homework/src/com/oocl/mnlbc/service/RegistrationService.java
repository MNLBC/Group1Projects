package com.oocl.mnlbc.service;

public class RegistrationService {
	public boolean testingRegistration(String username, String password, String name,
			 String email, String address, String contact) {
		return (username != "" || password != "" || name !="" || email != ""
				|| address != "" || contact !=  "");
	}
	
}
