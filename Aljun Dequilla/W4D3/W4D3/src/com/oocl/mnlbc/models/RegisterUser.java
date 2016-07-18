package com.oocl.mnlbc.models;

public class RegisterUser {
	private String uId;
	private String fName;
	private String lName;
	private String pWord;

	public RegisterUser(String uId, String fName, String lName, String pWord) {
		this.uId = uId;
		this.fName = fName;
		this.lName = lName;
		this.pWord = pWord;
	}

	public String getuId() {
		return uId;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getpWord() {
		return pWord;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
}
