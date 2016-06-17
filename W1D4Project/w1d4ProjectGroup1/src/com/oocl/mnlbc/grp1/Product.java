package com.oocl.mnlbc.grp1;

public class Product {

	private String prodName;
	private double price;
	private String desc;

	public Product(String prodName, double price, String desc) {
		this.prodName = prodName;
		this.price = price;
		this.desc = desc;
	}

	// Accessors and Mutators
	public String getProdName() {
		return prodName;
	}

	public double getPrice() {
		return price;
	}

	public String getDesc() {
		return desc;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
