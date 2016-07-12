<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href='http://fonts.googleapis.com/css?family=Abel'
	rel='stylesheet' type='text/css'>
</head>
<body style="font-family: Abel">
	<p>
		<font color="red">${errMsg}</font>
	</p>
	<center>
		<form action="register.do" method="post">
			<div>
				<h2>Register Account</h2>
				<table>
					<tr>
						<td><input type="text" name="firstname"
							placeholder="First Name" /></td>
					</tr>
					<td><input type="text" name="lastname" placeholder="Last Name" /></td>
					</tr>
					<td><input type="text" name="address" placeholder="Address" /></td>
					</tr>
					<td><input type="text" name="username" placeholder="User Name" /></td>
					</tr>
					<td><input type="password" name="password"
						placeholder="Password" /></td>
					</tr>
					<td><input type="password" name="cpassword"
						placeholder="Confirm Password" /></td>
					</tr>
					<tr>
						<td><input type="email" name="email" placeholder="E-mail" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Register" /></td>
					</tr>
				</table>

			</div>
		</form>
	</center>
</body>
</html>