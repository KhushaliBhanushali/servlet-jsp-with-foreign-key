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

<title>Product Entry</title>
</head>
<body>
	<div class="container my-3 col-md-6">
		<h1>Product Entry</h1>
		<a href="product">Return to Product List</a>
		<form method="post" action="add_product" enctype="multipart/form-data">

			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name"
					placeholder="Enter Product name">
			</div>
			<div class="form-group">
				<label for="price">Price</label> <input type="text"
					class="form-control" id="price" name="price"
					placeholder="Enter Product price">
			</div>
			<div class="form-group">
				<label for="entry_date">Entry Date</label> <input type="hidden"
					class="form-control" id="entry_date" name="entry_date">
			</div>
			<div class="form-group">
				<label for="status">Status</label> <select name="status"
					class="form-control col-md-3" id="status">
					
						<option value="1">Active</option>
						<option value="0">Not Active</option>
					
					
				</select>
			</div>
			<div class="form-group">
				<label for="category">Category</label>
				 <select
					name="category_id" id="category_id" class="form-control">
					<c:forEach items="${listCategory}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="image">Image</label> <input type="file"
					class="form-control" id="image" name="image">
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