package com.oocl.mnlbc.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;

@Service
public class LoginService {
	
	final static Logger logger = Logger.getLogger(LoginService.class);
	
	@Autowired
	UserDAO userDAO;
	
//	public User login(){
//		
//	}
	
}
