package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.dao.TransactionDAO;
import com.oocl.mnlbc.dao.TransactionDAOImpl;
import com.oocl.mnlbc.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TransactionDAO transaction = new TransactionDAOImpl();

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String middlename = request.getParameter("middlename");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String email =  request.getParameter("email");
		
		boolean resp = false; 
		if(!transaction.isExisting(username)){
			User user = new User(username,password,firstname,middlename,lastname,email);
			transaction.save(user);
			resp = true;
		}
		response.setContentType("text/html"); 
		if(resp){
		PrintWriter out = response.getWriter();
	    out.println
	      ("<!DOCTYPE html>\n" +
	       "<html>\n" +
	       "<head><title>ALERT</title>"
	       + "<script>alert('Successfully Created');</script>"
	       + "</head>\n" +
	       "<body bgcolor=\"#fdf5e6\">\n" +
	       "</body></html>" );
		}else{
		 
		 PrintWriter out = response.getWriter();
		    out.println
		      ("<!DOCTYPE html>\n" +
		       "<html>\n" +
		       "<head><title>ALERT</title>"
		       + "<script>alert('Username already exists!');</script>"
		       + "</head>\n" +
		       "<body bgcolor=\"#fdf5e6\">\n" +
		       "</body></html>" );
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
