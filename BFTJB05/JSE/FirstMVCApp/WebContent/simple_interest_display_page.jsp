<%@page import="com.wellsfargo.batch5.fmvc.model.Loan"%>
<%@page import="java.time.LocalDate"%>
<html>
	<head>
		<title>Simple Interest Display</title>
	</head>
	<body>
		<h3><%=LocalDate.now() %></h3>
		<h1>My First Web Mvc App</h1>
		<jsp:include page="menu.jsp" />
		
		<h2>Simple Interest</h2>
		
		<%-- <% Loan loan = (Loan) request.getAttribute("loan"); %>
		
		<table>
			<tr><td>Loan Amount</td><td><strong><%=loan.getLoanAmount() %></strong></td></tr>
			<tr><td>Rate Of Interest %</td><td><strong><%=loan.getRate() %></strong></td></tr>
			<tr><td>Disbursement Date</td><td><strong><%=loan.getDisbursmentDate() %></strong></td></tr>
			<tr><td>Simple Interest</td><td><strong><%=loan.getInterest() %></strong></td></tr>
			<tr><td>Payable Amount</td><td><strong><%=loan.getPayableAmount() %></strong></td></tr>
		</table> --%>
		
		<table>
			<tr><td>Loan Amount</td><td><strong>${loan.loanAmount }</strong></td></tr>
			<tr><td>Rate Of Interest %</td><td><strong>${loan.rate}</strong></td></tr>
			<tr><td>Disbursement Date</td><td><strong>${loan.disbursmentDate}</strong></td></tr>
			<tr><td>Simple Interest</td><td><strong>${loan.interest }</strong></td></tr>
			<tr><td>Payable Amount</td><td><strong>${loan.payableAmount}</strong></td></tr>
		</table>
	</body>
	
</html>