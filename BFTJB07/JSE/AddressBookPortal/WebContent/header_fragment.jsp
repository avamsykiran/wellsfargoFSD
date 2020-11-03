<%@page import="java.time.LocalDate"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<header>
	<h3><%=LocalDate.now()%></h3>
	<h2>My Address Book Portal</h2>
	<hr />

	<nav>
		<a href="index.jsp">Home</a> 
		<span>|</span>

		<c:choose>
			<c:when test="${user==null }">
				<a href="login">LogIn</a>
				<span>|</span>
				<a href="register">Register</a>
			</c:when>
			<c:when test="${user.role=='ADMIN' }">
				<a href="listContacts">All Contacts</a>
				<span>|</span> 
				<a href="newContact">New Contact</a>
				<span>|</span> 
				<a href="logout">LogOut</a>
			</c:when>
			<c:when test="${user.role=='USER' }">
				<a href="listContacts">All Contacts</a>
				<span>|</span> 
				<a href="logout">LogOut</a>	
			</c:when>
		</c:choose>
	</nav>

	<hr />
</header>