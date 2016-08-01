package com.oocl.mnlbc.template;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.mapper.UserMapper;
import com.oocl.mnlbc.model.User;

public class UserJDBCTemplate implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String userName, String password, String fname, String lname, String email) {
		String SQL = "insert into Users (userName, password, firstname, lastname, email) values ('"+userName+"','"+
				password+"','"+fname+"','"+lname+"','"+email+"')";
		jdbcTemplateObject.update(SQL);
		System.out.println("Created Record Name = " + fname + " " + lname + " User name = " + userName + " Email = " + email);
		
	}
}
