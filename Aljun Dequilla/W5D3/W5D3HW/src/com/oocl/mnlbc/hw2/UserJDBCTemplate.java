package com.oocl.mnlbc.hw2;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String uname, String fname, String lname, String password) {
		String SQL = "insert into UserReg (uname,fname,lname,password) values (?,?,?,?)";
		try {
			jdbcTemplateObject.update(SQL, uname, fname, lname, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Created Record Name = " + fname + " " + lname);
		return;
	}

	public User getUser(String uname) {
		String SQL = "select * from UserReg where uname = ?";
		User user = jdbcTemplateObject.queryForObject(SQL, new Object[] { uname }, new UserMapper());
		return user;
	}

	public List<User> listUsers() {
		String SQL = "select * from UserReg";
		List<User> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}

	public void delete(String uname) {
		String SQL = "delete from UserReg where uname = ?";
		jdbcTemplateObject.update(SQL, uname);
		System.out.println("Deleted Record with Username = " + uname);
		return;
	}

	public void update(String uname, String fname, String lname, String password) {
		String SQL = "update UserReg set fname = ? , lname = ? , password = ? where uname = ?";
		jdbcTemplateObject.update(SQL, fname, lname, password, uname);
		System.out.println("Updated Record with Username = " + uname);
		return;
	}

}