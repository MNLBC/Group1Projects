package com.oocl.mnlbc.model;

import java.sql.Timestamp;

/**
 * This is the Logs model that includes the id, message, and date created
 * attributes.
 * 
 * @author Group 1
 *
 */
public class Logs {
	private int id;
	private String message;
	private Timestamp dateCreated;

	/**
	 * Constructor for the logs class. Instantiates the object.
	 * 
	 * @param id
	 * @param message
	 * @param dateCreated
	 */
	public Logs(int id, String message, Timestamp dateCreated) {
		this.id = id;
		this.message = message;
		this.dateCreated = dateCreated;
	}

	public Logs(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
}
