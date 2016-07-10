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
	private TransactionDAO transactionDAOImpl = new TransactionDAOImpl();

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
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("loginUsername");
		String password = request.getParameter("loginPass");
		String hashPass = passwordHash(password);
		int isActive = isUsernameEmailExist(userName, hashPass);

		if (isActive == 1) {
			out.println("Invalid Username/Password");
		} else if (isActive == 2) {
			out.println("User is blocked.");
		} else {
			out.println("Welcome!");
		}

	}

	private int isUsernameEmailExist(String userName, String hashPass) {
		boolean isUserCorrect = transactionDAOImpl.checkUserandPass(userName, hashPass);
		boolean isUserDisable = transactionDAOImpl.checkUserIfActive(userName);

		if (!isUserCorrect) {
			return 1;
		} else if (isUserCorrect && isUserDisable) {
			return 2;
		} else {
			return 0;
		}
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
