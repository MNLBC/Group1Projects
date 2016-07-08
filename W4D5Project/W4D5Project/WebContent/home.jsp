<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
		<div class="navbar-header">
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
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav" id="nav">
				<li class="active">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" id="drop">Category<span class="caret"></span></a>
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

	<!-- Register -->
	<div class="modal fade" id="register" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<form action="UserServlet">
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
								<td><input type="text" name="uname"></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="pass"></td>
							</tr>
							<tr>
								<td>Confirm Password:</td>
								<td><input type="password" name="cpass"></td>
							</tr>
							<tr>
								<td>First Name:</td>
								<td><input type="text" name="fname"></td>
							</tr>
							<tr>
								<td>Middle Name:</td>
								<td><input type="text" name="mname"></td>
							</tr>
							<tr>
								<td>Last Name:</td>
								<td><input type="text" name="lname"></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><input type="text" name="address"></td>
							</tr>
							<tr>
								<td>Contact No.:</td>
								<td><input type="text" name="cnum"></td>
							</tr>
							<tr>
								<td>E-mail:</td>
								<td><input type="email" name="email"></td>
							</tr>
							<tr>
								<td>Gender:</td>
								<td><input type="radio" name="gender" value="female">Female
									&nbsp;&nbsp;&nbsp;<input type="radio" name="gender"
									value="male">Male</td>
							</tr>
							<tr>
							<td>Captcha</td>
							<td><input name="safe"><img id="safe" src=""></td>
							</tr>
						</table>
					
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-default"
						 data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-primary"
						onClick="validateRegFields()" value="Register">
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
				<form>
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
								<td><input type="text" name="loginUsername"></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="loginPass"></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-default" data-dismiss="modal"
						value="Cancel"> <input type="submit"
						onClick="validateLogin()" class="btn btn-primary" value="Login">
				</div>
				</form>
			</div>
		</div>
	</div>
	<div id="container">
		<div class="jumbotron">
			<div class="container">
				<h1>Hello, world!</h1>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Learn
						more</a>
				</p>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->

	<script src="resource/js/bootstrap.min.js"></script>
	<script>
		function validateRegFields() {
			var pass = $('[name="pass"]').val(), 
			confirmPass = $('[name="cpass"]').val(), 
			userName = $('[name="uname"]').val(), 
			firstName = $('[name="fname"]').val(), 
			lastName = $('[name="lname"]').val(), 
			email = $('[name="email"]').val(), 
			address = $('[name="address"]').val(), 
			contactNo = $('[name="cnum"]').val();

			if (pass == "" || confirmPass == "" || userName == ""
					|| firstName == "" || lastName == "" || email == ""
					|| address == "" || contactNo == "") {
				alert("Please complete all fields!")
			} else {
				if (pass != confirmPass) {
					alert("Password Mismatched!");
				}
			}
		}
		
		function validateLogin() {
			var pass = $('[name="loginPass"]').val(), 
			confirmPass = $('[name="loginUsername"]').val();
			
			if (pass == "" || confirmPass == "") {
				alert("Please complete all fields!");
			}
		}
		
		document.getElementById("safe").setAttribute("src", "safe.jpg?" + new Date().getMilliseconds());
	</script>
</body>
</html>