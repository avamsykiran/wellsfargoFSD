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
	<c:choose>
		<c:when test="${contacts == null || contacts.isEmpty() }">
			<p>No Contacts Found Try <a href="newContact">adding</a> one</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Contact#</th>
					<th>Full Name</th>
					<th>Date Of Birth</th>
					<th>Mobile</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${contacts }" var="contact">
					<tr>
						<td>${contact.contactId }</td>
						<td>${contact.fullName }</td>
						<td>${contact.dateOfBirth }</td>
						<td>${contact.mobile }</td>
						<td>
							<a href="deleteContact?cid=${contact.contactId }">DELETE</a>
							<span>|</span>
							<a href="editContact?cid=${contact.contactId }">EDIT</a>
							
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>