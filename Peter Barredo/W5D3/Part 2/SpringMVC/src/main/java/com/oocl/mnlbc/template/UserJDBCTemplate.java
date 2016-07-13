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

	@Override
	public void create(User user) {
		String SQL = "insert into users (fname, lname, email, phone, username, password, address) values (?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplateObject.update(SQL, user.getFname(), user.getLname(), user.getEmail(), user.getPhone(),
				user.getUsername(), user.getPassword(), user.getAddress());
		System.out.println("Created Record Name = " + user.getFname() + " " + user.getLname() + " Username = "
				+ user.getUsername());
		return;
	}

	@Override
	public List<User> listUsers() {
		String SQL = "select * from users";
		List<User> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}

	@Override
	public void create(String name, Integer age) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		
	}
}
