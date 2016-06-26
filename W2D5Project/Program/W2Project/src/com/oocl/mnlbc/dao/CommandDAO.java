package com.oocl.mnlbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.oocl.mnlbc.model.History;
import com.oocl.mnlbc.model.Logs;

/**
 * The purpose of the CommandDAO is where we define the interactions of the
 * system.
 * 
 * @author Group 1
 *
 */
public interface CommandDAO {
	boolean insert(History history);

	List<History> getHistory();

	List<History> getHistory(String dateFrom);

	List<History> getHistory(String dateFrom, String dateTo);

	boolean insert(Logs log);

	List<Logs> getLogs();

	List<Logs> getLogs(String dateFrom);

	List<Logs> getLogs(String dateFrom, String dateTo);

}
