<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>Lib-Books</title>
	</head>
	<body>
		<jsp:include page="menu.jsp"/>
		
		<h3>Books List</h3>
		<c:choose>
			<c:when test="${booksList==null || booksList.isEmpty() }">
				<p>No Record Found!
			</c:when>
			<c:otherwise>
				<table>
					<thead>
						<tr>
							<th>Book#</th>
							<th>Title</th>
							<th>Category</th>
							<th>Price</th>
							<th>PublishDate</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="b" items="${booksList }">
							<tr>
								<td>${b.bookCode }</td>
								<td>${b.title }</td>
								<td>${b.category }</td>
								<td>${b.price }</td>
								<td>${b.publishDate }</td>
								<td>
									<a href="editBook?bcode=${b.bookCode }">EDIT</a>
									<span>|</span>
									<a href="deleteBook?bcode=${b.bookCode }">DELETE</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>