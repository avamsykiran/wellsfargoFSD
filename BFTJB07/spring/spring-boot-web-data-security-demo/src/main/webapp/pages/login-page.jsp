<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<title>ADB-Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/header" />
	<section class="container-fluid p-4">
		<div class="col-sm-4">
			<form action="/login" method="POST">
				<c:if test="${param.error != null}">
					Invalid Credentials! Access Denied!
				</c:if>
				<input type="hidden" name="${_csrf.parameterName}"	
						value="${_csrf.token}" />
				<div class="form-control-group">
					<label class="form-control-label">UserName: </label>
					<input class="form-control" type="text" name="unm" />
				</div> 
				<div class="form-control-group">
					<label class="form-control-label">Password: </label>
					<input class="form-control" type="password" name="pwd" />
				</div>			
				<button>Sign In</button>
			</form>
		</div>
	</section>
</body>
</html>