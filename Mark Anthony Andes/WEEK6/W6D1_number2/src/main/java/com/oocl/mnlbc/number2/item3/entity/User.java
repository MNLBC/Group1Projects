package com.oocl.mnlbc.number2.item3.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_id")
    private Integer usersId;
    @Column(name = "users_name")
    private User usersName;

    public User() {
    	
    	
    }

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public User getUsersName() {
		return usersName;
	}

	public void setUsersName(User usersName) {
		this.usersName = usersName;
	}
    
    }
    

    