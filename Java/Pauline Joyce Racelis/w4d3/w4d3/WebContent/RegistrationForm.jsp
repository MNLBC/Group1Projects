<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<form method="POST" action="RegisterServlet">
<center>
<H2>Register User</H2> 
	<p> First name:</p><input type="text" name="firstName" required>
	<p> Last name: </p><input type="text" name="lastName" required>
	<p> Username: </p><input type = "text" name="username" required>
	<p> Password: </p><input type="password" name="password" required>
	<p> Email </p> <input type="email" name="email" required>
	<p> Contact number </p> <input type="text" name="contact" required>
	<p> Address </p> <input type= "text" name="address" required>
	<br><br>
	<input type= "submit" value="submit">
	</form>
	</center>
</body>
</html>