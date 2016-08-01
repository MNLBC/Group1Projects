package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order implements Serializable{
	
	@Id
	@Column(name = "orderId")
	private int orderId;
	
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User user;
	
	@Column(name = "orderDate")
	private Date orderDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
	private List<OrderItem> orderItemList;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

}
