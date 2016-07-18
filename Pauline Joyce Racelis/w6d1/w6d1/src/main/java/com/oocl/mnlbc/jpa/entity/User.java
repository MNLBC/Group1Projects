package com.oocl.mnlbc.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
public class User implements Serializable {
	
	@Id
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "user_firstName")
	private String user_firstName;
	@Column(name="user_LastName")
	private String user_LastName;
	public User(int user_id, String user_firstName, String user_LastName) {
		this.user_id = user_id;
		this.user_firstName = user_firstName;
		this.user_LastName = user_LastName;
	}
	public User(List<Order> orderList) {
		this.orderList = orderList;
	}
	public User() {
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Order> orderList;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_firstName() {
		return user_firstName;
	}
	public void setUser_firstName(String user_firstName) {
		this.user_firstName = user_firstName;
	}
	public String getUser_LastName() {
		return user_LastName;
	}
	public void setUser_LastName(String user_LastName) {
		this.user_LastName = user_LastName;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}
