
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<html>
	<head>
		<title>IMS - Home</title>
	</head>
	<body>
		<jsp:include page="${pageContext.request.contextPath }/header" />
		
		<c:if test="${msg != null}">
			<p><strong>${msg }</strong>
		</c:if>
	</body>
</html>