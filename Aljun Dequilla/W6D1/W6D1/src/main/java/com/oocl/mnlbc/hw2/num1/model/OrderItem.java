/**
 * 
 */
package com.oocl.mnlbc.hw2.num1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author DEQUIAL
 *
 */

@Entity
@Table(name = "ORDERITEMS")
public class OrderItem {
	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRICE")
	private Integer price;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orderItem", fetch = FetchType.LAZY)
	private List<Order> orders;

	/**
	 * 
	 */
	public OrderItem() {
	}

	/**
	 * @param id
	 */
	public OrderItem(Integer id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param productName
	 */
	public OrderItem(Integer id, String productName) {
		this.id = id;
		this.productName = productName;
	}

	/**
	 * @param id
	 * @param productName
	 * @param price
	 */
	public OrderItem(Integer id, String productName, Integer price) {
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the productName
	 */
	public String getFirstName() {
		return productName;
	}

	/**
	 * @return the price
	 */
	public Integer getLastName() {
		return price;
	}

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setFirstName(String productName) {
		this.productName = productName;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setLastName(Integer price) {
		this.price = price;
	}

	/**
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public int hashCode() {
		Integer hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrderItem)) {
			return false;
		}
		OrderItem other = (OrderItem) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oocl.mnlbc.hw2.num1.model.OrderItem[ id= " + id + ", productName= '" + productName + "', price= "
				+ price + " ]";
	}
}
