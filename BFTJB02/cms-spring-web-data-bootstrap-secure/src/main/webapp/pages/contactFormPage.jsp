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
	<h3>${isNew?"New Item":"Edit Item" }</h3>

	<div class="col-sm-4">	
	<form:form  class="form" action='${isNew?pageContext.request.contextPath.concat("/admin/addContact"):pageContext.request.contextPath.concat("/admin/saveContact")}' method="POST" modelAttribute="contact">
		<div class="form-group">
			<form:label path="contactId">Contact Id</form:label>
			<form:input type="number" path="contactId" readonly="${!isNew }" class="form-control"/>
			<form:errors path="contactId" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<form:label path="fullName">Full Name</form:label>
			<form:input type="text" path="fullName" class="form-control"/>
			<form:errors path="fullName" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<form:label path="mobile">Mobile</form:label>
			<form:input type="text" path="mobile" class="form-control"/>
			<form:errors path="mobile" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<form:label path="dateOfBirth">Date Of Birth</form:label>
			<form:input type="date" path="dateOfBirth" class="form-control"/>
			<form:errors path="dateOfBirth" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<form:label path="married">I am Married</form:label>
			<form:checkbox path="married"/>
			<form:errors path="married" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<form:label path="group">Group</form:label>
			<form:select path="group" items="${allGroups }" class="form-control"/>
			<form:errors path="group" class="alert alert-danger"/>
		</div>
		<div class="form-group text-right">
		<button class="btn btn-primary">SAVE</button>
		</div>
	</form:form>
	</div>
	</section>
</body>
</html>