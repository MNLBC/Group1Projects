package com.oocl.mnlbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.dao.UserDao;
import com.oocl.mnlbc.dao.UserDaoImpl;
import com.oocl.mnlbc.model.User;

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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/RegistrationForm.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao dao = new UserDaoImpl();
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setContact(request.getParameter("contact"));
		user.setAddress(request.getParameter("address"));
		
		PrintWriter out = response.getWriter();
		if (isUserExisting(user)){
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('User Exists!');");
			   out.println("location='RegistrationForm.jsp';");
			   out.println("</script>");
		}else {
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('Registration Successful!');");
			   out.println("location='RegistrationForm.jsp';");
			   out.println("</script>");
			dao.addUser(user);
		}
	
	}
	private boolean isUserExisting(User users) {
		UserDaoImpl check = new UserDaoImpl();
		return check.isUserExisting(users);

		}

}
