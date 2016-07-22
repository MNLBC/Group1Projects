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

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "orderSequence")
	@SequenceGenerator(name = "orderSequence", sequenceName = "ORDERS_ID_SEQ", allocationSize = 1)
	@Column(name = "id")
	private int id;

//	@ManyToOne(optional = false, fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id", referencedColumnName = "id")
//	private User user;

	@Column(name = "status")
	private String status;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the user
	 */
//	public User getUser() {
//		return user;
//	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param user the user to set
	 */
//	public void setUser(User user) {
//		this.user = user;
//	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
}
