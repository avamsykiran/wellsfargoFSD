<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My JSP Page</title>
</head>
<body>
	<p>
	<% for(int i=1;i<1000;i++) { %>
		<%=i %>,
	<%} %>
	</p>
</body>
</html>