<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.wellsfargo.fsd.jw2.model.EmployeeModel" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp Page</title>
</head>
<body>

	<form action="es">
		<label>Full Name <input type="text" name="fullName" required/></label> <br />
		<label>Basic <input type="number" name="basic" required/></label><br />
		<label>Hire Date <input type="date" name="hiredate" required/></label><br />
		<button>SEND</button>
	</form>
	
	<% EmployeeModel emp =  (EmployeeModel)request.getAttribute("model");%>
	
	<% if(emp!=null) {%>
		<table>
			<tr><td>Full Name</td><td><strong><%=emp.getFullName() %></strong></td></tr>
			<tr><td>Basic</td><td><strong><%=emp.getBasic() %></strong></td></tr>
			<tr><td>Hire Date</td><td><strong><%=emp.getHiredate() %></strong></td></tr>
			<tr><td>TA</td><td><strong><%=emp.getTa() %></strong></td></tr>
			<tr><td>HRA</td><td><strong><%=emp.getHra() %></strong></td></tr>
		</table>
	<%} %>
</body>
</html>