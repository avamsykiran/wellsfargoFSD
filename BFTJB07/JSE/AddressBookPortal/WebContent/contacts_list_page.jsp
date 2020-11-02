<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>AB-Contacts</title>
	</head>
	<body>
		<jsp:include page="header_fragment.jsp"/>
		
		<h3>All Contacts</h3>
		
		<c:choose>
			<c:when test="${contacts==null || contacts.isEmpty() }">
				<p>No Records Fetched</p>
			</c:when>
			<c:otherwise>
				<table>
					<thead>
						<tr>
							<th>Contact#</th>
							<th>Name</th>
							<th>Group</th>
							<th>Mobile</th>
							<th>Date Of Birth</th>
							<th>Action</th>
					</thead>
					<tbody>
						<c:forEach var="c" items="${contacts }">
							<tr>
								<td>${c.contactId }</td>
								<td>${c.name }</td>
								<td>${c.group }</td>
								<td>${c.mobile }</td>
								<td>${c.dateOfBirth }</td>
								<td>
									<a href="editContact?cid=${c.contactId }">EDIT</a>
									<span>|</span>
									<a href="deleteContact?cid=${c.contactId }">DELETE</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
			
		</c:choose>
		
		
	</body>
</html>