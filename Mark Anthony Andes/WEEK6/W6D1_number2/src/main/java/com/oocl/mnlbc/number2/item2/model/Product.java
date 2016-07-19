package com.oocl.mnlbc.number2.item2.model;

import java.awt.List;
import java.awt.print.Book;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Product")
@Table(name = "Product")
public class Product implements java.io.Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM_SEQUENCE")
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "categoey_id", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "cate_id"))
	private ArrayList<Book> cateGory = new ArrayList<Book>();

	public Product() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getCateGory() {
		return cateGory;
	}

	public void setCateGory(ArrayList<Book> cateGory) {
		this.cateGory = cateGory;
	}

}
