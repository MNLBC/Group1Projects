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
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Category<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Combo Meals</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Drinks</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Burgers</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Desserts</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Sides</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="#" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#login">Login</a></li>
        <li><a href="#"  class="btn btn-primary btn-lg" data-toggle="modal" data-target="#register">Register</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<!-- Register -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
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
							<td><input type="radio" name="gender" value="female">Female &nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="male">Male</td>
						</tr>
					</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary">Register</button>
      </div>
    </div>
  </div>
</div>
<!-- Login -->
<!-- Modal -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Login Account</h4>
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
						
					</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary">Login</button>
      </div>
    </div>
  </div>
</div>
</body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Include all compiled plugins (below), or include individual files as needed -->

    <script src="resource/js/bootstrap.min.js"></script>
</html>