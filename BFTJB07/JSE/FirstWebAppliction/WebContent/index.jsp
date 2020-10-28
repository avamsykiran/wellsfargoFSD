<%@page import="java.time.LocalDateTime"%>

<html>
	<head>
		<title>A jsp page</title>
	</head>
	<body>
		<%! LocalDateTime today = LocalDateTime.now(); %>
		<h3><%=today %></h3>
		<h1>My first jsp page!</h1>
		
		<jsp:include page="menu.jsp" />
		
		<p>
			<% for(int i=1;i<=100;i++){ %>
				<span> <%=i %> RAMA </span>
			<% } %>
		</p>
	</body>
</html>