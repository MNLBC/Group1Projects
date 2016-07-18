package com.oocl.mnlbc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.eclipse.persistence.sessions.Project;

public class Book {
	@Id
	@Column(name = "ID")
	private long id;
	
	@ManyToMany
	@JoinTable(name = "PROD_BOOK", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "ID"))
	private List<Product> projects;
}
