<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.oocl.mnlbc.models.User"%>
<%@ page import="com.oocl.mnlbc.dao.TransactionDAO"%>
<%@ page import="com.oocl.mnlbc.dao.TransactionDAOImpl"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Maintenance Users</title>
<style type="text/css">
    <%@include file="../resource/css/bootstrap.min.css" %>
</style>
</head>
<body>
<%
	TransactionDAO dao = new TransactionDAOImpl();
	List<User> userList = dao.getUsers();
%>
<div class="container">

	<table class="table">
		<tr>
			<td>ID</td>
			<td>FIRSTNAME</td>
			<td>MIDDLENAME</td>
			<td>LASTNAME</td>
			<td>ADDRESS</td>
			<td>CONTACTS</td>
			<td>EMAIL</td>	
			<td>GENDER</td>
			<td>USERNAME</td>
			<td>TYPE</td>
			<td>IMAGE</td>
			<td>IS_DISABLED</td>
		</tr>
		<%
			for (User user : userList) {
		%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getMiddleName()%></td>
			<td><%=user.getLastName()%></td>
			<td><%=user.getAddress()%></td>
			<td><%=user.getContact()%></td>
			<td><%=user.getEmail()%></td>	
			<td><%=user.getGender()%></td>
			<td><%=user.getUserName()%></td>
			<td><%=user.getType()%></td>
			<td><%=user.getImage()%></td>
			<td><%=user.isDisable()%></td>

			<td><a href="UserHandler?action=editform&userId=<%=user.getId()%>">Update</a>
				<a href="UserHandler?action=delete&userId=<%=user.getId()%>">Delete</a>
			 </td>
		</tr>
		
		<%
			}
		%>
		
	</table>

</div>

</body>
</html>