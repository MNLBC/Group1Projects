package com.oocl.mnlbc.model;

import java.util.List;

/**
 * Model Class. Used as backbone/pattern for the combo meal attributes (based on the database table Combo_Meal)
 * 
 * @author Group 1
 *
 */

// Use as the backbone for Table Combo_Meal

public class ComboMeal {
	private int id;
	private String code;
	private String name;
	private String description;
	private double price;
	private String image;
	private List<Meal> mealList;


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

	public double getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public List<Meal> getMealList() {
		return mealList;
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

	public void setPrice(double price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setMealList(List<Meal> mealList) {
		this.mealList = mealList;
	}
}
