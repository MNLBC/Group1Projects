/**
 * 
 */
package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DEQUIAL
 *
 */
@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@Column(name = "ID")
	private String itemId;

	@Column(name = "NAME")
	private String itemName;

	@Column(name = "CATEGORY")
	private String itemCategory;

	@Column(name = "STOCK")
	private Integer itemStock;

	@Column(name = "PRICE")
	private Integer itemPrice;

	/**
	 * 
	 */
	public Item() {
	}

	/**
	 * @param itemId
	 */
	public Item(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @param itemId
	 * @param itemName
	 */
	public Item(String itemId, String itemName) {
		this.itemId = itemId;
		this.itemName = itemName;
	}

	/**
	 * @param itemId
	 * @param itemName
	 * @param itemCategory
	 */
	public Item(String itemId, String itemName, String itemCategory) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
	}

	/**
	 * @param itemId
	 * @param itemName
	 * @param itemCategory
	 * @param itemStock
	 */
	public Item(String itemId, String itemName, String itemCategory, Integer itemStock) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemStock = itemStock;
	}

	/**
	 * @param itemId
	 * @param itemName
	 * @param itemCategory
	 * @param itemStock
	 * @param itemPrice
	 */
	public Item(String itemId, String itemName, String itemCategory, Integer itemStock, Integer itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemStock = itemStock;
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @return the itemCategory
	 */
	public String getItemCategory() {
		return itemCategory;
	}

	/**
	 * @return the itemStock
	 */
	public Integer getItemStock() {
		return itemStock;
	}

	/**
	 * @return the itemPrice
	 */
	public Integer getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @param itemCategory
	 *            the itemCategory to set
	 */
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	/**
	 * @param itemStock
	 *            the itemStock to set
	 */
	public void setItemStock(Integer itemStock) {
		this.itemStock = itemStock;
	}

	/**
	 * @param itemPrice
	 *            the itemPrice to set
	 */
	public void setItemPrice(Integer itemPrice) {
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
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Item)) {
			return false;
		}
		Item other = (Item) object;
		if ((this.itemId == null && other.itemId != null)
				|| (this.itemId != null && !this.itemId.equals(other.itemId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oocl.mnlbc.Item[ itemId='" + itemId + "', itemName='" + itemName + "', itemCategory='"
				+ itemCategory + "', itemPrice=" + itemPrice + ", itemStock=" + itemStock + "  ]";
	}
}
