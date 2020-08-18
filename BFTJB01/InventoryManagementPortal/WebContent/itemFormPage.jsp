<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Form</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<h3>${item.icode==null?"New Item":"Edit Item" }</h3>
	
	<form action='${item.icode==null?"addItem":"saveItem" }' method="POST">
		<div>
			<label>Icode: </label>
			<input type="number" value="${item.icode }" name="icode" required 
			 ${item.icode==null?"":"readonly" } />
		</div>
		<div>
			<label>Title: </label>
			<input type="text" value="${item.title }" name="title" minlength="3" maxlength="20" required />
		</div>
		<div>
			<label>Unit: </label>
			<input type="text" value="${item.unit }" name="unit" required />
		</div>
		<div>
			<label>Package Date: </label>
			<input type="date" value="${item.packageDate }" name="packageDate" required />
		</div>
		<div>
			<label>Cost Price: </label>
			<input type="decimal" value="${item.costPrice }" name="costPrice" required />
		</div>
		<div>
			<label>Selling Price: </label>
			<input type="decimal" value="${item.sellingPrice }" name="sellingPrice" required />
		</div>
		<div>
			<label>Fragile: 
				<input type="checkbox" value="${item.fragile }" name="fragile" />
			</label>
		</div>
		<button>SAVE</button>		
	</form>
</body>
</html>