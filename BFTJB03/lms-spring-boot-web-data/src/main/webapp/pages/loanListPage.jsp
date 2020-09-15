<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>LMS</title>
</head>
<body>
	<jsp:include page="/header" />
	
	<c:choose>
		<c:when test="${loans == null || loans.isEmpty() }">
			<p>No Loans Avialable</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Loan#</th>
					<th>Principal</th>
					<th>Interest Rate</th>
					<th>Disbursment Date</th>
					<th>Emis</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${loans }" var="loan">
					<tr>
						<td>${loan.loanId }</td>
						<td>${loan.principal }</td>
						<td>${loan.rateOfInterest }</td>
						<td>${loan.dateOfDisbursment }</td>
						<td>${loan.emiCount }</td>
						<td>${loan.status }</td>
						<td>
							<a href="deleteLoan?id=${loan.loanId }">DELETE</a>
							<span>|</span>
							<a href="editLoan?id=${loan.loanId }">EDIT</a>
						</td>
					</tr> 
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>