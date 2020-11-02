<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>AB-Home</title>
	</head>
	<body>
		<jsp:include page="header_fragment.jsp"/>
		
		<h3>Home</h3>
		<p>Welcome Home!</p>
		
		<c:if test="${msg!=null }">
			<p><strong>${msg }</strong></p>
		</c:if>
	</body>
</html>