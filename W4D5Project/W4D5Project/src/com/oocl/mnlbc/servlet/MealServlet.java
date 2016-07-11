package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.oocl.mnlbc.dao.TransactionDAO;
import com.oocl.mnlbc.dao.TransactionDAOImpl;
import com.oocl.mnlbc.models.Meal;

/**
 * Servlet implementation class MealServlet
 */
@WebServlet("/MealServlet")
public class MealServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(MealServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MealServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TransactionDAO transaction = new TransactionDAOImpl();
		String category = request.getParameter("category");

		// Getting list of meals by Category
		List<Meal> meals = transaction.getMealsByCategory(category);

		request.setAttribute("mealsReturn", meals);

		// Converting Objects to Gson
		Gson gson = new Gson();
		String json = gson.toJson(meals);

		logger.info("Requesting to /MealServlet Success!!");

		response.getWriter().write(json);
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
