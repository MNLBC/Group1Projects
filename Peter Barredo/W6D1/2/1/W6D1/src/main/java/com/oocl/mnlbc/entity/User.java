package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@Column(name = "userId")
	private int userId;
	@Column(name = "userFirstName")
	private String userFirstName;
	@Column(name = "userLastName")
	private String userLastName;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Order> orderList;

	public User() {
	}

	public User(int userId) {
		this.userId = userId;
	}

	public User(int userId, String userFirstName) {
		this.userId = userId;
		this.userFirstName = userFirstName;
	}

	public User(int userId, String userFirstName, String userLastName) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

}
