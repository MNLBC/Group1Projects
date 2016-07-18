package com.oocl.mnlbc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity(name="Product")
@Table(name="PRODUCT")
public class Product implements java.io.Serializable {
	
    @Id
    @Column(name = "PROD_ID")
    private long prod_id;
    
    @Column(name = "name")
    private String name;

	public long getProd_id() {
		return prod_id;
	}

	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
