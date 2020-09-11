<html>
	<head>
		<title>Employee Page</title>
		<link rel="stylesheet" href="css/site.css"/>
	</head>
	<body>
		<jsp:include page="/header" />
		<section>
			<h3>Employee Details</h3>
			
			<table>
				<tr><td><strong>EmpId</strong></td><td>${emp.empId }</td></tr>
				<tr><td><strong>Full Name</strong></td><td>${emp.fullName }</td></tr>
				<tr><td><strong>Designation</strong></td><td>${emp.designation }</td></tr>
				<tr><td><strong>Basic</strong></td><td>${emp.basic }</td></tr>
				<tr><td><strong>HRA</strong></td><td>${emp.hra }</td></tr>
				<tr><td><strong>TA</strong></td><td>${emp.ta }</td></tr>
			</table>
		</section>
	</body>
</html>