<%@ page import="java.time.LocalDateTime" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My JSP Page</title>
</head>
<body>
	<%! LocalDateTime dt = LocalDateTime.now(); %>
	
	<h2><%=dt %></h2>
	
	<p>
	<% for(int i=1;i<1000;i++) { %>
		<%=i %>,
	<%} %>
	</p>
</body>
</html>