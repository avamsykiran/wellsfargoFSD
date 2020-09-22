<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Form</title>
</head>
<body>

	<jsp:include page="${pageContext.request.contextPath }/header" />
	
	<h3>Sign Up</h3>
	
	<form:form action='${pageContext.request.contextPath}/register' method="POST" modelAttribute="user">
		<div>
			<form:label path="userName">User Name: </form:label>
			<form:input type="text" path="userName" />
			<form:errors path="userName"/>
		</div>
		<div>
			<form:label path="password">Password: </form:label>
			<form:input type="password" path="password" />
			<form:errors path="password"/>
		</div>
		
		<button>SIGN UP</button>		
	</form:form>
</body>
</html>