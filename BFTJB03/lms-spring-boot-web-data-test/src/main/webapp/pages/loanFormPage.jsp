<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LMS</title>
</head>
<body>
	<jsp:include page="/header" />
	
	<h3>${isNew?'New Loan':'Edit Loan' }</h3>
	
	<form:form action="${isNew?'addLoan':'saveLoan' }" method="post" modelAttribute="loan">
		<div>
			<form:label path="loanId">LoanId</form:label>
			<form:input type="number" path="loanId" readonly="${!isNew }"/>
			<form:errors path="loanId"/>
		</div>	
		<div>
			<form:label path="principal">Principal</form:label>
			<form:input type="decimal" path="principal" />
			<form:errors path="principal"/>
		</div>	
		<div>
			<form:label path="rateOfInterest">Rate Of Interest</form:label>
			<form:input type="decimal" path="rateOfInterest" />
			<form:errors path="rateOfInterest"/>
		</div>	
		<div>
			<form:label path="emiCount">EMI Count</form:label>
			<form:input type="number" path="emiCount" />
			<form:errors path="emiCount"/>			
		</div>	
		<div>
			<form:label path="dateOfDisbursment">Date Of Disbursment</form:label>
			<form:input type="date" path="dateOfDisbursment" />
			<form:errors path="dateOfDisbursment"/>
		</div>	
		<div>
			<form:label path="status">Status</form:label>
			<form:select path="status" items="${allStatus }"/>
		</div>	
		<button>SAVE</button>		
	</form:form>
</body>
</html>