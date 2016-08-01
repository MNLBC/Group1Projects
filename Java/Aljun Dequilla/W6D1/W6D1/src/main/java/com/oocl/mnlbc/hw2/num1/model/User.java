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
@Table(name = "USERS")
public class User {
	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "CONTACTS")
	private String contacts;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Order> orders;

	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param id
	 */
	public User(Integer id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param firstName
	 */
	public User(Integer id, String firstName) {
		this.id = id;
		this.firstName = firstName;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public User(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 */
	public User(Integer id, String firstName, String lastName, String address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param contacts
	 */
	public User(Integer id, String firstName, String lastName, String address, String contacts) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contacts = contacts;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the contacts
	 */
	public String getContacts() {
		return contacts;
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
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param contacts
	 *            the contacts to set
	 */
	public void setContacts(String contacts) {
		this.contacts = contacts;
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
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oocl.mnlbc.hw2.num1.model.User[ id= " + id + ", firstName= '" + firstName + "', lastName= '"
				+ lastName + "', address= '" + address + "', contacts= '" + contacts + "' ]";
	}
}
