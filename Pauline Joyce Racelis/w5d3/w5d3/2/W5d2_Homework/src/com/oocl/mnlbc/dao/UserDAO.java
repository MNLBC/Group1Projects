package com.oocl.mnlbc.dao;

import javax.sql.DataSource;

public interface UserDAO {
	public void setDataSource(DataSource ds);
	public void create(String name, String username,String password,String email,String contact,String address);

}
