package com.oocl.mnlbc.models;

/**
 * 
 * @author Group 1
 *
 */
public class OrderItems {

	private int id;
	private String type;
	private int quantity;
	private int mealId;

	public OrderItems(String type, int quantity, int mealId) {
		this.type = type;
		this.quantity = quantity;
		this.mealId = mealId;
	}

	public OrderItems(int id, String type, int quantity, int mealId) {
		super();
		this.id = id;
		this.type = type;
		this.quantity = quantity;
		this.mealId = mealId;
	}

	public OrderItems() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getMealId() {
		return mealId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

}
