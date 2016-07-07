package com.oocl.mnlbc.models;

/**
 * 
 * @author Group 1
 *
 */
public class OrderItems {

	private int id;
	private String type;
	private int orderId;
	private int qty;
	private int mealId;
	private String dateCreated;
	private String dateUpdated;

	public OrderItems(String type, int orderId, int qty, int mealId, String dateCreated, String dateUpdated) {
		this.type = type;
		this.orderId = orderId;
		this.qty = qty;
		this.mealId = mealId;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getQty() {
		return qty;
	}

	public int getMealId() {
		return mealId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getDateUpdated() {
		return dateUpdated;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
