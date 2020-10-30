<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>Login Page</title>
	</head>
	<body>
		<h3><%=LocalDate.now() %></h3>
		<h1>My First Web Mvc App</h1>
		<jsp:include page="menu.jsp" />
		
		<h2>Login Form</h2>
		
		<c:if test="${err!=null }">
			<h3>${err }</h3>
		</c:if>
		
		<form action="login" method="POST">
			<div>
				<label>User Name</label>
				<input type="text" name="unm" required/>
			</div>
			<div>
				<label>Password</label>
				<input type="password" name="pwd" required/>
			</div>
			<div>
				<button>LOGIN</button>
			</div>
		</form>			
	</body>
	
</html>