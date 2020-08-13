<%@ page import="java.time.LocalDateTime" %>

<html>
<head>
<title>A JSP Page</title>
</head>
<body>
	<%! LocalDateTime dt = LocalDateTime.now(); %>
	<h3><%=dt %></h3>
	<h1>A simple jsp page</h1>
	
	<p>
	<% for(int i=1;i<=100;i++) {%>
		<span> VAMSY<sup><%=i %></sup> </span>
	<%} %>
	</p>
</body>
</html>