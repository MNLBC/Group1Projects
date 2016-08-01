package com.oocl.mnlbc.jpa.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "orderItem")
public class OrderItem implements Serializable{
	@Id
	@Column(name="order_itemId")
	private int order_itemId;
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Order order;
	@Column(name="quantity")
	private int order_quantity;
	public int getOrder_itemId() {
		return order_itemId;
	}
	public OrderItem(int order_itemId, Order order) {
		this.order_itemId = order_itemId;
		this.order = order;
	}
	public void setOrder_itemId(int order_itemId) {
		this.order_itemId = order_itemId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	public OrderItem(int order_itemId, Order order, int order_quantity) {
		this.order_itemId = order_itemId;
		this.order = order;
		this.order_quantity = order_quantity;
	}
	public OrderItem() {
	}
	

}
