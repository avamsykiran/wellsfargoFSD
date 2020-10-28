<%@page import="java.time.LocalDateTime"%>
<html>
	<head>
		<title>A jsp page</title>
	</head>
	<body>
		<h1>A JSP Page</h1>
		
		<jsp:include page="menu.jsp"/>
		
		<%! LocalDateTime today = LocalDateTime.now(); %>
		
		<h2><%=today %></h2>
		
		<p>
			<% for(int i=1;i<=100;i++){ %>
				<span><%=i%>.RAMA </span>
			<% } %>
		</p> 
	</body>
</html>