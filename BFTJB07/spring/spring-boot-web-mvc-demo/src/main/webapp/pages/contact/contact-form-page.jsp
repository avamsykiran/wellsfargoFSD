<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Contact Form</title>
<link rel="stylesheet" href="/css/site.css" />
</head>
<body>
	<jsp:include page="/commons/header" />
	<section>
		<h3>Contact Us</h3>
		
		<form:form method="POST">
			<form:label path="contactId">Contact Id:</form:label>
			<form:input type="number" path="contactId" required />			
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name" required />			
			<form:label path="dateOfBirth">Date Of Birth:</form:label>
			<form:input type="date" path="dateOfBirth" required />			
			<form:label path="mobile">Mobile:</form:label>
			<form:input type="text" pattern="[1-9][0-9]{9}" path="mobile" required />			
			<button>SEND</button>
		</form:form>
		
		<%-- <form method="POST">
			<label>Contact Id:
				<input type="number" name="contactId" required />
			</label>
			<label>Name:
				<input type="text" name="name" required />
			</label>
			<label>Date Of Birth:
				<input type="date" name="dateOfBirth" required />
			</label>
			<label>Mobile:
				<input type="text" pattern="[1-9][0-9]{9}" name="mobile" required />
			</label>
			<button>SEND</button>
		</form> --%>
		
	</section>
</body>
</html>