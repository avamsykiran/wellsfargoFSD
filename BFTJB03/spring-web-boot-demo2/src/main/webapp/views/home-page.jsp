<html>
	<head>
		<title>Home Page</title>
		<link rel="stylesheet" href="css/site.css"/>
	</head>
	<body>
		<jsp:include page="/header" />
		<section>
			<h3>Welcome Home</h3>
			
			<form action="greet">
				<label>Name: </label>
				<input type="text" name="unm" />
				<button>OK</button>
			</form>
			
			<p><strong>${msg }</strong></p>
		</section>
	</body>
</html>