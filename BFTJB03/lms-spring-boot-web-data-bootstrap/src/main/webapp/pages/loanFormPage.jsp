<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LMS</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="/header" />

	<section class="container-fluid p-4">
		<h3>${isNew?'New Loan':'Edit Loan' }</h3>

		<div class="col-sm-4">
			<form:form action="${isNew?'addLoan':'saveLoan' }" method="post"
				modelAttribute="loan">
				<div class="form-group">
					<form:label path="loanId">LoanId</form:label>
					<form:input type="number" path="loanId" readonly="${!isNew }" class="form-control"/>
					<form:errors path="loanId"  class="well well-danger"/>
				</div>
				<div class="form-group">
					<form:label path="principal">Principal</form:label>
					<form:input type="decimal" path="principal" class="form-control"/>
					<form:errors path="principal" class="well well-danger"/>
				</div>
				<div class="form-group">
					<form:label path="rateOfInterest">Rate Of Interest</form:label>
					<form:input type="decimal" path="rateOfInterest" class="form-control"/>
					<form:errors path="rateOfInterest" class="well well-danger"/>
				</div>
				<div class="form-group">
					<form:label path="emiCount">EMI Count</form:label>
					<form:input type="number" path="emiCount" class="form-control"/>
					<form:errors path="emiCount" class="well well-danger"/>
				</div>
				<div class="form-group">
					<form:label path="dateOfDisbursment">Date Of Disbursment</form:label>
					<form:input type="date" path="dateOfDisbursment" class="form-control"/>
					<form:errors path="dateOfDisbursment" class="well well-danger"/>
				</div>
				<div class="form-group">
					<form:label path="status">Status</form:label>
					<form:select path="status" items="${allStatus }" class="form-control"/>
				</div>
				<div class="form-group text-right">
					<button class="btn btn-primary">SAVE</button>
				</div>
			</form:form>
		</div>
	</section>
</body>
</html>