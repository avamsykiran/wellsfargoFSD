<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
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
	<c:choose>
		<c:when test="${contacts == null || contacts.isEmpty() }">
			<p class="well well-info">No Contacts Found Try <a href="newContact">adding</a> one</p>
		</c:when>
		<c:otherwise>
			<table class="table table-striped table-hover table-border">
				<tr>
					<th>Contact#</th>
					<th>Full Name</th>
					<th>Date Of Birth</th>
					<th>Mobile</th>
					<th>Group</th>
					<th>Married?</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${contacts }" var="contact">
					<tr>
						<td>${contact.contactId }</td>
						<td>${contact.fullName }</td>
						<td>${contact.dateOfBirth }</td>
						<td>${contact.mobile }</td>
						<td>${contact.group }</td>
						<td>${contact.married }</td>
						<td>
							<a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/admin/deleteContact?cid=${contact.contactId }">DELETE</a>
							<a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/admin/editContact?cid=${contact.contactId }">EDIT</a>
							
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	</section>
</body>
</html>