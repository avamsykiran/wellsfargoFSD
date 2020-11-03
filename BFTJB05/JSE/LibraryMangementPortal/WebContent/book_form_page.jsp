<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>Lib-BookForm</title>
	</head>
	<body>
		<jsp:include page="menu.jsp"/>
		
		<h3>${(isNew?"New":"Edit") } Book</h3>
		
		<p><strong>${errs }</strong></p>
		
		<form action="${isNew?'addBook':'saveBook'}" method="POST">
			<div>
				<label>Book Code</label>
				<input type="number" name="bookCode" required 
				value="${book.bookCode}" ${isNew?'':'readonly' }/>
			</div>
			<div>
				<label>Title</label>
				<input type="text" name="title" required value="${book.title}"/>
			</div>
			<div>
				<label>Price</label>
				<input type="number" step="0.01" name="price" required value="${book.price}"/>
			</div>
			<div>
				<label>Category</label>
				<input type="text" name="category" required value="${book.category}"/>
			</div>
			<div>
				<label>Publish Date</label>
				<input type="date" name="publishDate" required value="${book.publishDate}"/>
			</div>
			<div>
				<button>SAVE</button>
			</div>
		</form>
	</body>
</html>