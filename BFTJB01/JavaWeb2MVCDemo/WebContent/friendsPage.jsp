<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friends Page</title>
</head>
<body>
	
	<jsp:include page="header.jsp" />

	<form action="friends">
		<label>Friend Name: <input type="text" name="fnm"/></label>
		<button>ADD</button>		
	</form>

	<hr />
	
	<c:choose>
		<c:when test="${friends == null }">
			<p>No Data Found </p>
		</c:when>
		<c:when test="${friends.isEmpty() }">
			<p>All friends left</p>
		</c:when>
		<c:otherwise>
			<h3>Friends List</h3>
			<ol>
				<c:forEach items="${friends }" var="friend">
					<li>${friend }</li>				
				</c:forEach>
			</ol>
		</c:otherwise>
	</c:choose>

</body>
</html>