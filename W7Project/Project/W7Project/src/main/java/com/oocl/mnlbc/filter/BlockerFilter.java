package com.oocl.mnlbc.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.oocl.mnlbc.entity.User;

/**
 * 
 * @author LIMOSJO
 *
 */
public class BlockerFilter implements Filter {
	final static Logger logger = Logger.getLogger(BlockerFilter.class);

	/**
	 * Default constructor.
	 */
	public BlockerFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
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

				ServletContext context = session.getServletContext();
				List<User> logged = (List<User>) context.getAttribute("logged");
				if (logged != null) {

					logged.remove(user);
					session.invalidate();
				}
				logger.info("User " + user + " is blocked.");
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
	}

}
