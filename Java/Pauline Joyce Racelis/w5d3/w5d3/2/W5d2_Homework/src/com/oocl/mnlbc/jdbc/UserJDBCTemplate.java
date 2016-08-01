package com.oocl.mnlbc.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	public void create(String name, String username,String password,String email,String contact,String address) {
		String SQL = "insert into USERS (name, username,password,email,contact,address) values (?,?,?,?,?,?)";

		jdbcTemplateObject.update(SQL, name, username,password,email,contact,address);
		System.out.println("Created Record Name = " + name + " Username = " + username +
				"password" + password + "email" + email + "contact" + contact + "address" + address);
		return;
	}



}
