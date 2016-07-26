/**
 * 
 */
package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author RACELPA
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Orderitems")
@NamedQuery(name="OrderItem.findAll", query="SELECT b FROM OrderItem b")
public class OrderItem implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItemsSequence")
	@SequenceGenerator(name = "orderItemsSequence", sequenceName = "ORDERITEMS_ID_SEQ", allocationSize = 1)
	@Column(name = "id")
	private int id;

	@JsonBackReference
	@ManyToOne(optional = false)
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
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @param meal
	 *            the meal to set
	 */
	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
