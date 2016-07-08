<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resource/js/jquery-latest.min.js"></script>
<script type="text/javascript">
	$("document").ready(function() {
		$("#drinks").click(function() {
			$('#container').load('drinks.jsp');
		});
		
		$("#burgers").click(function() {
			$('#container').load('burger.jsp');
		});
		
		$("#comboMeals").click(function() {
			$('#container').load('comboMeal.jsp');
		});
		
		$("#chicken").click(function() {
			$('#container').load('chicken.jsp');
		});

		$("#desserts").click(function() {
			$('#container').load('desserts.jsp');
		});
		
		$("#sides").click(function() {
			$('#container').load('sides.jsp');
		});

	});
</script>
<title>My Profile</title>

</head>
<body>

</body>
</html>