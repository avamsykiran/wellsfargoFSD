<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<title>LMP-Book</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	</head>
	<body>
		<jsp:include page="/header"/>
		<section class="container-fluid p-4">
			
			<h3>${isNew?"New":"Edit" } Book</h3>
			
			<div class="col-sm-5">
			<form:form action="/books/${isNew?'add':'update' }" 
				method="POST" modelAttribute="book" class="form">
				<div class="form-control-group">
					<form:errors path="*"/>				
				</div>
				<div class="form-control-group">
					<form:label path="bookCode" class="form-control-label">Book Code</form:label>
					<form:input path="bookCode" class="form-control" type="number"/>
				</div>
				<div class="form-control-group">
					<form:label path="title" class="form-control-label">Title</form:label>
					<form:input path="title" class="form-control" type="text"/>
				</div>
				<div class="form-control-group">
					<form:label path="price" class="form-control-label">Price</form:label>
					<form:input path="price" class="form-control" type="decimal"/>
				</div>
				<div class="form-control-group">
					<form:label path="publishDate" class="form-control-label">Publish Date</form:label>
					<form:input path="publishDate" class="form-control" type="date"/>
				</div> 
				<div class="form-control-group">
					<form:label path="genere.genreId" class="form-control-label">Genre: </form:label>
					<form:select path="genere.genreId" class="form-control">						
						<form:options items="${genres }" itemLabel="genreName" itemValue="genreId"/>
					</form:select>
				</div> 
				<div class="form-control-group">
					<button class="btn btn-primary">SAVE</button>
				</div>
			</form:form>
			</div>
			
		</section>
	</body>
</html>