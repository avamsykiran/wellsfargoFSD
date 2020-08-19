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
	<jsp:include page="header.jsp" />
	
	<h3>${isNew?'New Loan':'Edit Loan' }</h3>
	
	<form action="${isNew?'addLoan':'saveLoan' }" method="post">
		<div>
			<label>LoanId</label>
			<input type="number" name="loanId" value="${loan.loanId }" required ${isNew?'':'readonly' }/>
		</div>	
		<div>
			<label>Principal</label>
			<input type="decimal" name="principal" value="${loan.principal }" required />
		</div>	
		<div>
			<label>Interest Rate</label>
			<input type="decimal" name="rateOfInterest" value="${loan.rateOfInterest }" required />
		</div>	
		<div>
			<label>Emi Count</label>
			<input type="number" name="emiCount" value="${loan.emiCount }" required />
		</div>	
		<div>
			<label>Date Of Disbursment</label>
			<input type="date" name="dateOfDisbursment" value="${loan.dateOfDisbursment}" required />
		</div>	
		<div>
			<label>Status</label>
			<select name="status" required>
				<option value="">--SELECT--</option>
				<c:forEach items="${['APPROVED','CLOSED','PENDING','REJECTED']}" var="opt">
					<option value="${opt }" ${opt.equals(loan.status.trim())?'selected':'') } >${opt }</option>
				</c:forEach>				
			</select>
		</div>	
		<button>SAVE</button>		
	</form>
</body>
</html>