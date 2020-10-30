<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>Friends Page</title>
	</head>
	<body>
		<h3><%=LocalDate.now() %></h3>
		<h1><%=application.getInitParameter("webAppTitle") %></h1>
		<jsp:include page="menu.jsp"/>
		
		<h2>Friends Form</h2>
		<form action="friends" method="POST" >
			<div>
				<label>Friend Name: </label>
				<input type="text" name="fnm" required />
			</div>			
			<div>
				<button>SEND</button>
			</div>
		</form>
		
		<%-- <% List<String> friends = (List<String>)application.getAttribute("friends"); %>
		<% if(friends!=null && !friends.isEmpty()){ %>
		<h2>Friends </h2>
		<ol>
			<% for(String fnm : friends){ %>
				<li><%=fnm %></li>
			<% } %>
		</ol>
		<% } %> --%>
		
		<c:if test="${friends1=null && !friends.isEmpty() }">
			<h2>Friends</h2>
			<ol>
				<c:forEach items="${friends }" var="fnm">
					<li>${fnm }</li>
				</c:forEach>
			</ol>
		</c:if>
	</body>
</html>