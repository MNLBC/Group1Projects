package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.*;

public interface UserDAO {

	public void setDataSource(DataSource ds);

	public void create(String userName, String password, String fname, String lname, String email);

}
