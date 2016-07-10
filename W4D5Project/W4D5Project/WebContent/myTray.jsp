<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header" >
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">Brand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1" >
			<ul class="nav navbar-nav" id="nav">
				<li class="active">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" id="drop" >Category<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" id="comboMeals">Combo Meals</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#" id="drinks">Drinks</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#" id="burgers">Burgers</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#" id="chicken">Chickens</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#" id="desserts">Desserts</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#" id="sides">Sides</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Search</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#login">Login</a></li>
				<li><a href="#" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#register">Register</a></li>
				<li><a href="#" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#profile" id="myProfile">Welcome, User!</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
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
				<tr>
					<td>Cheeseburger</td>
					<td>1</td>
					<td>RMB 35</td>
					<td>
							<span class="glyphicon glyphicon-pencil" aria-hidden="true">
							<span class="glyphicon glyphicon-remove" aria-hidden="true">
							</span>
							</span>
					</td>
				</tr>
				<tr>
        <td>Bacon and Cheese Whopper</td>
        <td>1</td>
        <td>RMB 25</td>
      </tr>
    </tbody>
  </table>
  <h2>Subtotal: <span class="label label-default">RMB </span></h2>
  <div class="btn-group" role="group" aria-label="...">
  <button type="button" class="btn btn-primary btn-sm">Purchase Order</button>
  <button type="button" class="btn btn-primary btn-sm">Cancel</button>
</div>
</div>


</body>
</html>