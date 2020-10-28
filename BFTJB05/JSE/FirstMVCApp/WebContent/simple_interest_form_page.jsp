<%@page import="java.time.LocalDate"%>
<html>
	<head>
		<title>Simple Interest Form</title>
	</head>
	<body>
		<h3><%=LocalDate.now() %></h3>
		<h1>My First Web Mvc App</h1>
		<jsp:include page="menu.jsp" />
		
		<h2>Simple Interest</h2>
		<form action="si" method="POST">
			<div>
				<label>Loan Amount</label>
				<input type="number" name="loanAmount" required/>
			</div>
			<div>
				<label>Interest Rate % (0 to 1)</label>
				<input type="decimal" name="rate" required min="0" max="1" />				
			</div>
			<div>
				<label>Loan Taken Date</label>
				<input type="date" name="disbursmentDate" required />
			</div>
			<div>
				<button>SEND</button>
			</div>
		</form>
	</body>
	
</html>