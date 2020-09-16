<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Form</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

	<jsp:include page="/header" />
	
	<section class="container-fluid p-4">
	<h3>${isNew?"New Item":"Edit Item" }</h3>
	<div class="col-4">	
	<form:form class="form" action='${isNew?"addItem":"saveItem" }' method="POST" modelAttribute="item">
		<div class="form-group">
			<form:label path="icode" class="form-lable">Icode: </form:label>
			<form:input type="number" path="icode" readonly="${!isNew}" class="form-control"/>
			<form:errors path="icode" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<form:label path="title">Title: </form:label>
			<form:input type="text" path="title" class="form-control"/>
			<form:errors path="title" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<form:label path="unit">Unit: </form:label>
			<form:select path="unit" items="${units }" class="form-control"/> 
			<%-- <form:radiobuttons path="unit" items="${units }"/> --%>
			<form:errors path="unit" class="alert alert-danger"/>
		</div class="form-group">
		<div class="form-group">
			<form:label path="packageDate">Package Date: </form:label>
			<form:input type="date" path="packageDate" class="form-control"/>
			<form:errors path="packageDate" class="alert alert-danger"/>			
		</div>
		<div class="form-group">
			<form:label path="costPrice">Cost Price: </form:label>
			<form:input type="decimal" path="costPrice" class="form-control"/>
			<form:errors path="costPrice" class="alert alert-danger"/>			
		</div>
		<div class="form-group">
			<form:label path="sellingPrice">Selling Price: </form:label>
			<form:input type="decimal" path="sellingPrice" class="form-control"/>
			<form:errors path="sellingPrice" class="alert alert-danger"/>		
		</div>
		<div class="form-group">
			<form:label path="fragile">Fragile</form:label>
			<form:checkbox path="fragile" />
			<form:errors path="fragile"/>
		</div>
		<div class="text-right">
			<button class="btn btn-primary">SAVE</button>
		</div>		
	</form:form>
	</div>
	</section>
</body>
</html>