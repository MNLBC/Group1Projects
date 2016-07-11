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

import com.oocl.mnlbc.models.Order;
import com.oocl.mnlbc.models.OrderItems;

/**
 * Servlet implementation class TrayServlet
 */
@WebServlet("/TrayServlet")
public class TrayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<OrderItems> orderItm = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrayServlet() {
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
		HttpSession session = request.getSession();
		int product_id = Integer.parseInt(request.getParameter("productId"));
		int product_qty = Integer.parseInt(request.getParameter("productQuantity"));
		String product_cat = request.getParameter("productCategory");

		// Adding meals to tray
		OrderItems orderItem = new OrderItems(product_cat, product_qty, product_id);

		// Getting the tray to the session
		orderItm = (List<OrderItems>) session.getAttribute("cartItems");

		if (orderItm == null) {
			orderItm = new ArrayList<OrderItems>();
		}

		orderItm.add(orderItem);
		session.setAttribute("cartItems", orderItm);
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

	private void deleteCart(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	private void updateCart(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}
}
