<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Page 1</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

</style>
</head>

<body bgcolor="lightgreen">
	<div align="center">
		<h2>Registration</h2>
		<fieldset>
			<form:form method="POST" commandName="userForm">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table border="2">
					<tr>
						<td>Fullname : <input type="text" name="name" /></td>
						<td>Address: <input type="text" name="address"></td>
						<td>Email: <input type="email" name="email"></td>
					</tr>
					<tr>
						<td colspan="3"><input type="submit" value="Next"
							name="_target1" /> <input type="submit" value="Cancel"
							name="_cancel" /></td>
					</tr>
				</table>
			</form:form>
		</fieldset>
	</div>
</body>
</html>