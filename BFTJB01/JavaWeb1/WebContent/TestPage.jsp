<%@ page import="java.time.LocalDateTime" %>

<html>
	<head>
		<title>A simple jsp page</title>
	</head>
	<body>
		<h1>A JSP Page</h1>
		
		<%! LocalDateTime dt = LocalDateTime.now(); %>
		
		<%=dt %>
		<p>
		<% for(int i=1;i<1000;i++){ %>
			<span><%=i %>,</span>
		<%} %>
		</p>
	</body>
</html>