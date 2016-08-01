package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.models.RegisterUser;

public interface RegisterDAO {
	boolean insert(RegisterUser user);

	List<RegisterUser> getUsers();
}
