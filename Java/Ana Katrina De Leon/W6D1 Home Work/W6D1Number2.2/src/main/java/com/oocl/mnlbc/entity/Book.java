package com.oocl.mnlbc.entity;

import java.util.ArrayList;
import java.util.List;

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


@Entity(name="Book")
@Table(name="BOOK")
public class Book  implements java.io.Serializable {
	
    @Id
    @Column(name = "ID")
    private long id;
    
    @Column(name="NAME")
    private String name;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PRODUCT_BOOK", joinColumns = @JoinColumn(name = "ID"), inverseJoinColumns = @JoinColumn(name = "PROD_ID"))
    private List<Product> product = new ArrayList<Product>();

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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	
}
