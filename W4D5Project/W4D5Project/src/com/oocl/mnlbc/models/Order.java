package com.oocl.mnlbc.models;

/**
 * 
 * @author Group 1
 *
 */
public class Order {

	private int id;
	private int userId;
	private String dateCreated;
	private String dateUpdated;
	private String status;

	public Order(int userId, String dateCreated, String dateUpdated, String status) {
		this.userId = userId;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getDateUpdated() {
		return dateUpdated;
	}

	public String getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
