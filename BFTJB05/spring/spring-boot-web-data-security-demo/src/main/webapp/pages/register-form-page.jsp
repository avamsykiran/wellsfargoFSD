<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<title>LMP-Registration</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	</head>
	<body>
		<jsp:include page="/header"/>
		<section class="container-fluid p-4">
			
			<h3>Registration</h3>
			
			<div class="col-sm-5">
			<form:form action="/register" 
				method="POST" modelAttribute="user" class="form">
				<div class="form-control-group">
					<form:errors path="*"/>				
				</div>
				<div class="form-control-group">
					<form:label path="userName" class="form-control-label">User Name:</form:label>
					<form:input path="userName" class="form-control"/>
				</div> 
				<div class="form-control-group">
					<form:label path="password" class="form-control-label">Password:</form:label>
					<form:input path="password" class="form-control" type="password"/>
				</div> 
				<div class="form-control-group">
					<form:label path="confirmPassword" class="form-control-label">Confirm Password:</form:label>
					<form:input path="confirmPassword" class="form-control" type="password"/>
				</div> 
				<div class="form-control-group">
					<form:label path="firstName" class="form-control-label">First Name:</form:label>
					<form:input path="firstName" class="form-control"/>
				</div> 
				<div class="form-control-group">
					<form:label path="lastName" class="form-control-label">Last Name:</form:label>
					<form:input path="lastName" class="form-control"/>
				</div> 
				<div class="form-control-group">
					<form:label path="mobileNumber" class="form-control-label">Mobile Number:</form:label>
					<form:input path="mobileNumber" class="form-control"/>
				</div> 
				<div class="form-control-group">
					<form:label path="addressLine1" class="form-control-label">Address Line1:</form:label>
					<form:input path="addressLine1" class="form-control"/>
				</div> 
				<div class="form-control-group">
					<form:label path="addressLine2" class="form-control-label">Address Line2:</form:label>
					<form:input path="addressLine2" class="form-control"/>
				</div> 
				<div class="form-control-group">
					<form:label path="city" class="form-control-label">City:</form:label>
					<form:input path="city" class="form-control"/>
				</div> 
				
				<div class="form-control-group">
					<button class="btn btn-primary">SIGN UP</button>
				</div>
			</form:form>
			</div>
			
		</section>
	</body>
</html>