package com.oocl.mnlbc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = { "/logged" })
	public int getUserLogged(HttpSession session) {
		ServletContext context = session.getServletContext();
		List<User> logged = (List<User>) context.getAttribute("logged");
		if (logged == null) {
			logged = new ArrayList<User>();
		}

		return logged.size();
	}

	@ResponseBody
	@RequestMapping(value = { "/visitor" })
	public int getVisitors(HttpSession session) {
		ServletContext context = session.getServletContext();

		List<String> visitor = (List<String>) context.getAttribute("visitor");
		if (visitor == null) {
			visitor = new ArrayList<String>();
		}
		return visitor.size();
	}

	@ResponseBody
	@RequestMapping(value = { "/hasLogged" })
	private boolean hasSession(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
}
