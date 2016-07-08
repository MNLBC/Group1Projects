package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.oocl.mnlbc.dao.TransactionDAO;
import com.oocl.mnlbc.dao.TransactionDAOImpl;
import com.oocl.mnlbc.models.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(UserServlet.class);
	private static final long serialVersionUID = 1L;
	private TransactionDAO transactionDAOImpl = new TransactionDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");
		String confPassword = request.getParameter("cpass");
		String firstName = request.getParameter("fname");
		String middleName = request.getParameter("mname");
		String lastName = request.getParameter("lname");
		String address = request.getParameter("address");
		String contactNum = request.getParameter("cnum");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");

		if(isUserExist(userName)){
			out.println("Username already exists!");
		} else if(ifEmailExist(userName,email)){
			out.println("Email already exists!");
		}else{
			String hashPass = passwordHash(password);
			out.print(hashPass);
			out.println("Success!");
//			 userRegister(firstName,lastName,middleName,address,contactNum,email,userName,password,gender);
		}
	}

	private boolean ifEmailExist(String userName, String email) {
		boolean emailExist;
		emailExist = transactionDAOImpl.checkIfEmailExists(new User(userName,email));
		return emailExist;
	}

	private boolean isUserExist(String userName) {
		boolean ifExist;
		ifExist = transactionDAOImpl.checkIfUserExists(new User(userName));
		return ifExist;
	}

	private String passwordHash(String password) {
		String md5 = null;

		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// Update input string in message digest
			digest.update(password.getBytes(), 0, password.length());
			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}

//	private void userRegister(String firstName, String lastName, String middleName, String address
//			, String contactNum, String email, String userName, String password, String gender) {
//		transactionDAOImpl.insertUser(new User(firstName,lastName,middleName,address,contactNum,email,userName,password,gender));
//		logger.info("Requesting to /UserServlet Success!!, User Succesfully Created.");
//	}

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
