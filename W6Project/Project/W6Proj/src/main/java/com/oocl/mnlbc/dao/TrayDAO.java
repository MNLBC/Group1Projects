/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Tray;

/**
 * @author LIMOSJO
 *
 */
public interface TrayDAO {
	public void init();
	
	public EntityManager getEntityManager();
	
	public Tray getTrayByUserId(int id);
	
	public Tray removeTrayByUserId(int id);
	
	public Tray addTray(Tray tray);

}
