<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>

	<div>
		<center>
<br><br><br><br><br>

			<table border="1">
			<tr><td colspan="3" align="center"><h1>User Information</h1></td></tr>
				<tr>
					<th>FullName</th>
					<th>UserName</th>
					<th>Email</th></tr>
				<tr><td>${fullname}</td>
					<td>${user}</td>
					<td>${email}</td></tr>
				
			</table>
		</center>
	</div>

</body>
</html>