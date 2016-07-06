package com.oocl.mnlbc.dao;

import com.oocl.mnlbc.model.User;

public interface TransactionDAO {
	boolean save(User user);
	boolean isExisting(String user);
}
