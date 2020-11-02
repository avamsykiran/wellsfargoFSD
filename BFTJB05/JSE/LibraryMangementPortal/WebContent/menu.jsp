<%@page import="java.time.LocalDate"%>
<header>
	<h4><%=LocalDate.now() %></h4>
	<h2>My Library Portal</h2>
</header>
<nav>
	<hr />
	
	<a href="index.jsp">Home</a>
	<span>|</span>
	<a href="listBooks">All Books</a>
	<span>|</span>
	<a href="newBook">Add Book</a>
	
	<hr />
</nav>	