package com.oocl.mnlbc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Login
 */

/**
 * 
 * @author Group 1
 *
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	final static Logger logger = Logger.getLogger(Login.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String safe = request.getParameter("safe");

		if (safe.equalsIgnoreCase(request.getSession().getAttribute("safecode").toString())) {
			if (username.equals(pwd)) {
				response.getWriter().println(username + " OK");
				logger.info("User: " +username +" Request to /Login success...");
			} else {
				response.getWriter().println(username + " PASSWORD ERROR");
				logger.warn("User: " +username +" Request to /Login failed because Password is incorrect...");
			}
		} else {
			response.getWriter().println(username + " SAFE CODE ERROR");
			logger.error("User: " +username +" Request to /Login but captcha is incorrect...");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
