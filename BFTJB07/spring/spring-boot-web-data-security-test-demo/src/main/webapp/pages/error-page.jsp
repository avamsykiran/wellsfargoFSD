<html>
	<head>
		<title>Adb-Error</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	</head>
	<body>
		<jsp:include page="/header" />
		<section class="container-fluid p-4">
			<div class="card card-danger">
				<div class="card-header">
					<h3>An Error Occurred While Processing Your Request</h3>
				</div>
				<div class="card-body">
					<h5>${errMsg }</h5>
					<ol>
						<li>The above error occured while processing your reqeust</li>
						<li>Please correct your data before submiting 
						- if the error message is about that</li>
						<li>If the shown error is irrelevent or persistant please contact Admin</li>
					</ol>
				</div>
			</div>
		</section>
	</body>
</html>