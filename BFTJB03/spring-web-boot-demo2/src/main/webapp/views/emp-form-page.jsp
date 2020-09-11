<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<title>Employee Page</title>
		<link rel="stylesheet" href="css/site.css"/>
	</head>
	<body>
		<jsp:include page="/header" />
		<section>
			<h3>Employee form</h3>
			
			<form:form method="POST" modelAttribute="emp">
				<div>
					<form:label path="empId">Employee ID</form:label>
					<form:input type="number" path="empId"/>
				</div>
				<div>
					<form:label path="fullName">Employee Name</form:label>
					<form:input type="text" path="fullName"/>
				</div>
				<div>
					<form:label path="designation">Designation</form:label>
					<form:select path="designation" items="${designations }" />						
				</div>
				<div>
					<form:label path="basic">Basic</form:label>
					<form:input type="decimal" path="basic"/>
				</div>
				<button>SEND</button>
			</form:form>
			
			<%-- <form method="POST">
				<div>
					<label>Employee ID</label>
					<input type="number" name="empId" id="txt1"/>
				</div>
				<div>
					<label>Employee Name</label>
					<input type="text" name="fullName"/>
				</div>
				<div>
					<label>Designation</label>
					<select name="designation">
						<option value="General Manager">General Manager</option>
						<option value="Asst., General Manager">Asst., General Manager</option>
						<option value="Manager">Manager</option>
						<option value="Senior Assosiate">Senior Assosiate</option>
						<option value="Junior Assosiate">Junior Assosiate</option>
					</select>
				</div>
				<div>
					<label>Basic</label>
					<input type="decimal" name="basic"/>
				</div>
				<button>SEND</button>
			</form> --%>
		</section>
	</body>
</html>