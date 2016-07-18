package com.oocl.mnlbc.model;

/**
 * Model Class. Used as backbone/pattern for the order item attributes (based on
 * the database table OrderItems)
 * 
 * 
 * @author Group 1
 * @since 07-18-2016
 */

public class OrderItems {

	private int id;
	private int quantity;
	private int mealId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

}
