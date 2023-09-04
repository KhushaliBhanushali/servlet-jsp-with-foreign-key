<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Product Edit</title>
</head>
<body>
	<div class="container my-3 col-md-6">
		<h1>Product Edit</h1>
		<a href="product">Return to Product List</a>
		<form method="post" action="edit_product" enctype="multipart/form-data">
		
			<input type="hidden" class="form-control" id="product_id"
				name="product_id" value="<c:out value='${product.product_id}' />">
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name"
					value="<c:out value='${product.name}' />"
					placeholder="Enter Product name">
			</div>
			<div class="form-group">
				<label for="price">Price</label> <input type="text"
					class="form-control" id="price" name="price"
					value="<c:out value='${product.price}' />"
					placeholder="Enter Product price">
			</div>
			<div class="form-group">
				<label for="entry_date">Entry Date</label> <input type="hidden"
					class="form-control" id="entry_date" name="entry_date">
				
			</div>
			<div class="form-group">
				<label for="status">Status</label> <select name="status"
					class="form-control col-md-3">
					<option value="1">Active</option>
					<option value="0">Not Active</option>
				</select>
			</div>
			<div class="form-group">
				<label for="category">Category</label>   <select
					name="category_id" id="category_id" class="form-control">
					<c:forEach items="${listCategory}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="image">Image</label> <input type="file"
					class="form-control" id="image" name="image">
					
					<input type="hidden"
					class="form-control" id="old_image" name="old_image"
					value="<c:out value='${product.image}' />">
					<img src="static/images/product/${product.image}" alt="Image" style="width:200px;height:200px">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>