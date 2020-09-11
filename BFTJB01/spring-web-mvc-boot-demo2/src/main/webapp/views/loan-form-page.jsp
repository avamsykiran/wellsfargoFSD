<html>
<head>
<title>loan</title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<jsp:include page="/header" />
	<section>
		<form method="POST">
			<div>
				<label>Principal</label>
				<input type="decimal" name="principal" />
			</div>
			<div>
				<label>Rate Of Interst</label>
				<input type="decimal" name="interestRate" />
			</div>
			<div>
				<label>Time Period</label>
				<input type="decimal" name="time" />
			</div>
			<button>OK</button>
		</form>
	</section>
</body>
</html>