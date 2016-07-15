package com.oocl.mnlbc.model;

/**
 * Model Class. Used as backbone/pattern for the order items attributes (based
 * on the database table orderItems)
 * 
 * @author Group 1
 *
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
