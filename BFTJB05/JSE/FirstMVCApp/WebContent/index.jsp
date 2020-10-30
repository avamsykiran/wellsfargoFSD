<%@page import="java.time.LocalDate"%>
<html>
	<head>
		<title>Home Page</title>
	</head>
	<body>
		<h3><%=LocalDate.now() %></h3>
		<h1>My First Web Mvc App</h1>
		<jsp:include page="menu.jsp" />
		
		<h2>Welcome</h2>
		<p>Hai all welcome home!</p>
				
		<h2><%=application.getInitParameter("dbUrl")%></h2> 
	</body>
</html>