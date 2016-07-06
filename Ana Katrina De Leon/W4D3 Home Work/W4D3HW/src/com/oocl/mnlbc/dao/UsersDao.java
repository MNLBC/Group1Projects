package com.oocl.mnlbc.dao;


import com.oocl.mnlbc.models.UsersModel;

public interface UsersDao {
	public boolean addUser(UsersModel users);
	public boolean isUserExisting(UsersModel users);
}
