package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.models.User;

public interface CommandDAO {
	boolean insertUser(User user);
	boolean isUserExisting(User user);
	
}
