<%@page import="java.time.LocalDate"%>
<html>
	<head>
		<title>Mvc-Home</title>
	</head>
	<body>
		<h3><%=LocalDate.now() %></h3>
		<h1>First MVC App</h1>
		<jsp:include page="menu.jsp"/>
		
		<h2>Welcome</h2>
		<p>
		 Hai All! Welcome to mvc application home
		 </p>
	</body>
</html>