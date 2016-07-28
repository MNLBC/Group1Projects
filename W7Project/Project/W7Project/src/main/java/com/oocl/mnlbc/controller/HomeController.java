package com.oocl.mnlbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.HomeService;

/**
 * Handles requests for the application home page.
 * 
 * @author DELOAN
 * @author LIMOSJO
 * 
 * @since 07/22/16
 */
@Controller
public class HomeController {

	/**
	 * Automatic instantiation of home Service
	 */
	@Autowired
	HomeService homeService;

	/**
	 * This request is for accessing the home page.
	 * 
	 * @return a string of success
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return homeService.home();
	}

	/**
	 * This request is for accessing using index url.
	 * 
	 * @return a string of success
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return homeService.index();
	}

	/**
	 * This request is for accessing using admin url.
	 * 
	 * @return a string of success
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return homeService.admin();
	}

	/**
	 * This request is for getting all the logged users.
	 * 
	 * @param session
	 *            the session of the page request
	 * @return list of users
	 */
	@ResponseBody
	@RequestMapping(value = { "/getLoggedUsers" }, method = RequestMethod.GET)
	public List<User> getAllLoggedUsers(HttpSession session) {
		return homeService.getAllLoggedUsers(session);
	}

	/**
	 * This request is for getting the user of the session.
	 * 
	 * @param session
	 *            the session of the page request
	 * @return an object of User
	 */
	@ResponseBody
	@RequestMapping(value = { "/getUserSession" }, method = RequestMethod.GET)
	private User getUserSession(HttpSession session) {
		return homeService.getUserSession(session);
	}

	/**
	 * This request is for getting all the visitors of the page.
	 * 
	 * @param session
	 *            the session of the page request
	 * @return integer of number of visitors
	 */
	@ResponseBody
	@RequestMapping(value = { "/visitor" }, method = RequestMethod.GET)
	public int getVisitors(HttpSession session) {
		return homeService.getVisitors(session);
	}

	/**
	 * This request is for session has user.
	 * 
	 * @param session
	 *            the session of the page request
	 * @return boolean result of checking
	 */
	@ResponseBody
	@RequestMapping(value = { "/hasLogged" }, method = RequestMethod.GET)
	private boolean hasSession(HttpSession session) {
		return homeService.hasSession(session);
	}

}
