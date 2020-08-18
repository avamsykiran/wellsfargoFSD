<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<h3>${isNew?"New Item":"Edit Item" }</h3>
	
	<form action='${isNew?"addContact":"saveContact"}' method="POST">
	
		<div>
			<label>Contact Id</label>
			<input type="number" name="contactId" value="${contact.contactId }" ${isNew?"":"readonly" } required/>
		</div>
		<div>
			<label>Full Name</label>
			<input type="text" name="fullName" value="${contact.fullName }" required/>
		</div>
		<div>
			<label>Mobile</label>
			<input type="text" name="mobile" value="${contact.mobile }" pattern="[1-9][0-9]{9}" required/>
		</div>
		<div>
			<label>Date Of Birth</label>
			<input type="date" name="dateOfBirth" value="${contact.dateOfBirth }" required/>
		</div>
		<button>SAVE</button>
	</form>
</body>
</html>