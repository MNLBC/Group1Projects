package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Item")
public class Item implements Serializable {
	@Id
	@Column(name = "item_id")
	private String item_id;
	@Column(name = "item_name")
	private String item_name;
	@Column(name = "item_category")
	private String item_category;
	@Column(name = "item_stock")
	private int item_stock;
	@Column(name = "item_price")
	private int item_price;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
	public int getItem_stock() {
		return item_stock;
	}
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}
	public Item() {
	}
	public Item(String item_id, String item_name, String item_category, int item_stock, int item_price) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_category = item_category;
		this.item_stock = item_stock;
		this.item_price = item_price;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
}
