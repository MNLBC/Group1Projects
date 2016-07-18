package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oocl.mnlbc.model.User;


public class UserJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(User user) {
		String SQL = "insert into USERS (USERNAME,PASSWORD,FIRSTNAME,LASTNAME) values(?,?,?)";

		jdbcTemplateObject.update(SQL,user.getUsername(),user.getPassword(),user.getFirstName(),user.getLastName());
		System.out.println("User created");
		return;
	}
}
