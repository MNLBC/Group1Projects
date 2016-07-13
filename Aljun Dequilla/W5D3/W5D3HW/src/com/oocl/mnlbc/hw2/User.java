package com.oocl.mnlbc.hw2;

public class User {
	private String fname;
	private String lname;
	private String uname;
	private String password;

	public User(String fname, String lname, String uname, String password) {
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.password = password;
	}

	public User() {
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getUname() {
		return uname;
	}

	public String getPassword() {
		return password;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}