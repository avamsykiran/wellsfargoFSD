<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Contact</title>
<link rel="stylesheet" href="/css/site.css" />
</head>
<body>
	<jsp:include page="/commons/header" />
	<section>
		<h3>Contact</h3>
		
		<c:if test="${contact != null }">
			<table>
				<tr><td>Contact#</td><td>${contact.contactId }</td></tr>
				<tr><td>Name</td><td>${contact.name }</td></tr>
				<tr><td>Mobile</td><td>${contact.mobile }</td></tr>
				<tr><td>Date Of Birth</td><td>${contact.dateOfBirth }</td></tr>
			</table>
		</c:if>
		
	</section>
</body>
</html>