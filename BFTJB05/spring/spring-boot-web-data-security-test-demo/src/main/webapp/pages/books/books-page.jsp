<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>LMP-Genres</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	</head>
	<body>
		<jsp:include page="/header"/>
		<section class="container-fluid p-4">
			
			<h3>Books</h3>
						
			<c:choose>
				<c:when test="${books==null || books.isEmpty() }">
					<div class="alert alert-info">
						<p>No Book Records Available!
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Book Code</th>
								<th>Title</th>
								<th>Genre</th>
								<th>Price</th>
								<th>Publish Date
								<th colspan="2"></th>
							</tr>							
						</thead>
						<tbody>
							<c:forEach var="b" items="${books }">
								<tr>
									<td>${b.bookCode }</td>
									<td>${b.title }</td>
									<td>${b.genere.genreName }</td>
									<td>${b.price }</td>
									<td>${b.publishDate }</td>
									<td>
										<a href="/books/edit?bid=${b.bookCode }" class="btn btn-sm btn-info">
											EDIT
										</a>
									</td>
									<td>
										<a href="/books/delete?bid=${b.bookCode }" class="btn btn-sm btn-danger">
											DELETE
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</section>
	</body>
</html>