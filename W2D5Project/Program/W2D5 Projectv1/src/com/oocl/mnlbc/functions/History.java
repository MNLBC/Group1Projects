package com.oocl.mnlbc.functions;

import java.sql.Timestamp;

public class History {
	private int id;
	private String chatterName;
	private String message;
	private Timestamp dateCreated;

	public History(int id, String chatterName, String message, Timestamp dateCreated) {
		this.id = id;
		this.chatterName = chatterName;
		this.message = message;
		this.dateCreated = dateCreated;
	}

	public History(String chatterName, String message) {
		this.chatterName = chatterName;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChatterName() {
		return chatterName;
	}

	public void setChatterName(String chatterName) {
		this.chatterName = chatterName;
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
