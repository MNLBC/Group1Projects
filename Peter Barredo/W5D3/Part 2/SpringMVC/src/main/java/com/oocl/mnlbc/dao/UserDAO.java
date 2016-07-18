package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.User;

public interface UserDAO {

	public void setDataSource(DataSource ds);

	public void create(User user);

	public List<User> listUsers();

	public void create(String name, Integer age);

	public User getUser(Integer id);

	public List<User> listStudents();

	public void delete(Integer id);

	public void update(Integer id, Integer age);
}
