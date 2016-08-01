package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.database.registerUser;
import com.oocl.mnlbc.model.Register;

/**
 * Servlet implementation class registrationValidation
 */
@WebServlet("/registrationValidation")
public class registrationValidation extends HttpServlet {
	private registerUser register = new registerUser();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registrationValidation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String user = request.getParameter("userName");
		String pass = request.getParameter("password");

		if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !user.isEmpty() && !pass.isEmpty()) {
			
			try {
				if (!isUserExist(user)) {
					register(firstName, lastName, email, user, pass);
					request.setAttribute("alert", "valid");
					request.setAttribute("msg", "Successfully Created!");
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request, response);

				} else {
					request.setAttribute("alert", "error");
					request.setAttribute("msg", "Username already exists!");
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			request.setAttribute("alert", "error");
			request.setAttribute("msg", "Fields must have a value");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
	}

	private void register(String firstName, String lastName, String email, String user, String pass) {
		register.insert(new Register(firstName, lastName, email, user, pass));
	}

	private boolean isUserExist(String user) throws SQLException {
		boolean ifExist;
		ifExist = register.cheakIfExists(new Register(user));
		return ifExist;
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
