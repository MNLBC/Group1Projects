<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resource/js/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
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
<title>Burgers</title>
<style type="text/css">
    <%@include file="resource/css/bootstrap.min.css" %>
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Burgers</h1>
			</div>

			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#foodModal" data-toggle="modal"
					data-target="#foodModal"> <img class="img-responsive"
					height="256px" width="256px" src="resource/img/baconandcheese.png">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="#"> <img class="img-responsive"
					height="256px" width="256px" src="http://placehold.it/400x300"
					alt="">
				</a>
			</div>
		</div>

		<!-- Modal view burger details -->
		<div class="modal fade" id="foodModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">View Product</h4>
					</div>
					<div class="modal-body">
						<div class="media">
							<div class="media-left">
								<a href="#"> <img src="resource/img/baconandcheese.png"
									data-toggle="modal" data-target="#foodModal"
									class="img-circle" height="200px" width="200px">
								</a>
							</div>
							<div class="media-body">
								<h2 class="media-heading">
									Product Name
									</h4>
									<br>
									<h4 class="media-heading">Price:</h4>
									<h4 class="media-heading">
										Quantity: &nbsp; <input type="number" name="quantity" min="0"
											max="5" style="width: 50px">
									</h4>
									<h4 class="media-heading">Description:</h4>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-primary" value="Add to tray">
					</div>
				</div>
			</div>
		</div></body>
</html>