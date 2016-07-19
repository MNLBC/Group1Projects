package com.oocl.mnlbc.number2.item1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ANDESMA
 *
 */

@Entity
@Table(name = "User")
public class Users implements Serializable {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "users_id")
	private Integer usersId;
	@Column(name = "users_name")
	private String usersName;
	@Column(name = "users_email")
	private String usersEmail;

	public Users() {
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
}