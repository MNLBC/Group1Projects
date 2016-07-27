package com.oocl.mnlbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.impl.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	HomeService homeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return homeService.home();
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return homeService.index();
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return homeService.admin();
	}

	@ResponseBody
	@RequestMapping(value = { "/getLoggedUsers" }, method = RequestMethod.GET)
	public List<User> getAllLoggedUsers(HttpSession session) {
		return homeService.getAllLoggedUsers(session);
	}

	@ResponseBody
	@RequestMapping(value = { "/getUserSession" }, method = RequestMethod.GET)
	private User getUserSession(HttpSession session) {
		return homeService.getUserSession(session);
	}

	@ResponseBody
	@RequestMapping(value = { "/visitor" }, method = RequestMethod.GET)
	public int getVisitors(HttpSession session) {
		return homeService.getVisitors(session);
	}

	@ResponseBody
	@RequestMapping(value = { "/hasLogged" }, method = RequestMethod.GET)
	private boolean hasSession(HttpSession session) {
		return homeService.hasSession(session);
	}

}
