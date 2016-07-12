package com.oocl.mnlbc.service;

public class RegistrationService {
	/**
	 * RegistrationService
	 * 
	 * @author ANDESMA
	 * 
	 *@since 07/12/2016
	 */
	public boolean testingRegistration(String lastName, String firstName, String userName, String password,
			String confPassword, String email) {
		return (firstName != "" || lastName != "" || userName != "" || password != "" || confPassword != ""
				|| email != "");
	}
	
	public boolean testingPassword(String password, String confPassword){
		return password.equals(confPassword);
	}
}
