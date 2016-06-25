package com.oocl.mnlbc.functions;

import java.sql.Timestamp;

public class Logs {

	private int id;
	private String message;
	private Timestamp dateCreated;

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
