package com.oocl.mnlbc.filter;

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

import com.oocl.mnlbc.model.User;

/**
 * Servlet Filter implementation class BlockerFilter
 */
public class BlockerFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public BlockerFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		// A user has logged-in
		if (user == null) {
			chain.doFilter(request, response);
		} else {
			// Blocking User with the name Johns or Scott
			if (user.getFirstname().equalsIgnoreCase("Johns") || user.getFirstname().equalsIgnoreCase("Scott")) {
				session.invalidate();
				res.sendRedirect(req.getContextPath() + "/");
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
