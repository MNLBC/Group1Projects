package com.oocl.mnlbc.models;

import com.sun.jmx.snmp.Timestamp;

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
	private Timestamp date_created;
	private Timestamp date_updated;

	public Meal(int id, String name, String desc, String category, double price, String image, Timestamp date_created,
			Timestamp date_updated) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.category = category;
		this.price = price;
		this.image = image;
		this.date_created = date_created;
		this.date_updated = date_updated;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
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

	public Timestamp getDate_created() {
		return date_created;
	}

	public Timestamp getDate_updated() {
		return date_updated;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public void setDate_created(Timestamp date_created) {
		this.date_created = date_created;
	}

	public void setDate_updated(Timestamp date_updated) {
		this.date_updated = date_updated;
	}

}
