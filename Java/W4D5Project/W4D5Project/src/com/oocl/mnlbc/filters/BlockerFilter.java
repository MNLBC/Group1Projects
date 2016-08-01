package com.oocl.mnlbc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.models.User;
/**
 * Filter Class. Used to filter certain limitations to users. Includes filtering for blocked users
 * based on the project requirement.
 * 
 * @author Group 1
 *
 */
public class BlockerFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("userObject");

		// A user has logged-in
		if (user == null) {
			chain.doFilter(request, response);
		} else {
			// Blocking User with the name Johns or Scott
			if (user.getFirstName().equalsIgnoreCase("Johns") || user.getFirstName().equalsIgnoreCase("Scott")) {
				session.invalidate();
				res.sendRedirect(req.getContextPath() + "/home.jsp");
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
