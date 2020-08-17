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
	<jsp:include page="banner.jsp" />
	
	
	<form action="ServletA">
		<label>Message
			<input type="text" name="m1" />
		</label>
		
		<button name="btn" value="f">Forward</button>
		<button name="btn" value="r">Redirect</button>
	</form>
</body>
</html>