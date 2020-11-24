<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Friends</title>
<link rel="stylesheet" href="/css/site.css" />
</head>
<body>
	<jsp:include page="/commons/header" />
	<section>
		<h3>Friends</h3>
		
		<form action="/friends/add" method="GET">
			<label>Friend Name:
				<input type="text" name="fnm" required />
			</label>
			<button>ADD</button>
		</form>
		
		<c:if test="${friends!=null && !friends.isEmpty()}">
			<ol>
				<c:forEach var="friend" items="${friends }">
					<li>${friend }  (<a href="/friends/remove?fnm=${friend }">remove</a>)</li>
				</c:forEach>
			</ol>
		</c:if>
		
	</section>
</body>
</html>