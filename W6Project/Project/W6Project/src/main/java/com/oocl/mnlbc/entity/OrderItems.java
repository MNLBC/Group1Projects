/**
 * 
 */
package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * @author RACELPA
 *
 */
public class OrderItems {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "quantity")
	private int quantity;
	
//	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "meal_id", referencedColumnName = "id")
	private Meal meal;
	
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the meal
	 */
	public Meal getMeal() {
		return meal;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param meal
	 *            the meal to set
	 */
	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

}
