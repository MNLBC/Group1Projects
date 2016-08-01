package com.oocl.mnlbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.dao.RegisterDAO;
import com.oocl.mnlbc.dao.RegisterDAOImpl;
import com.oocl.mnlbc.models.RegisterUser;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegisterDAO userDao = new RegisterDAOImpl();
		String uId = request.getParameter("uid");
		String fName = request.getParameter("fname").toUpperCase();
		String lName = request.getParameter("lname").toUpperCase();
		String pWord = request.getParameter("pwd").toUpperCase();
		PrintWriter writer = response.getWriter();
		RegisterUser user = new RegisterUser(uId, fName, lName, pWord);
		boolean isAvailable = true;

		for (RegisterUser userL : userDao.getUsers()) {
			if (userL.getuId().equals(uId)) {
				isAvailable = false;
			}
		}
		if (!isAvailable) {
			writer.println("<html> <head> <title>Registration Unsuccessful</title> </head>"
					+ "<body> <br> <h1 align=\"center\"> REGISTRATION UNSUCCESSFUL</h1> </body> </html>");
		} else {
			userDao.insert(user);
			writer.println(
					"<html> <head> <title>Registration Successful</title> </head>" + "<body> <br> <h1 align=\"center\"> Hi, "
							+ user.getfName() + " " + user.getlName() + "</h1> </body> </html>");
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
