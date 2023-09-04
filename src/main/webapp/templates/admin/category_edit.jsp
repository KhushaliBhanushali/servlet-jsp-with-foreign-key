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

<title>Category Edit</title>
</head>
<body>
	<div class="container my-3 col-md-6">
		<h1>Category Edit</h1>
		<a href="category">Return to Category List</a>
		<form method="post" action="edit_category" enctype="multipart/form-data">
			<input type="hidden" class="form-control" id="id" name="id"
				value="<c:out value='${category.id}' />">
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name"
					value="<c:out value='${category.name}' />"
				placeholder="Enter category name">
			</div>
			<div class="form-group">
				<label for="description">Description</label> <input type="text"
					class="form-control" id="description" name="description"
					value="<c:out value='${category.description}' />"
				placeholder="Enter category description">
			</div>
			<div class="form-group">
				<label for="image">Image</label> <input type="file"
					class="form-control" id="image" name="image">
					<!-- value="<c:out value='${category.image}' />" 
					-->
					<input type="hidden"
					class="form-control" id="old_image" name="old_image"
					value="<c:out value='${category.image}' />">
					<img src="static/images/category/${category.image}" alt="Image" style="width:200px;height:200px">
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