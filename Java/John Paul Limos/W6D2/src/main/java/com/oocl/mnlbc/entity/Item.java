package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@Column(name = "item_id")
	String itemId;
	@Column(name = "item_name")
	String itemName;
	@Column(name = "item_category")
	String itemCategory;
	@Column(name = "item_stock")
	int itemStock;
	@Column(name = "item_price")
	int itemPrice;

	public Item() {
	}

	public Item(String itemId) {
		this.itemId = itemId;
	}

	public Item(String itemId, String itemName) {
		this.itemId = itemId;
		this.itemName = itemName;
	}

	public Item(String itemId, String itemName, String itemCategory) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
	}

	public Item(String itemId, String itemName, String itemCategory, int itemStock) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemStock = itemStock;
	}

	public Item(String itemId, String itemName, String itemCategory, int itemStock, int itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemStock = itemStock;
		this.itemPrice = itemPrice;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

}
