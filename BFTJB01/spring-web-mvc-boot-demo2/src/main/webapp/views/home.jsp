<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<jsp:include page="/header" />
	<section>
		<form action="greet">
			<label>Enter Your Name: <input type="text" name="unm" />
			</label>
			<button>OK</button>
		</form>

		<p>
			<strong>${msg }</strong>
		</p>
	</section>
</body>
</html>