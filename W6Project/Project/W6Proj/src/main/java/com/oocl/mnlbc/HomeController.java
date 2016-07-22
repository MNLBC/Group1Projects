package com.oocl.mnlbc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	UserDAO userDao;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Accessing homepage");
		return "index";
	}

//	@ResponseBody
//	@RequestMapping(value = { "/getLoggedUsers" }, method = RequestMethod.GET)
//	public List<User> getAllLoggedUsers(HttpSession session) {
//		userDao.init();
//		logger.info("Getting all logged in users");
//		List<User> logged = userDao.getAllUsers();
//		if (logged == null) {
//			logged = new ArrayList<User>();
//		}
//		return logged;
//	}

//	@ResponseBody
//	@RequestMapping(value = { "/getUserSession" }, method = RequestMethod.GET)
//	private User getUserSession() {
//		userDao.init();
//		logger.info("Getting session of logged in user");
//		
//		if (user == null) {
//			return null;
//		} else {
//			return user;
//		}
//		
//	}
	
	


}
