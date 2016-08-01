/**
 * 
 */
package com.oocl.mnlbc.hw2.num2;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author DEQUIAL
 *
 */
@Entity
@DiscriminatorValue(value = "BOOK")
public class Book extends Product {
	@Column(name = "AUTHOR")
	private String author;

	/**
	 * @param id
	 */
	public Book(long id) {
		super(id);
	}

	/**
	 * @param id
	 * @param author
	 */
	public Book(long id, String author) {
		super(id);
		this.author = author;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

}
