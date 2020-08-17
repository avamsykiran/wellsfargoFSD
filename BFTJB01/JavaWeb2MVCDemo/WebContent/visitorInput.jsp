<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visitor Input</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<%-- <% String msg =(String) request.getAttribute("msg"); %>
	<% if(msg!=null) {%>
		<h2><%=msg %></h2>
	<%} %>
 --%>
 
 	<c:choose>
 		<c:when test="${msg != null }">
 			<h2>${msg }</h2>
 		</c:when>
 		<c:otherwise>
 			<h2>Welcome! Somebody!</h2>
 		</c:otherwise>
 	</c:choose>
 	
 	
	<form action="visitor">
		<label>Title
			<select name="title" required>
				<option value="NA">None</option>
				<option value="Dr">Dr</option>
				<option value="Hon Min.,">Minister</option>
				<option value="Prof.,">Professor</option>
			</select>
		</label> <br />
		<label>Full Name
			<input type="text" name="fnm" required />
		</label> <br />
		<label>Gender</label>
		<label>
			<input type="radio" name="gender" value="G" />Gent
		</label>
		<label>
			<input type="radio" name="gender" value="L" />Lady
		</label>
		<button>OK</button>
	</form>
</body>
</html>