<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team Page</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<form action="team">
		<label>Member: 
			<input type="text" name="member" />
		</label>
		<button>ADD</button>
	</form>
	<hr />
	<c:choose>
		<c:when test="${teamMembers==null }">
			<p>No Data</p>
		</c:when>
		<c:when test="${teamMembers.isEmpty() }">
			<p>All members left</p>
		</c:when>
		<c:otherwise>
			<h3>Team</h3>
			<ol>
				<c:forEach items="${teamMembers }" var="tm">
					<li>${tm }</li>
				</c:forEach> 
			</ol>
		</c:otherwise>
	</c:choose>	
</body>
</html>