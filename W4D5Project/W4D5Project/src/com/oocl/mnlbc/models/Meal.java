package com.oocl.mnlbc.models;

import com.sun.jmx.snmp.Timestamp;

/**
 * 
 * @author Group 1
 *
 */
public class Meal {

	private int id;
	private String mealCode;
	private String name;
	private String description;
	private String category;
	private double price;
	private String image;

	public Meal(String mealCode, String name, String description, String category, double price, String image) {
		super();
		this.mealCode = mealCode;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getMealCode() {
		return mealCode;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMealCode(String mealCode) {
		this.mealCode = mealCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
