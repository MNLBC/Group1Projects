package com.oocl.mnlbc.models;

/**
 * 
 * @author Group 1
 *
 */
public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String address;
	private String contact;
	private String type;
	private String email;
	private String userName;
	private String password;
	private String gender;
	private String image;
	private boolean isDisabled;

	// Constructor for retrieving
	public User(String firstName, String lastName, String middleName, String address, String contact, String type,
			String email, String userName, String password, String gender, String image, boolean isDisabled) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.address = address;
		this.contact = contact;
		this.type = type;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.image = image;
		this.isDisabled = isDisabled;
	}

	// Constructor for inserting
	public User(String firstName, String lastName, String middleName, String address, String contact, String email,
			String userName, String password, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.address = address;
		this.contact = contact;
		this.type = "customer";
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.image = "default.jpg";
		this.isDisabled = false;
	}

	public User(String userName) {
		this.userName = userName;
	}

	public User(String userName, String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isDisabled() {
		return isDisabled;
	}

	public void setDisable(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
}
