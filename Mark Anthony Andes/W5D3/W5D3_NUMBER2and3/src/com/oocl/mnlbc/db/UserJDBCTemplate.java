package com.oocl.mnlbc.db;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oocl.mnlbc.dao.UserDAO;

public class UserJDBCTemplate implements UserDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String username, String password, String email) {
		String SQL ="INSERT INTO USERS2 (username,password,email) VALUSE (?,?,?)";
		jdbcTemplateObject.update(SQL, username, password,email);
		return;
		
		
	}

}
