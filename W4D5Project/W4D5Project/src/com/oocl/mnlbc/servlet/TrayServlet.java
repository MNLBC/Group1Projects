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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String strAction = request.getParameter("action");
//		   
//		  if(strAction!=null && !strAction.equals("")) {
//		   if(strAction.equals("add")) {
//			   addToCart(request);
//		   } else if (strAction.equals("Update")) {
//		    updateCart(request);
//		   } else if (strAction.equals("Delete")) {
//		    deleteCart(request);
//		   }
//		  }
//		  response.sendRedirect("ShoppingCart.jsp");
		
		String product_id = request.getParameter("productId");
		String product_qty = request.getParameter("productQuantity");
		String product_cat = request.getParameter("productCategory");
		
		OrderItems orderItem = new OrderItems();
		orderItem.setMealId(Integer.parseInt(product_id));
		orderItem.setQuantity(Integer.parseInt(product_qty));
		orderItem.setType(product_cat);
		
		Order order = new Order();
		
		HttpSession session = request.getSession();
		List<OrderItems> orderItems = null;
		
		if(session.getAttribute("cartItems") == null){
			orderItems= new ArrayList<OrderItems>();
		}else{
			orderItems = (List<OrderItems>) session.getAttribute("cartItems");
		}
		
		orderItems.add(orderItem);
		session.setAttribute("cartItems", orderItems);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

	private void deleteCart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	private void updateCart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	private void addToCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<OrderItems> orderItems = null;
		String productId = request.getParameter("productId");
		String productQuantity = request.getParameter("productQuantity");
		
		OrderItems orderItem = new OrderItems();
		orderItem.setId(Integer.parseInt(productId));
		orderItem.setQuantity(Integer.parseInt(productQuantity));
		
		
		if(session.getAttribute("cartItems") == null){
			orderItems= new ArrayList<OrderItems>();
		}else{
			orderItems = (List<OrderItems>) session.getAttribute("cartItems");
		}
		
		boolean isExist = false;
		for(OrderItems item : orderItems){
			if(item.getId() == orderItem.getId()){
				item.setQuantity(orderItem.getQuantity());
				isExist = true;
			}
		}
		
		if(!isExist){
			orderItems.add(orderItem);
		}
		
		session.setAttribute("cartItems", orderItems);
	}

}
