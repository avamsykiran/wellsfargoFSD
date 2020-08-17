<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasks List</title>
</head>
<body>
<jsp:include page="banner.jsp" />
	<form action="todos">
		<label>Task Name: <input type="text" name="task" />
		</label>
		<button>ADD</button>
	</form>

	<hr />

	<c:choose>
		<c:when test="${tasks == null || tasks.isEmpty() }">
			<p>No Tasks Added Yet.</p>
		</c:when>
		<c:otherwise>
			<ol>
				<c:forEach items="${tasks }" var="task">
					<li>${task }</li>
				</c:forEach>
			</ol>
		</c:otherwise>
	</c:choose>
</body>
</html>