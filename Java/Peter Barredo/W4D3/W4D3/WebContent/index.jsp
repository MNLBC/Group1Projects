<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>W4D3</title>
<style type="text/css">
    <%@include file="css/bootstrap.min.css" %>
</style>
</head>
<body>

<div class="container">
	<div class="row main">
		<div class="panel-heading">
              <div class="panel-title text-center">
              		<h1 class="title">Register User</h1>
              		<hr />
              	</div>
           </div> 
		<div class="main-login main-center">
			<form class="form-horizontal" action="RegisterServlet">
				
				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label">Your Firstname</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="firstname" id="firstname"  placeholder="Enter your Firstname" required/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label">Your Middlename</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="middlename" id="middlename"  placeholder="Enter your Middlename" required/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label">Your Lastname</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="lastname" id="lastname"  placeholder="Enter your Lastname" required/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="email" class="cols-sm-2 control-label">Your Email</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
							<input type="email" class="form-control" name="email" id="email"  placeholder="Enter your Email" required/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="username" class="cols-sm-2 control-label">Username</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username" required/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="password" class="cols-sm-2 control-label">Password</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" required/>
						</div>
					</div>
				</div>

		

				<div class="form-group ">
					<input type="submit" class="btn btn-primary btn-lg btn-block login-button" id="register" value="Register" >
				</div>
				
			</form>
		</div>
	</div>
</div>
</body>
</html>