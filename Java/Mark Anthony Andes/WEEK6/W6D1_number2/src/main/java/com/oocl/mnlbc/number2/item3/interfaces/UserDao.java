package com.oocl.mnlbc.number2.item3.interfaces;

import com.oocl.mnlbc.number2.item3.entity.User;

public interface UserDao extends GenericDao<User> {
	   
    public User loadUserByUsername(String username);
}