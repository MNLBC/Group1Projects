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
<link href='http://fonts.googleapis.com/css?family=Abel'
	rel='stylesheet' type='text/css'>
<body style="font-family: Abel">
	<form:form method="POST" commandName="userForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lname" /></td>
				<td><form:errors path="lname" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td colspan="3"><input type="submit" value="Previous"
					name="_target2" /> <input type="submit" value="Next"
					name="_target4" /> <input type="submit" value="Cancel"
					name="_cancel" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>