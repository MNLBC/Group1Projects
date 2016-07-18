package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER")
public class OrderItem implements Serializable {

	@Id
	// (strategy = GenerationType.AUTO)
	@Column(name = "order_item_id")
	private Integer orderItemId;
	@Column(name = "item_desc")
	private String itemDesc;
	@Column(name = "item_price")
	private Integer itemPrice;
	@Column(name = "item_quantity")
	private Integer itemQuantity;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)	
    private Order orderId;

	public OrderItem() {
	}
	
	public OrderItem(Integer orderItemId, String itemDesc, Integer itemPrice, Integer itemQuantity, Order orderId) {
		this.orderItemId = orderItemId;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.orderId = orderId;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderItemId == null) ? 0 : orderItemId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (orderItemId == null) {
			if (other.orderItemId != null)
				return false;
		} else if (!orderItemId.equals(other.orderItemId))
			return false;
		return true;
	}
	
	
	
}
