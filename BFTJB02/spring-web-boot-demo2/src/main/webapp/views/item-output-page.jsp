<html>
	<head>
		<title>Item</title>
		<link rel="stylesheet" href="css/site.css"/>
	</head>
	<body>
		<jsp:include page="/header" /> 
		<section>
			<h3>Item Details</h3>
		
			<table>
				<tr><td><strong>Icode:</strong></td><td>${item.icode }</td></tr>
				<tr><td><strong>Name:</strong></td><td>${item.name }</td></tr>
				<tr><td><strong>Category:</strong></td><td>${item.category }</td></tr>
				<tr><td><strong>Cost Price:</strong></td><td>${item.costPrice }</td></tr>
				<tr><td><strong>GST%:</strong></td><td>${item.gst }</td></tr>
				<tr><td><strong>Selling Price:</strong></td><td>${item.sellingPrice }</td></tr>
			</table>				
		</section>
	</body>
</html>