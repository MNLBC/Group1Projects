/**
 * 
 */
package com.oocl.mnlbc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author RACELPA
 *
 */

@Entity
@Table(name = "Meal")
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mealSequence")
	@SequenceGenerator(name = "mealSequence", sequenceName = "MEAL_ID_SEQ", allocationSize = 1)
	@Column(name = "id")
	private int id;

	@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItem> orderItemList;
	
	@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Tray> trayList;
	
	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private float price;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "category")
	private String category;

	@Column(name = "points")
	private float points;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the points
	 */
	public float getPoints() {
		return points;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(float points) {
		this.points = points;
	}

	/**
	 * @return the orderItemList
	 */
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	/**
	 * @return the trayList
	 */
	public List<Tray> getTrayList() {
		return trayList;
	}

	/**
	 * @param orderItemList the orderItemList to set
	 */
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	/**
	 * @param trayList the trayList to set
	 */
	public void setTrayList(List<Tray> trayList) {
		this.trayList = trayList;
	}
	
	

}
