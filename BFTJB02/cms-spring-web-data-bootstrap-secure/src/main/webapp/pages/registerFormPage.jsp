<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="${pageContext.request.contextPath}/header" />
	
	<section class="container-fluid p-4">
	<h3>Sign Up</h3>

	<div class="col-sm-4">	
	<form:form  class="form" action='${pageContext.request.contextPath}/register' method="POST" modelAttribute="user">
		<div class="form-group">
			<form:label path="userName">User Name</form:label>
			<form:input type="text" path="userName" class="form-control"/>
			<form:errors path="userName" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:input type="password" path="password" class="form-control"/>
			<form:errors path="password" class="alert alert-danger"/>
		</div>		
		<div class="form-group text-right">
			<button class="btn btn-primary">Sign Up</button>
		</div>
	</form:form>
	</div>
	</section>
</body>
</html>