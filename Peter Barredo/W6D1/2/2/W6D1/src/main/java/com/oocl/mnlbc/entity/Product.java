package com.oocl.mnlbc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.eclipse.persistence.sessions.Project;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "ID")
	private long id;
	
	@ManyToMany
	@JoinTable(name = "PROD_BOOK", joinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "ID"))
	private List<Book> book;
}
