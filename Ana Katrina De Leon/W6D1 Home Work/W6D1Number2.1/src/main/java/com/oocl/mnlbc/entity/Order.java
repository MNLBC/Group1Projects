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
public class Order implements Serializable {

	@Id
	// (strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "order_date")
	private String orderDate;
	@Column(name = "shp_address")
	private String shpAddress;
	 @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	 @ManyToOne(optional = false, fetch = FetchType.LAZY)	
	 User userId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.LAZY)
	private List<OrderItem> itemList;

	public Order() {
	}
	
	

	public Order(Integer orderId, String orderDate, String shpAddress, User userId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.shpAddress = shpAddress;
		this.userId = userId;
	}



	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShpAddress() {
		return shpAddress;
	}

	public void setShpAddress(String shpAddress) {
		this.shpAddress = shpAddress;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public List<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	
	
	

	
}
