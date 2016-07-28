package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.util.PasswordHashing;

@Service
public class UserService {

	final static Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	UserDAO userDao;

	public User find(int id) {
		return userDao.find(id);
	}

	public List<User> getAll() {
		return userDao.getAll();
	}

	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	public boolean isUsernameExisting(String username) {

		try {
			getUserByUsername(username);
			return true;
		} catch (NoResultException e) {
			return false;
		}

	}

	public User getUserByEmail(String email) {
		return userDao.getUserByUsername(email);
	}

	public boolean isEmailExisting(String email) {

		try {
			getUserByEmail(email);
			return true;
		} catch (NoResultException e) {
			return false;
		}

	}

	public boolean updateUser(User user) {
		userDao.update(user);
		logger.info("User has been updated");
		return true;
	}

	public String addUser(User user) {

		String hash = PasswordHashing.getInstance().hashPassword(user.getPassword());
		user.setPassword(hash);
		user.setIsDisabled(0);
		user.setGender(user.getGender().toUpperCase());
		user.setType("customer");
		user.setPoints(0);
		user.setUserLevel(0);

		switch (isUsernameEmailExist(user.getUsername(), user.getEmail())) {
		case 1:
			logger.info("Client try to register Username: " + user.getUsername() + " is already in used.");
			return "username";
		case 2:
			logger.info("Client try to register Email: " + user.getEmail() + " is already in used.");
			return "email";
		default:
			userDao.add(user);
			return "success";
		}

	}

	private int isUsernameEmailExist(String username, String email) {
		boolean isUserNameExist = isUsernameExisting(username);
		boolean isEmailAlreadyInUse = isEmailExisting(email);

		if (isUserNameExist) {
			return 1;
		} else if (!isUserNameExist && isEmailAlreadyInUse) {
			return 2;
		} else {
			return 0;
		}
	}

	public String changePassword(String currentPass, String newPass, String username) {
		User user = userDao.getUserByUsername(username);
		currentPass = PasswordHashing.getInstance().hashPassword(currentPass);

		if (currentPass.equals(user.getPassword())) {

			newPass = PasswordHashing.getInstance().hashPassword(newPass);
			user.setPassword(newPass);
			userDao.update(user);
			return "success";

		} else {
			return "current password";
		}

	}

}
