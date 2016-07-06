package com.oocl.mnlbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.dao.UsersDao;
import com.oocl.mnlbc.dao.UsersDaoImpl;
import com.oocl.mnlbc.models.UsersModel;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
		UsersDao dao = new UsersDaoImpl();
		UsersModel users = new UsersModel();
		users.setFirstname(request.getParameter("firstname"));
		users.setLastname(request.getParameter("lastname"));
		users.setAddress(request.getParameter("address"));
		users.setUname(request.getParameter("username"));
		users.setPass(request.getParameter("password"));
		users.setEmail(request.getParameter("email"));

		if (isUserExisting(users)) {
			out.println("User's already existing!");
		} else {
			out.println("Register completed!");
			dao.addUser(users);
		}
	}

	private boolean isUserExisting(UsersModel users) {
		UsersDaoImpl check = new UsersDaoImpl();
		return check.isUserExisting(users);

	}

}
