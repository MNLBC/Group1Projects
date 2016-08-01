package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.dao.TransactionDAO;
import com.oocl.mnlbc.dao.TransactionDAOImpl;
import com.oocl.mnlbc.models.Order;
import com.oocl.mnlbc.models.OrderItems;
import com.oocl.mnlbc.models.User;

/**
 * Servlet implementation class PurchaseServlet. Used to control the purchase implementation.
 * Handles the purchasing of the items from the tray.
 * 
 * @author Group 1
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<OrderItems> orderItems = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userObject");
		int id = user.getId();
		String status = "Done";
		Order order = new Order(id, status);
		TransactionDAO trans = new TransactionDAOImpl();

		// Inserting user's order to database
		if (session.getAttribute("cartItems") != null) {
			orderItems = (List<OrderItems>) session.getAttribute("cartItems");
			trans.insertOrder(order);
			order.setId(trans.getCurrSeqFromOrder());
			for (OrderItems orderItem : orderItems) {
				trans.insertOrderItem(order.getId(), orderItem);
			}
			
			// Emptying tray after ordering
			session.setAttribute("cartItems", new ArrayList<OrderItems>());
		}
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
