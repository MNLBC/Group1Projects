package com.oocl.mnlbc.models;

/**
 * 
 * @author Group 1
 *
 */
public class Meal {

	private int id;
	private String name;
	private String desc;
	private String category;
	private double price;
	private String image;

	public Meal(String name, String desc, String category, double price, String image) {
		this.name = name;
		this.desc = desc;
		this.category = category;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
