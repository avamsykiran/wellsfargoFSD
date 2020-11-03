<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>AB-Login</title>
	</head>
	<body>
		<jsp:include page="header_fragment.jsp"/>
		
		<h3>Login Form</h3>
		
		<c:if test="${err!=null }">
			<p><strong>${err }</strong></p>
		</c:if>
		
		<form action="login" method="POST">
			<div>
				<label>User Name</label>
				<input type="text" name="unm" required />				
			</div>
			<div>
				<label>Password</label>
				<input type="password" name="pwd" required />
			</div>
			<div>
				<button>Sign In</button>
			</div>
		</form>
	</body>
</html>