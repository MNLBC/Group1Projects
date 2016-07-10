<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resource/js/jquery-latest.min.js"></script>
<script type="text/javascript">

	function loadData() {
		$.ajax({
			type : "GET",
			data : {

			},
			url : "UserServlet",
			success : function(response) {
				data = jQuery.parseJSON(response);

				$('#full-name').html(data.firstName + ", " + data.lastName)
				$('#address').html("Address: " + data.address)
				$('#contact-num').html("Contact Number: " + data.contact)
				$('#e-mail').html("Email: " + data.email)
			}
		});
	}

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
<style type="text/css">
    <%@include file="resource/css/bootstrap.min.css" %>
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header" id="full-name">Full Name</h1>
			</div>

		</div>
		<h4 id="address"></h4>
		<h4 id="contact-num"></h4>
		<h4 id="e-mail"></h4>
	</div>
</body>
</html>