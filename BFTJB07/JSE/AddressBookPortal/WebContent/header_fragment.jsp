<%@page import="java.time.LocalDate"%>
<header>
	<h3><%=LocalDate.now() %></h3>
	<h2>My Address Book Portal</h2>
	<hr />
	
	<nav>
		<a href="index.jsp">Home</a>
		<span>|</span>
		<a href="listContacts">All Contacts</a>
		<span>|</span>
		<a href="newContact">New Contact</a>
	</nav>
	
	<hr />
</header>