<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDate" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h3><%=LocalDate.now() %></h3>
	<h1>My MVC WEb Application</h1>
	
	<nav>
		<a href="empPage.jsp">Emp Page</a>
	</nav>
</body>
</html>