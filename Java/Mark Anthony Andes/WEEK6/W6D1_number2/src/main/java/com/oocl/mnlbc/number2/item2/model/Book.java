package com.oocl.mnlbc.number2.item2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Book")
@Table(name = "Book")
public class Book implements java.io.Serializable {

	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORY_SEQUENCE")
	private long book_id;

	public Book() {
	}

	@Column(name = "name")
	private String name;

	public long getBook_id() {
		return book_id;
	}

	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}