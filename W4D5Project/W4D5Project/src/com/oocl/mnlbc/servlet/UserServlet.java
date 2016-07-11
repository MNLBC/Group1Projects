package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private int isUsernameEmailExist(String userName, String email) {
		boolean isUserNameExist = transactionDAOImpl.isUsernameExisting(userName);
		boolean isEmailAlreadyInUse = transactionDAOImpl.isEmailExisting(email);

		if (isUserNameExist) {
			return 1;
		} else if (!isUserNameExist && isEmailAlreadyInUse) {
			return 2;
		} else {
			return 0;
		}
	}

	private String passwordHash(String password) {
		String md5 = null;

		// Password Hashing

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

	private void userRegister(User user) {
		transactionDAOImpl.insertUser(user);
		logger.info("Requesting to /UserServlet Success!!, User Succesfully Created.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("uname");
		String password = passwordHash(request.getParameter("pass"));
		String confPassword = passwordHash(request.getParameter("cpass"));
		String firstName = request.getParameter("fname");
		String middleName = request.getParameter("mname");
		String lastName = request.getParameter("lname");
		String address = request.getParameter("address");
		String contact = request.getParameter("cnum");
		String type = "customer";
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String image = "default.jpg";
		String safe = request.getParameter("safe");
		boolean isDisabled = false;

		// Captcha is right
		if (safe.equalsIgnoreCase(request.getSession().getAttribute("safecode").toString())) {

			// User already exist
			int isExisting = isUsernameEmailExist(userName, email);

			// Password and confirm password are not the same
			if (password.equals(confPassword)) {
				if (isExisting == 1) {

					// Username is already in use
					request.setAttribute("alertMessages", "Username already exists!");
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);

				} else if (isExisting == 2) {

					// Email is already in use
					request.setAttribute("alertMessages", "Email already exists!");
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);

				} else {
					// Registration validation successful

					User user = new User(firstName, lastName, middleName, address, contact, type, email, userName,
							password, gender, image, isDisabled);

					// Registering User in Database
					userRegister(user);
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);

				}
			} else {

				// Password does not match
				request.setAttribute("alertMessages", "Password did not match!");
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);

			}
		} else {

			// Wrong Safe code
			request.setAttribute("alertMessages", " SAFE CODE ERROR");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			response.sendRedirect("home.jsp");
			logger.error("User: " + userName + " Request to /Login but captcha is incorrect...");
		}
	}

}
