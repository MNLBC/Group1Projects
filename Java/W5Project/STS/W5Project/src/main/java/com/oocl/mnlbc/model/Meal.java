package com.oocl.mnlbc.model;

/**
 * Model Class. Used as backbone/pattern for the meal attributes (based on the
 * database table Meal)
 * 
 * 
 * @author Group 1
 * @since 07-18-2016
 */

// Use as the backbone for Table Meal

public class Meal {

	private int id;
	private String code;
	private String name;
	private String description;
	private String category;
	private double price;
	private String image;

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
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

	public void setCode(String code) {
		this.code = code;
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
