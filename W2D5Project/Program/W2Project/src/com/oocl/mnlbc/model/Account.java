package com.oocl.mnlbc.model;

/**
 * Account class that will be used as a model object.
 * 
 * @author Group 1
 *
 */
public class Account {
	private String name;

	public Account(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
