<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<base href="/" />
</head>
<body>
	<h2>Log In</h2>
	<jsp:include page="${pageContext.request.contextPath}/header" />
	<nav>

		<form action="${pageContext.request.contextPath}/login" method="POST">
			<c:if test="${param.error ne null}">
				Invalid Credentials! Access Denied!
			</c:if>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<label>UserName: <input type="text" name="unm"/></label>
			<label>Password: <input type="password" name="pwd"/></label>
			<button>Sign In</button>
		</form>
	</nav>
</body>
</html>
