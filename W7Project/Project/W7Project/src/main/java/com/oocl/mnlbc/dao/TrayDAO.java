/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.entity.Tray;

/**
 * @author LIMOSJO
 *
 */
public interface TrayDAO extends GenericDAO<Tray> {

	boolean addListTray(List<Tray> trays);

	List<Tray> getAllTrayByUserId(int id);
}
