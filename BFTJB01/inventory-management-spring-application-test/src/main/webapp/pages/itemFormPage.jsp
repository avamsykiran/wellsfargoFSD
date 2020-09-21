<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Form</title>
</head>
<body>

	<jsp:include page="/header" />
	
	<h3>${isNew?"New Item":"Edit Item" }</h3>
	
	<form:form action='${isNew?"addItem":"saveItem" }' method="POST" modelAttribute="item">
		<div>
			<form:label path="icode">Icode: </form:label>
			<form:input type="number" path="icode" readonly="${!isNew}"/>
			<form:errors path="icode"/>
		</div>
		<div>
			<form:label path="title">Title: </form:label>
			<form:input type="text" path="title" />
			<form:errors path="title"/>
		</div>
		<div>
			<form:label path="unit">Unit: </form:label>
			<form:select path="unit" items="${units }"/> 
			<%-- <form:radiobuttons path="unit" items="${units }"/> --%>
			<form:errors path="unit"/>
		</div>
		<div>
			<form:label path="packageDate">Package Date: </form:label>
			<form:input type="date" path="packageDate" />
			<form:errors path="packageDate"/>			
		</div>
		<div>
			<form:label path="costPrice">Cost Price: </form:label>
			<form:input type="decimal" path="costPrice" />
			<form:errors path="costPrice"/>			
		</div>
		<div>
			<form:label path="sellingPrice">Selling Price: </form:label>
			<form:input type="decimal" path="sellingPrice" />
			<form:errors path="sellingPrice"/>		
		</div>
		<div>
			<form:label path="fragile">Fragile</form:label>
			<form:checkbox path="fragile" />
			<form:errors path="fragile"/>
		</div>
		<button>SAVE</button>		
	</form:form>
</body>
</html>