/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Tray;
import com.oocl.mnlbc.models.TrayReturnModel;

/**
 * @author LIMOSJO
 *
 */
public interface TrayDAO {
	public void init();

	public EntityManager getEntityManager();

	public boolean addTray(Tray tray);

	public List<Tray> getAllTrayByUserId(int id);
	
	public boolean removeTray(Tray tray);

	boolean addListTray(List<Tray> trays);
}
