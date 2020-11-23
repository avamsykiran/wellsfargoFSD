<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Contact Us</title>
<link rel="stylesheet" href="/css/site.css" />
</head>
<body>
	<jsp:include page="/commons/header" />
	<section>
		<h3>Contact Us</h3>

		<table>
			<tr>
				<td>Call Us On</td>
				<td>
					<ol>
					<c:forEach var="m" items="${mobile }">
						<li><strong>${m }</strong></li>
					</c:forEach>
					</ol>
				</td>
			</tr>
			<tr>
				<td>Mail Us At</td>
				<td><strong>${mail }</strong></td>
			</tr>
		</table>
	</section>
</body>
</html>