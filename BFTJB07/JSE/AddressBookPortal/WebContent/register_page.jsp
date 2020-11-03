<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>AB-Register</title>		
	</head>
	<body>
		<jsp:include page="header_fragment.jsp"/>
		
		<h3>Login Form</h3>
		
		<c:if test="${err!=null }">
			<p><strong>${err }</strong></p>
		</c:if>
		
		<form action="register" method="POST">
			<div>
				<label>User Name</label>
				<input type="text" name="unm" required />				
			</div>
			<div>
				<label>Password</label>
				<input type="password" name="pwd" required />
			</div>
			<div>
				<label>ReEnter Password</label>				
				<input type="password" name="confirmPwd" required />
			</div>
			<div>
				<button>Sign Up</button>
			</div>
		</form>
	</body>
</html>