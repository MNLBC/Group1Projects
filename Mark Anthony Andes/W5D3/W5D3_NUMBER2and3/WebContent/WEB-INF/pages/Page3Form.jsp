<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>
</head>

<body>

<form:form method="POST" commandName="userForm">
<form:errors path="*" cssClass="errorblock" element="div"/>
<center>
<table style="width: 433px; height: 182px">
<tr>
<td>Email:  </td>
<td style="width: 181px; "><form:input path="email" /></td>
<td><form:errors path="email" cssClass="error" /></td>
</tr>
<tr>
<tr>
<td colspan="3">
<input type="submit" value="Previous" name="_target1" style="width: 129px; height: 57px"/>
<input type="submit" value="Finish" name="_finish" style="width: 109px; height: 55px"/>
<input type="submit" value="Cancel" name="_cancel" style="width: 140px; height: 59px"/>
</td>
</tr>
</table>
</center>
</form:form>

</body>
</html>