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
<br><br><br>
<form:form method="POST" commandName="userForm">
<form:errors path="*" cssClass="errorblock" element="div"/>
<center>
<table style="width: 422px; ">
<tr>
<td style="width: 84px; ">Username : </td>
<td style="width: 178px; "><form:input  path="userName" /></td>
<td><form:errors path="userName" cssClass="error" /></td>
</tr>
<tr>

<tr>
<td colspan="3">
<input type="submit" value="Next" name="_target1" style="width: 206px; height: 45px"/>
<input type="submit" value="Cancel" name="_cancel" style="width: 175px; height: 43px"/>
</td>
</tr>

</table>
</center>
</form:form>

</body>
</html>