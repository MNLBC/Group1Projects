package com.oocl.mnlbc.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
	
	private static PasswordHashing passwordHashing = new PasswordHashing();
	
	public static PasswordHashing getInstance( ) {
	      return passwordHashing;
	}
	
	public String hashPassword(String password){
		String md5 = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(password.getBytes(), 0, password.length());
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
	
}
