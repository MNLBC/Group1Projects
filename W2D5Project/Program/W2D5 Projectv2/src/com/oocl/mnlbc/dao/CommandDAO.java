package com.oocl.mnlbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.oocl.mnlbc.model.History;
import com.oocl.mnlbc.model.Logs;
/**
 * The purpose of the CommandDAO is where we define the interactions of the system.
 *@author Group 1
 *
 */
public interface CommandDAO {
	void insert(History history) throws SQLException;
	List<History> getHistory() throws SQLException;
	List<History> getHistory(String dateFrom) throws SQLException;
	List<History> getHistory(String dateFrom , String dateTo) throws SQLException;
	
	void insert(Logs log) throws SQLException;
	List<Logs> getLogs() throws SQLException;
	List<Logs> getLogs(String dateFrom) throws SQLException;
	List<Logs> getLogs(String dateFrom , String dateTo) throws SQLException;
	
}
