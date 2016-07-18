package com.oocl.mnlbc.hw2.num1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@JoinColumn(name = "USERS_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User user;

	@JoinColumn(name = "ORDERITEM_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrderItem orderItem;

	/**
	 * 
	 */
	public Order() {
	}

	/**
	 * @param user
	 */
	public Order(User user) {
		this.user = user;
	}

	/**
	 * @param orderItem
	 */
	public Order(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	/**
	 * @param user
	 * @param orderItem
	 */
	public Order(User user, OrderItem orderItem) {
		this.user = user;
		this.orderItem = orderItem;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @return the orderItem
	 */
	public OrderItem getOrderItems() {
		return orderItem;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @param orderItem
	 *            the orderItem to set
	 */
	public void setOrderItems(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
//	@Override
//	public int hashCode() {
//		Integer hash = 0;
//		hash += (id != null ? id.hashCode() : 0);
//		return hash;
//	}
//
//	@Override
//	public boolean equals(Object object) {
//		if (!(object instanceof User)) {
//			return false;
//		}
//		User other = (User) object;
//		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//			return false;
//		}
//		return true;
//	}

//	@Override
//	public String toString() {
//		return "com.oocl.mnlbc.hw2.num1.model.Ord[ id= '" + id + "', firstName= '" + firstName + "', lastName= '"
//				+ lastName + "', address= '" + address + "', contacts= '" + contacts + "' ]";
//	}
}
