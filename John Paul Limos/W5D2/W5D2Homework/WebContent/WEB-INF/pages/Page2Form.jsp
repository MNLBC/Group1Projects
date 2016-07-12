<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
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

<body>
<center>
	<h2>Password for your account</h2>

	<form:form method="POST" commandName="userForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" />
				</td>
				<td><form:errors path="password" cssClass="error" />
				</td>
			</tr>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="Go back"
					name="_target0" /> <input type="submit" value="Proceed"
					name="_target2" /> <input type="submit" value="Cancel"
					name="_cancel" /></td>
			</tr>
		</table>
	</form:form>
</center>


</body>
</html>