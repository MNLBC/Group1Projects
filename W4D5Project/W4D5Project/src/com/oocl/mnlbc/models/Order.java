package com.oocl.mnlbc.models;

import java.util.List;

/**
 * 
 * @author Group 1
 *
 */
public class Order {

	private int id;
	private int userId;
	private String status;
	private List<OrderItems> orderItemList;

	public Order(int userId) {
		this.userId = userId;
		this.status = "WAITING";
	}

	public Order(int userId, String status) {
		this.userId = userId;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public String getStatus() {
		return status;
	}

	public List<OrderItems> getOrderItemList() {
		return orderItemList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrderItemList(List<OrderItems> orderItemList) {
		this.orderItemList = orderItemList;
	}

}
