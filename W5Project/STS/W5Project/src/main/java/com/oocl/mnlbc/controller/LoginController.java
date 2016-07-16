package com.oocl.mnlbc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.model.User;

@Controller
//@RequestMapping("/login")
public class LoginController {
	@Autowired
	UserDAO userDAO;

	@ResponseBody
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(@RequestParam(required = true) String username, @RequestParam(required = true) String password,
			HttpSession session) {
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				if (!user.isDisabled()) {
					session.setMaxInactiveInterval(60);
					ServletContext context = session.getServletContext();

					List<User> logged = (List<User>) context.getAttribute("logged");
					if (logged == null) {
						logged = new ArrayList<User>();
					}
					List<String> visitor = (List<String>) context.getAttribute("visitor");
					if (visitor == null) {
						visitor = new ArrayList<String>();
					}
					boolean flag = false;
					for (User name : logged) {
						if (name.equals(username)) {
							flag = true;
						}
					}
					if (!flag) {
						logged.add(user);
					}
					context.setAttribute("logged", logged);
					context.setAttribute("visitor", visitor);
					session.setAttribute("name", username);
					session.setAttribute("user", user);
					return "logged" + String.valueOf(logged.size()) + "visitor" + String.valueOf(visitor.size());
					// return session.getId();
				} else {
					return "disabled";
				}
			}
		}
		return "false";
	}

	@ResponseBody
	@RequestMapping(value = { "/username={username}&password={password}/logout" }, method = RequestMethod.GET)
	public String logout(@PathVariable("username") String username, @PathVariable("password") String password,
			HttpSession session) {
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

				ServletContext context = session.getServletContext();

				List<User> logged = (List<User>) context.getAttribute("logged");
				if (logged == null) {
					logged = new ArrayList<User>();
				}
				List<String> visitor = (List<String>) context.getAttribute("visitor");
				if (visitor == null) {
					visitor = new ArrayList<String>();
				}
				boolean flag = false;
				for (User name : logged) {
					if (name.equals(username)) {
						flag = true;
					}
				}
				if (flag) {
					logged.remove(username);
				}
				context.setAttribute("logged", logged);
				context.setAttribute("visitor", visitor);
				session.setAttribute("name", username);

				return "logged" + String.valueOf(logged.size()) + "visitor" + String.valueOf(visitor.size());
			}
		}
		return "false";
	}

	@ResponseBody
	@RequestMapping(value = { "/username={username}&password={password}/p" }, method = RequestMethod.GET)
	public String login2(@PathVariable("username") String username, @PathVariable("password") String password,
			HttpSession session) {

		// session.setMaxInactiveInterval(10);
		// session.setAttribute("name", username);
		return (String) session.getAttribute("name") + "sss";

	}
}
