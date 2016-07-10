<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.oocl.mnlbc.models.OrderItems"%>
<%@ page import="com.oocl.mnlbc.models.Meal"%>
<%@ page import="com.oocl.mnlbc.dao.TransactionDAO"%>
<%@ page import="com.oocl.mnlbc.dao.TransactionDAOImpl"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Tray</title>
<style type="text/css">
    <%@include file="resource/css/bootstrap.min.css" %>
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$("document").ready(function() {
		$("#drinks").click(function() {
			$('#container').load('drinks.jsp');
		});
		
		$("#burgers").click(function() {
			$('#container').load('burger.jsp');
		});
		
		$("#comboMeals").click(function() {
			$('#container').load('comboMeal.jsp');
		});
		
		$("#chicken").click(function() {
			$('#container').load('chicken.jsp');
		});
		
		$("#purchase").click(function() {
			$.ajax({
				type : "GET",
				data : {
					name : ''
					
				},
				url : "PurchaseServlet",
				success : function(response) {
					alert("You have successfully entered your order! Your order will be delivered. Thank you for purchasing at Burger Queen")
				}
			});
		});
		

		$("#desserts").click(function() {
			$('#container').load('desserts.jsp');
		});
		
		$("#sides").click(function() {
			$('#container').load('sides.jsp');
		});
		
		$("#myProfile").click(function() {
			$('#container').load('customerProfile.jsp');
		});

	}); 

</script>
</head>
<body>

<%
	TransactionDAO dao = new TransactionDAOImpl();
	List<OrderItems> cartItems = (List<OrderItems>) session.getAttribute("cartItems");

%>
	<!-- /.container-fluid --> </nav>
<div class="container">
  <div class="jumbotron">
    <h1>My Tray</h1>
  </div>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Price</th>
      </tr>
    </thead>
    <tbody>
    <%
    double Total = 0.00;
    	for (OrderItems orderItem : cartItems){
    	Meal meal = dao.getMealByMealId(orderItem.getMealId());
    	
    %>
    
				<tr>
					<td><%= meal.getName() %></td>
					<td><%= orderItem.getQuantity() %></td>
					<td><%= meal.getPrice()  %></td>
					<td>
							<span class="glyphicon glyphicon-pencil" aria-hidden="true">
							<span class="glyphicon glyphicon-remove" aria-hidden="true">
							</span>
							</span>
					</td>
				</tr>
				
      <%
     Total += ( orderItem.getQuantity() * meal.getPrice());
    	}
   		 %>
    </tbody>
  </table>
  <h2>Total: <span class="label label-default"><%= Total %>RMB </span></h2>
  <div class="btn-group" role="group" aria-label="...">
  <button type="button" class="btn btn-primary btn-sm" id="purchase">Purchase Order</button>
  <button type="button" class="btn btn-primary btn-sm">Cancel</button>
</div>
</div>


</body>
</html>