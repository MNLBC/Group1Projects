<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<center>
	<div style="border: thin solid black; margin:10% 30% 15% 30%; padding:5% 5% 5% 5%;">
		<form method="post" action="RegisterUser">
			<table>
				<tr>
					<td align="center" colspan="2">
						<h3>Enter user information</h3>
					</td>
				</tr>
				<tr>
					<td>User name:</td>
					<td><input type="text" required name="username"></td>
				</tr>
				<tr>
					<td>First name:</td>
					<td><input type="text" required name="fname"></td>
				</tr>
				<tr>
					<td>Last name:<br></td>
					<td><input type="text" required name="lname"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" required name="password"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" required name="email">
					<td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><input type="radio" name="gender" value="MALE" checked>
						Male<input type="radio" name="gender" value="FEMALE">
						Female</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><INPUT TYPE="SUBMIT" value = "Submit Information"
						align="center"  /></td>
				</tr>
			</table>
		</form>
		</div>
	</center>

</body>
</html>