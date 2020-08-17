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
	<jsp:include page="header.jsp" />
	
	<form action="ServletA">
		<label>Message
			<input type="text" name="m1" />
		</label>
		<button name="action" value="f">FORWARD</button>
		<button name="action" value="r">REDIRECT</button>
	</form>
</body>
</html>