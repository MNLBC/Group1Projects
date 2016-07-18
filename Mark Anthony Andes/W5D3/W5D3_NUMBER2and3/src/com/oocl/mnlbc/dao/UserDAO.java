package com.oocl.mnlbc.dao;

import javax.sql.DataSource;

public interface UserDAO {

	
	public void setDataSource(DataSource dateSource);
	
	public void create(String username, String password , String email);
	
	
	
}
