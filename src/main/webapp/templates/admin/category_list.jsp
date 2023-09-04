<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Employee List</title>
</head>
<body>

	<div class="container my-3">

		<h1>Category List</h1>
		<a href="new_category"><button class="btn btn-sm btn-primary my-3">Add
				New Category</button></a>
		<table class="table table-bordered table-hover table-striped">
			<thead>
			 
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>DESCRIPTION</th>
					<th>IMAGE</th>
					<th>ACTIONS</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="category" items="${listCategory}">
					<tr>
						<td><c:out value="${category.id}" /></td>
						<td><c:out value="${category.name}" /></td>
						<td><c:out value="${category.description}" /></td>
						<td><img src="static/images/category/${category.image}" alt="Image" style="width:200px;height:200px"></td>
						<td><a href="edit_category?id=<c:out value='${category.id}' />"><button
									class="btn btn-sm btn-success">Update</button></a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a onclick="return confirm('Do you want to delete this message?')"
							href="remove_category?id=<c:out value='${category.id}' />"><button
									class="btn btn-sm btn-danger">Delete</button></a></td>
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
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