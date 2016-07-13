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
<table style="width: 486px; height: 162px">
<tr>
<td style="height: 76px; ">Password : </td>
<td style="width: 193px; "><form:password path="password" /></td>
<td><form:errors path="password" cssClass="error" /></td>
</tr>
<tr>
<tr>
<td colspan="3">
<input type="submit" value="Previous" name="_target0" style="width: 159px; height: 54px"/>
<input type="submit" value="Next" name="_target2" style="width: 144px; height: 52px"/>
<input type="submit" value="Cancel" name="_cancel" style="width: 134px; height: 52px"/>
</td>
</tr>
</table>
</center>
</form:form>

</body>
</html>