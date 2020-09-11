<html>
<head>
<title>loan</title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<jsp:include page="/header" />
	<section>
		<table>
			<tr><td><strong>Principal: </strong></td><td>${loan.principal }</td></tr>
			<tr><td><strong>Rate Of Interest: </strong></td><td>${loan.interestRate }</td></tr>
			<tr><td><strong>Time Period(yrs): </strong></td><td>${loan.time }</td></tr>
			<tr><td><strong>Simple Interest: </strong></td><td>${loan.simpleInterest }</td></tr>
			<tr><td><strong>Payable Amount: </strong></td><td>${loan.payableAmount }</td></tr>
		</table>
	</section>
</body>
</html>