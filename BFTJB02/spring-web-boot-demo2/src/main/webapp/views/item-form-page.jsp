<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
		<title>Item</title>
		<link rel="stylesheet" href="css/site.css"/>
	</head>
	<body>
		<jsp:include page="/header" /> 
		<section>
			<h3>Item Form</h3>
						
			<form:form method="POST" modelAttribute="item">
				<div>
					<form:label path="icode">Icode</form:label>
					<form:input type="number" path="icode" />
				</div>
				<div>
					<form:label path="name">Item Name</form:label>
					<form:input type="text" path="name" />
				</div>
				<div>
					<form:label path="costPrice">Cost Price</form:label>
					<form:input type="decimal" path="costPrice" />
				</div>
				<div>
					<form:label path="category">Category</form:label>					
					<form:select path="category" items="${categories }"/>						
				</div>
				
				<button>OK</button>
			</form:form>
			<%-- <form method="POST">
				<div>
					<label>Icode</label>
					<input type="number" name="icode" />
				</div>
				<div>
					<label>Item Name</label>
					<input type="text" name="name" />
				</div>
				<div>
					<label>Cost Price</label>
					<input type="decimal" name="costPrice" />
				</div>
				<div>
					<label>Category</label>
					<select name="category">
						<option value="AGRO">AGRO</option>
						<option value="ORNIMENT">ORNIMENT</option>
						<option value="DAIRY">DAIRY</option>
						<option value="CLOTHS">CLOTHS</option>
						<option value="OTHERS">OTHERS</option>
					</select>
				</div>
				
				<button>OK</button>
			</form> --%>					
		</section>
	</body>
</html>