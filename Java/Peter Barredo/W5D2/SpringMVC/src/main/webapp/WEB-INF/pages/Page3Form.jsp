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
	<h2>Page3Form.jsp</h2>

	<form:form method="POST" commandName="userForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Address :</td>
				<td><form:textarea path="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td colspan="3"><input class="button" type="submit" value="Previous"
					name="_target1" /> <input class="button" type="submit" value="Finish"
					name="_finish" /> <input class="button" type="submit" value="Cancel"
					name="_cancel" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>