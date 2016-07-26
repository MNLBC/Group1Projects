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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author DELEOAN
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Tray")
@NamedQuery(name="Tray.findAll", query="SELECT b FROM Tray b")
public class Tray implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traySequence")
	@SequenceGenerator(name = "traySequence", sequenceName = "TRAY_SEQ", allocationSize = 1)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "meal_id", referencedColumnName = "id")
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
	 * @return the user
	 */
	public User getUser() {
		return user;
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
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
