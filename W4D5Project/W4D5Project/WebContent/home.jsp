<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
  <style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 90%;
	margin: auto;
	
}
</style>
<style type="text/css">
    <%@include file="resource/css/bootstrap.min.css" %>
</style>

<script type="text/javascript">
	$(document).ready(function() {

		$("#myCarousel").carousel({

			interval : 3000,

			pause : false

		});

	});
</script>


<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		$("#searchForm").submit(function(){
			console.log("naks");
		});
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
		
		$("#myTray").click(function() {
			$('#container').load('myTray.jsp');
		});

	});
</script>



</head>
<body id="test">
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">Burger Queen</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav" id="nav">
				<li class="active">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" id="drop" action="MealServlet">Category<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<!-- <li><a href="#" id="comboMeals">Combo Meals</a></li> -->
						<!-- <li role="separator" class="divider"></li> -->
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
<!-- 			<form class="navbar-form navbar-left" id="searchForm" >
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button class="btn btn-default" id="searchButton" type="submit">Search</button>
			</form> -->
			<ul class="nav navbar-nav navbar-right">
			<%  String username = (String) session.getAttribute("user");
			if(username == null) {
			%>
				<li><a href="#" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#login">Login</a></li>
				<li><a href="#" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#register">Register</a></li>
			<%  }else { %>		
			
				<li><a href="#" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#profile" id="myProfile">Welcome, <% out.println(username);  %></a></li>
					<li><a href="#" class="btn btn-primary btn-lg" id="myTray">My Tray</a></li>
					<li><a href="Logout" class="btn btn-primary btn-lg">Logout</a></li>
					<% } %>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<!-- Register -->
	<div class="modal fade" id="register" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<form action="UserServlet" method="POST">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Register Account</h4>
				</div>
				<div class="modal-body">
					
						<table class="table">
							<tr>
								<td>User Name:</td>
								<td><input type="text" name="uname" required></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="pass" required></td>
							</tr>
							<tr>
								<td>Confirm Password:</td>
								<td><input type="password" name="cpass" required></td>
							</tr>
							<tr>
								<td>First Name:</td>
								<td><input type="text" name="fname" required></td>
							</tr>
							<tr>
								<td>Middle Name:</td>
								<td><input type="text" name="mname"></td>
							</tr>
							<tr>
								<td>Last Name:</td>
								<td><input type="text" name="lname" required></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><input type="text" name="address" required></td>
							</tr>
							<tr>
								<td>Contact No.:</td>
								<td><input type="text" name="cnum" required></td>
							</tr>
							<tr>
								<td>E-mail:</td>
								<td><input type="email" name="email" required></td>
							</tr>
							<tr>
								<td>Gender:</td>
								<td><input type="radio" name="gender" value="female">Female
									&nbsp;&nbsp;&nbsp;<input type="radio" name="gender"
									value="male">Male</td>
							</tr>
							<tr>
							<td>Captcha:</td>
							<td><input name="safe" required>&nbsp;<img id="safe" src=""></td>
							</tr>
						</table>
					
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-default"
						 data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-primary" value="Register">
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Login -->
	<!-- Modal -->
	<div class="modal fade" id="login" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="Login" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Login Account</h4>
					</div>
					<div class="modal-body">
						<table class="table">
							<tr>
								<td>User Name:</td>
								<td><input type="text" name="loginUsername" required></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="loginPass" required></td>
							</tr>
						</table>
			</div>
			<div class="modal-footer">
				<input type="submit" class="btn btn-default" data-dismiss="modal"
					value="Cancel"> <input type="submit"
					class="btn btn-primary" value="Login">
			</div>
			</form>
		</div>
	</div>
	</div>
	<hr>	
	<h3>Welcome to Burger Queen!</h3>
	<hr>
	<div id="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="resource/img/doublewhopper.png">
				</div>

				<div class="item">
					<img src="resource/img/whopper.png">
				</div>
			</div>

		</div>
		Total Visitors <%= session.getServletContext().getAttribute("counter")  %>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->

	<script src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript">
<%

String alertMessages = (String) request.getAttribute("alertMessages");
if (alertMessages == null) {
out.println("");
} else {
out.println("alert('"+alertMessages+"');");

}%>

document.getElementById("safe").setAttribute("src", "safe.jpg?" + new Date().getMilliseconds());
</script>
</body>
</html>