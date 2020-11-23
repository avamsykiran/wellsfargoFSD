<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Greet Us</title>
<link rel="stylesheet" href="/css/site.css" />
</head>
<body>
	<jsp:include page="/commons/header" />
	<section>
		<h3>Greet Us</h3>
		
		<form method="POST">
			<label>User Name:
				<input type="text" name="unm" required />
			</label>
			<button>SEND</button>
		</form>
		
		<c:if test="${msg != null }">
			<p><strong>${msg }</strong>
		</c:if>
		
	</section>
</body>
</html>