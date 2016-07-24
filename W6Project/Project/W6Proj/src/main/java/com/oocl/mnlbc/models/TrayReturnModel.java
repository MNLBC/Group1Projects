/**
 * 
 */
package com.oocl.mnlbc.models;

import java.util.ArrayList;
import java.util.List;


/**
 * @author LIMOSJO
 *
 */
public class TrayReturnModel {

	int id;
	int userId;
	int mealId;
	int quantity;
	List<TrayReturnModel> trayModelList = new ArrayList<TrayReturnModel>();
	
	
	
	/**
	 * @param id
	 * @param userId
	 * @param mealId
	 * @param quantity
	 * @return 
	 */

	public TrayReturnModel(int id, int userId, int mealId, int quantity) {
		this.id = id;
		this.userId = userId;
		this.mealId = mealId;
		this.quantity = quantity;
	}
	

	/**
	 * 
	 */
	public TrayReturnModel() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @return the mealId
	 */
	public int getMealId() {
		return mealId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the trayModelList
	 */
	public List<TrayReturnModel> getTrayModelList() {
		return trayModelList;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @param mealId the mealId to set
	 */
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param trayModelList the trayModelList to set
	 */
	public void setTrayModelList(List<TrayReturnModel> trayModelList) {
		this.trayModelList = trayModelList;
	}
	
	
	
}
