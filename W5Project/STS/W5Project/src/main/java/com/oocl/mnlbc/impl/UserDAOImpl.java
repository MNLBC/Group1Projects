package com.oocl.mnlbc.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.model.User;

public class UserDAOImpl implements UserDAO {
	private DataSource dataSource;
	private PlatformTransactionManager transactionManager;
	private JdbcTemplate jdbcTemplateObject;

	public List<User> getAllUsers() {
		return null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public DataSource executeTestSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public String addUser(final User user) {
		
		
		TransactionTemplate tt = new TransactionTemplate(getTransactionManager());
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				JdbcTemplate jt = new JdbcTemplate(executeTestSource());
				StringBuilder query = new StringBuilder();
				query.append("INSERT INTO USERS (USERNAME,PASSWORD,FIRSTNAME,MIDDLENAME,LASTNAME,GENDER,EMAIL,ADDRESS,CONTACTS,IS_DISABLED,TYPE) VALUES (");
				query.append("'"+ user.getUsername() + "',");
				query.append("'"+ user.getPassword() + "',");
				query.append("'"+ user.getFirstname() + "',");
				query.append("'"+ user.getMiddlename() + "',");
				query.append("'"+ user.getLastname() + "',");
				query.append("'"+ user.getGender() + "',");
				query.append("'"+ user.getEmail() + "',");
				query.append("'"+ user.getAddress() + "',");
				query.append("'"+ user.getContact() + "',");
				query.append( user.isDisabled() ? "0": "1" + ",");
				query.append("'"+ user.getType() + "')");
				jt.update(query.toString());
				return null;
			}
		});
		
		return "DONE";
	}

	public boolean checkUsernameExistence(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkEmailExistence(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
