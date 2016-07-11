package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.dao.TransactionDAO;
import com.oocl.mnlbc.dao.TransactionDAOImpl;
import com.oocl.mnlbc.models.User;

/**
 * Servlet implementation class AdminUserMaintenanceServlet
 */
@WebServlet("/AdminUserMaintenanceServlet")
public class AdminUserMaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/user.jsp";
	private static String EDIT = "/edit.jsp";
	private static String ALLUSERS = "/listUser.jsp";
	private TransactionDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUserMaintenanceServlet() {
		super();
		dao = new TransactionDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String redirect = "";
		String uId = request.getParameter("userid");
		String action = request.getParameter("action");
		//
		// if(!((uId)== null) && action.equalsIgnoreCase("insert"))
		// {
		// int id = Integer.parseInt(uId);
		// User user = new User();
		// user.setFirstName(request.getParameter("firstname"));
		// user.setLastName(request.getParameter("middlename"));
		// user.setLastName(request.getParameter("lastname"));
		//
		// dao.insertUser(user);
		// redirect = ALLUSERS;
		// request.setAttribute("users", dao.getUsers());
		// }
		// else if (action.equalsIgnoreCase("delete")){
		// String userId = request.getParameter("userId");
		// int uid = Integer.parseInt(userId);
		// dao.removeUser(uid);
		// redirect = UserRecord;
		// request.setAttribute("users", dao.getAllUsers());
		// System.out.println("Record Deleted Successfully");
		// }else if (action.equalsIgnoreCase("editform")){
		// redirect = Edit;
		// } else if (action.equalsIgnoreCase("edit")){
		// String userId = request.getParameter("userId");
		// int uid = Integer.parseInt(userId);
		// UserBean user = new UserBean();
		// user.setId(uid);
		// user.setfName(request.getParameter("firstName"));
		// user.setlName(request.getParameter("lastName"));
		// dao.editUser(user);
		// request.setAttribute("user", user);
		// redirect = UserRecord;
		// System.out.println("Record updated Successfully");
		// } else if (action.equalsIgnoreCase("listUser")){
		// redirect = UserRecord;
		// request.setAttribute("users", dao.getAllUsers());
		// } else {
		// redirect = INSERT;
		// }
		//
		// RequestDispatcher rd = request.getRequestDispatcher(redirect);
		// rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
