package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Item Class Model
 * 
 * @author ANDESMA
 *
 *7/19/2016
 *
 */

@Entity
@Table(name = "Item")
public class Item {
	
@Id
	
	@Column(name = "item_id")
	private String itemId;

	public Item() {
	}

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "Item_category")
	private String itemCategory;

	@Column(name = "item_stock")
	private int itemStock;

	@Column(name = "item_price")
	private int itemPrice;

	public Item(String itemId) {
		this.itemId = itemId;
	}

	public String getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public int getItemStock() {
		return itemStock;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

}
