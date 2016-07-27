package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author RACELPA
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Users")
@NamedQuery(name = "User.findAll", query = "SELECT b FROM User b")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
	@SequenceGenerator(name = "userSequence", sequenceName = "USER_ID_SEQ", allocationSize = 1)
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "middlename")
	private String middlename;

	@Column(name = "address")
	private String address;

	@Column(name = "contacts")
	private String contactno;

	@Column(name = "type")
	private String type;

	@Column(name = "email")
	private String email;

	@Column(name = "username")
	private String username;

	@JsonIgnore
	@Column(name = "password")
	private String password;

	@Column(name = "gender")
	private String gender;

	@Column(name = "user_level")
	private int userLevel;

	@Column(name = "is_disabled")
	private int isDisabled;

	@Column(name = "points")
	private double points;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the contactno
	 */
	public String getContactno() {
		return contactno;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return the userLevel
	 */
	public int getUserLevel() {
		return userLevel;
	}

	/**
	 * @return the isDisabled
	 */
	public int getIsDisabled() {
		return isDisabled;
	}

	/**
	 * @return the points
	 */
	public double getPoints() {
		return points;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param middlename
	 *            the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param contactno
	 *            the contactno to set
	 */
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param userLevel
	 *            the userLevel to set
	 */
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	/**
	 * @param isDisabled
	 *            the isDisabled to set
	 */
	public void setIsDisabled(int isDisabled) {
		this.isDisabled = isDisabled;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(double points) {
		this.points = points;
	}

}
