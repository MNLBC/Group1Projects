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
		<fieldset style="width: 711px;">
			<h1>
				<label>Register </label>
			</h1>
			<form action="register.do" method="post" style="width: 575px; ">
				<table style="width: 480px; height: 480px; ">
					<tr>
						<td> <input type="text" name="firstName"
							style="width: 190px; height: 40px;" placeholder="FirstName" /></td>
						<td style="height: 53px; width: 239px"><input type="text" name="lastName"
							style="width: 164px; height: 40px;"  placeholder="LastName" /></td>
					</tr>
					<tr>
						<td colspan="2" style="height: 52px;"><input type="text"
							name="userName" size="60" style="width: 400px; height: 40px;"  placeholder="Username" /></td>
					</tr>
					<tr>
						<td colspan="2" style="height: 52px;"><input type="password"
							name="password" size="60" style="width: 400px; height: 40px;"  placeholder="Password" /></td>
					</tr>
					<tr>
						<td colspan="2" style="height: 52px;"><input type="password"
							name="confPassword" size="60" style="width: 400px; height: 40px;"   placeholder="Confirm Password"/></td>
					</tr>
					<tr>
						<td colspan="2" style="height: 52px;"><input type="email" name="email" size="60"
							style="width: 400px; height: 40px;" placeholder="Email" /></td>
					</tr>
					<tr>
						<td colspan="2" style="height: 55px;"><button type="submit"
								class="button" style="width: 400px; height: 39px;">Sign Up</button></td>
					</tr>
					<tr><td colspan="2" align="center" style="height: 21px; "><h3><font color="red">${errorMsg}</font></h3></td></tr>
				</table>
			</form>

		</fieldset>
	</div>

</body>
</html>