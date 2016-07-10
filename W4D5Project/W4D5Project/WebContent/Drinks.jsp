<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resource/js/jquery-latest.min.js"></script>
<script type="text/javascript">
var data = null;
function loadData(){
	$.ajax({
		type : "GET",
		data : {
			category : "Drinks"	
			},
		url : "MealServlet",
		success : function(response) {
			data = jQuery.parseJSON(response);

			console.log("data "+data);
			for(var i = 0; i <= data.length - 1; i++){
				var div = $("<div class='col-lg-3 col-md-4 col-xs-6 thumb'></div>");
				var a= $("<a class='thumbnail' data-index="+i+" data-toggle='modal' data-target='#foodModal'></a>");
				var img = $("<img class='img-responsive' height='256px' width='256px' src='"+data[i].image+"' alt=''>");
				var desc = $("<footer style='text-align:center; margin-bottom: 8%;'>"+data[i].name+"</footer>");
				img.appendTo(a);
				a.appendTo(div);
				desc.appendTo(div);
				div.appendTo("div.row");
			}
			
			$('.thumbnail').click(function(c){
				 var sel = $(this);
				 sel.attr("data-index");
				 var index = sel.data("index");
				
				$('#product-name').html(data[index].name)
				$('#product-picture').attr("src",data[index].image)
				$('#product-price').html("Price: " + data[index].price)
				$('#product-description').html(data[index].description)
				
			});
		}
	});
}
	$(document).ready(function() {
		loadData();
	
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
<title>Drinks</title>
<style type="text/css">
    <%@include file="resource/css/bootstrap.min.css" %>
</style>
</head>
<body>
	<div class="container">

		<div class="row">

			<div class="col-lg-12">
				<h1 class="page-header">Drinks</h1>
			</div>
		</div>
	</div>
	<!-- Modal view drink details -->
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
							<a href="#"> <img id = "product-picture" src=""
								class="img-circle" height="200px" width="200px">
							</a>
						</div>
						<div class="media-body">
							<h2 class="media-heading" id="product-name">
								</h4>
								<br>
								<h4 class="media-heading" id="product-price"></h4>
								<h4 class="media-heading">
									Quantity: &nbsp; <input type="number" name="quantity" min="0"
										max="5" style="width: 50px">
								</h4>
								<h4 class="media-heading" id="product-description"></h4>
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
	</div>
</body>
</html>