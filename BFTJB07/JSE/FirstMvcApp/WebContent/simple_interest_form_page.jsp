<%@page import="java.time.LocalDate"%>
<html>
	<head>
		<title>simple interst form</title>
	</head>
	<body>
		<h3><%=LocalDate.now() %></h3>
		<h1>First MVC App</h1>
		<jsp:include page="menu.jsp"/>
		
		<h2>Simple Interest</h2>
		<form action="si" method="POST" >
			<div>
				<label>Loan Amount: </label>
				<input type="number" name="loanAmount" required />
			</div>
			<div>
				<label>Rate Of Interest (%) (0 to 1): </label>
				<input type="number" name="rate" min="0" max="1" step="0.01" required />
			</div>
			<div>
				<label>Date Of Disbursement: </label>
				<input type="date" name="disbursementDate" required />
			</div>
			<div>
				<label>Date Of Payment: </label>
				<input type="date" name="dueDate" required />
			</div>
			<div>
				<button>SEND</button>
			</div>
		</form>
	</body>
</html>