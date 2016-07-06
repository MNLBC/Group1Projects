package com.oocl.mnlbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.dao.CommandDAO;
import com.oocl.mnlbc.dao.CommandDAOImpl;
import com.oocl.mnlbc.models.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUser() {
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
		String username = request.getParameter("username").toUpperCase();
		String fname = request.getParameter("fname").toUpperCase();
		String lname = request.getParameter("lname").toUpperCase();
		String email = request.getParameter("email").toUpperCase();
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		
		User user = new User(username, fname, lname, email, password, gender);
		if(isUserValid(user)){
			CommandDAO insert = new CommandDAOImpl();
			insert.insertUser(user);
		}else{
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Username already exists!');");  
			out.println("</script>");
			out.println("<html><a href=\"index.jsp\">Go back!</a></html>");
		  }
	}

	boolean isUserValid(User user) {
		
		CommandDAO validate = new CommandDAOImpl();
		return validate.isUserExisting(user);
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
