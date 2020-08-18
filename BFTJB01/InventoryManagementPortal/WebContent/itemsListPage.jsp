<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items List</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h3>Items</h3>
	
	<c:choose>
		<c:when test="${items==null || items.isEmpty() }">
			<p>No Items Found</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Icode</th>
					<th>Title</th>
					<th>Is Fragile</th>
					<th>Package Date</th>
					<th>Unit</th>
					<th>Cost Price</th>
					<th>Selling Price</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${items }" var="item">
					<tr>
					<td>${item.icode }</td>
					<td>${item.title }</td>
					<td>${item.fragile }</td>
					<td>${item.packageDate }</td>
					<td>${item.unit }</td>
					<td>${item.costPrice }</td>
					<td>${item.sellingPrice }</td>
					<td>
						<a href="deleteItem?icode=${item.icode }">DELETE</a> <span>|</span>
						<a href="editItem?icode=${item.icode }">EDIT</a> <span>|</span>
					</td>
				</tr>				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>