package com.oocl.mnlbc.grp1;

public class User {

	private long id;
	private String fname;
	private String lname;
	private String contact;
	private String username;
	private String password;
	private String type;
	private String email;

	public User(long id, String fname, String lname, String contact, String username, String password, String type,
			String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.contact = contact;
		this.username = username;
		this.password = password;
		this.type = type;
		this.email = email;

	}

	public long getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getContact() {
		return contact;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;
	}

	public String getEmail() {
		return email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
