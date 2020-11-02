<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>AB-Err</title>
	</head>
	<body>
		<jsp:include page="header_fragment.jsp"/>
		
		<h3>Error Occurred</h3>
		<ul>
			<li>The below Error occurred while processing your request.</li>
			<li>Kindly follow the message and request again.</li>
			<li>If error persists contact admin.</li>
			<li>Inconvenience Regretted!</li>
		</ul>
		
		<p><strong>Error: ${errMsg }</strong></p>
	</body>
</html>