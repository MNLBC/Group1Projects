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
	List<OrderItems> orderItems = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrayServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int product_id = Integer.parseInt(request.getParameter("productId"));
		int product_qty = Integer.parseInt(request.getParameter("productQuantity"));
		String product_cat = request.getParameter("productCategory");
		boolean update = false;

		// Adding meals to tray
		OrderItems newOrderItem = new OrderItems(product_cat, product_qty, product_id);

		// Getting the tray to the session
		orderItems = (List<OrderItems>) session.getAttribute("cartItems");

		if (orderItems == null) {
			orderItems = new ArrayList<OrderItems>();
		}

		for (OrderItems orderItem : orderItems) {
			if (orderItem.getMealId() == newOrderItem.getMealId()) {
				int newQty = orderItem.getQuantity() + newOrderItem.getQuantity();
				orderItem.setQuantity(newQty);
				update = true;
			}
		}

		if (!update) {
			orderItems.add(newOrderItem);
		}

		session.setAttribute("cartItems", orderItems);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

	}

}
