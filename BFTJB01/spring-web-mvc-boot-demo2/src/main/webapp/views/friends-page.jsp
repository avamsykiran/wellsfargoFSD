<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
<title>Friends</title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<jsp:include page="/header" />
	<section>
		<h3>Friends</h3>
		<c:if test="${frds!=null && !frds.isEmpty() }">
			<ol>
			<c:forEach items="${frds }" var="f">
				<li>${f } (<a href="removeFriend?fnm=${f }"><strong>X</strong></a>)</li>
			</c:forEach>
			</ol>
			<hr />
		</c:if>
		
		<form action="addFriend">
			<label>Friend Name</label>
			<input type="text" name="fnm" />
			<button>ADD</button>
		</form>
	</section>
</body>
</html>