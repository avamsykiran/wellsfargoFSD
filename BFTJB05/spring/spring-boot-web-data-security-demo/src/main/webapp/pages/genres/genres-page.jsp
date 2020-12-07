<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
			
			<h3>Genres</h3>
			
			<div class="mb-4">
				<form:form class="form-inline" 
					action="/genres/add" method="POST" modelAttribute="genre">
					
					<div class="alert alert-danger">
							<form:errors path="*"></form:errors>
					</div>
					
					<form:input type="number" path="genreId" 
						class="form-control mr-4" placeholder="Genre Id"/>
					<form:input type="text" path="genreName" 
						class="form-control mr-4" placeholder="Genre Name"/>
					<button class="btn btn-sm btn-primary">ADD</button>					
				</form:form>
			</div>
			
			<c:choose>
				<c:when test="${genres==null || genres.isEmpty() }">
					<div class="alert alert-info">
						<p>No Genres Found!
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Genre#</th>
								<th>Genre</th>
								<th colspan="2"></th>
							</tr>							
						</thead>
						<tbody>
							<c:forEach var="g" items="${genres }">
								<tr>
									<td>${g.genreId }</td>
									<td>${g.genreName }</td>
									<td>
										<a href="/genres/delete?gid=${g.genreId }" class="btn btn-sm btn-danger">
											DELETE
										</a>
									</td>
									<td>
										<a href="/books/byGenre?gid=${g.genreId }" class="btn btn-sm btn-info">
											BOOKS
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