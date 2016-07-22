/**
 * 
 */
package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author RACELPA
 *
 */
@Entity
@Table(name = "Orderitems")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "orderItemsSequence")
	@SequenceGenerator(name = "orderItemsSequence", sequenceName = "ORDERSITEMS_ID_SEQ", allocationSize = 1)
	@Column(name = "id")
	private int id;

	@JoinColumn(name = "order_id", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Order order;

	@JoinColumn(name = "meal_id", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Meal meal;

	@Column(name = "quantity")
	private int quantity;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @return the meal
	 */
	public Meal getMeal() {
		return meal;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @param meal the meal to set
	 */
	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
