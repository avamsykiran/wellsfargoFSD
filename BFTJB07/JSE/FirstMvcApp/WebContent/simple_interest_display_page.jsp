<%@page import="com.wellsfargo.batch7.fma.model.Loan"%>
<%@page import="java.time.LocalDate"%>
<html>
	<head>
		<title>simple interest form</title>
	</head>
	<body>
		<h3><%=LocalDate.now() %></h3>
		<h1><%=application.getInitParameter("webAppTitle") %></h1>
		<jsp:include page="menu.jsp"/>
		
		<h2>Simple Interest</h2>
		<%-- 
		<% Loan loan = (Loan) request.getAttribute("loan"); %>
		
		<table>
			<tr><td><strong>Loan Amount</strong></td>
				<td><em><%=loan.getLoanAmount() %></em></td></tr>
			<tr><td><strong>Rate Of Interest %</strong></td>
				<td><em><%=loan.getRate() %></em></td></tr>
			<tr><td><strong>Disbursement Date</strong></td>
				<td><em><%=loan.getDisbursementDate() %></em></td></tr>
			<tr><td><strong>Due Date</strong></td>
				<td><em><%=loan.getDueDate() %></em></td></tr>
			<tr><td><strong>Time</strong></td>
				<td><em><%=loan.getTimeInYears() %> yrs</em></td></tr>
			<tr><td><strong>Interest</strong></td>
				<td><em><%=loan.getInterest() %></em></td></tr>
			<tr><td><strong>Payable Amount</strong></td>
				<td><em><%=loan.getPayableAmount() %></em></td></tr>
		</table> --%>
				
		<table>
			<tr><td><strong>Loan Amount</strong></td>
				<td><em>${loan.loanAmount}</em></td></tr>
			<tr><td><strong>Rate Of Interest %</strong></td>
				<td><em>${loan.rate}</em></td></tr>
			<tr><td><strong>Disbursement Date</strong></td>
				<td><em>${loan.disbursementDate}</em></td></tr>
			<tr><td><strong>Due Date</strong></td>
				<td><em>${loan.dueDate}</em></td></tr>
			<tr><td><strong>Time</strong></td>
				<td><em>${loan.timeInYears} yrs</em></td></tr>
			<tr><td><strong>Interest</strong></td>
				<td><em>${loan.interest}</em></td></tr>
			<tr><td><strong>Payable Amount</strong></td>
				<td><em>${loan.payableAmount}</em></td></tr>
		</table>
		
	</body>
</html>