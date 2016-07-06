<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link href='http://fonts.googleapis.com/css?family=Abel'
	rel='stylesheet' type='text/css'>
</head>
<body style="font-family: Abel">
	<form method="POST" action="Register">
		<div id="nav">
		<h2>Register Account</h2>
			First Name: <input type="text" name="firstname" required> <br>
			Last Name: <input type="text" name="lastname" required> <br>
			Address: <input type="text" name="address"> <br> User
			Name: <input type="text" name="username" required> <br>
			Password: <input type="password" name="password" id="pass" required>
			<br> Email: <input type="email" name="email"> <br>
			<button type="submit" onclick="passVal()">Register</button>
		</div>
	</form>

</body>
</html>