package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout. Used to control the logout implementation.
 * Destroys the session after the user logs out.
 * 
 * @author Group 1
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		// Invalidation session when logging out

		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
			response.sendRedirect("home.jsp");
		}
	}

}
