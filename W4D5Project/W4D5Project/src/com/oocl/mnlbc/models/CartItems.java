package com.oocl.mnlbc.models;

import java.util.List;

public class CartItems {

	private int quantity;
	private double price;
	private String description;
	private double total;
	private List<OrderItems> cartContents;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<OrderItems> getCartContents() {
		return cartContents;
	}
	public void setCartContents(List<OrderItems> cartContents) {
		this.cartContents = cartContents;
	}
}
