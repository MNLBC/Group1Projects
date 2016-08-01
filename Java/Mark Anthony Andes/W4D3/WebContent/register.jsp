<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

	<div align="center" siz>
		<fieldset style="width: 902px; ">
			<h1>
				<label>Register Account</label>
			</h1>
			<form action="registrationValidation" method="post">
				<table>
					<tr>
						<td><label>FirstName: </label> <input type="text"
							name="firstName" style="width: 166px; height: 40px; "/></td>
						<td style="height: 53px; "><label>LastName: </label> <input type="text"
							name="lastName" style="width: 166px; height: 40px; "/></td>
					</tr>

					<tr>
						<td colspan="2" style="height: 52px; "><label>Email : </label> <input type="email"
							name="email" size="60" style="width: 451px; height: 40px; "/></td>
					</tr>
					<tr>
						<td><label>UserName: </label> <input type="text"
							name="userName" style="width: 166px; height: 40px; "/></td>
						<td style="height: 54px; "><label>Password: </label> <input type="password"
							name="password" style="width: 166px; height: 40px; "/></td>
					</tr>
					<tr>
						<td colspan="2" style="height: 55px; "><button  type="submit" class="button" style="width: 505px; height: 39px;">Sign Up</button></td>
					</tr>
				</table>
			</form>

			<%
				String msg = (String) request.getAttribute("msg");
				String alert = (String) request.getAttribute("alert");
				if (msg == null) {
					out.println("");
				}else if(alert == "error"){
					out.println("<font color='#FF0000'><br>" + msg + "</font>");
				}else{
					out.println("<font color='#00FF00'><br>" + msg + "</font>");
				}
			%>
		</fieldset>
	</div>

</body>
</html>