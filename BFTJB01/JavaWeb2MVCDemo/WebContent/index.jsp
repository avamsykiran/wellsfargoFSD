<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h3><%=LocalDateTime.now() %></h3>
	<h1>A simple MVC demo</h1>
	
	<nav>
		<a href="visitorInput.jsp">Visitor</a>
	</nav>
</body>
</html>