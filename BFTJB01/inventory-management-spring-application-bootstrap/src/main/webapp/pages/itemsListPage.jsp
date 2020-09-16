<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items List</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="/header" />
	<section class="container-fluid p-4">
	<h3>Items</h3>
	
	<c:choose>
		<c:when test="${items==null || items.isEmpty() }">
			<p class="alert alert-info p-2 m-2 ">No Items Found</p>
		</c:when>
		<c:otherwise>
			<table class="table table-stripped table-bordered table-hover">
				<tr>
					<th>Icode</th>
					<th>Title</th>
					<th>Is Fragile</th>
					<th>Package Date</th>
					<th>Unit</th>
					<th>Cost Price</th>
					<th>Selling Price</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${items }" var="item">
					<tr>
					<td>${item.icode }</td>
					<td>${item.title }</td>
					<td>${item.fragile }</td>
					<td>${item.packageDate }</td>
					<td>${item.unit }</td>
					<td>${item.costPrice }</td>
					<td>${item.sellingPrice }</td>
					<td>
						<a class="btn btn-sm btn-danger" href="deleteItem?icode=${item.icode }">DELETE</a> 
						<a class="btn btn-sm btn-primary" href="editItem?icode=${item.icode }">EDIT</a> 
					</td>
				</tr>				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	</section>
</body>
</html>