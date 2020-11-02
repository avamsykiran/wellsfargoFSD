<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>AB-Contact</title>
	</head>
	<body>
		<jsp:include page="header_fragment.jsp"/>
		
		<h3>${isNew?'New':'Edit' } Contact</h3>
		<form action="${isNew?'addContact':'saveContact' }" method="POST">
			<div>
				<label>Contact Id</label>
				<input type="number" name="contactId" value="${contact.contactId }" 
				 required min="1" ${isNew?'':'readonly' } />
			</div>
			<div>
				<label>Name</label>
				<input type="text" name="name" value="${contact.name }" 
				 required minlength="5"/>
			</div>
			<div>
				<label>Group</label>
				<input type="text" name="group" value="${contact.group }" 
				 required minlength="3"/>
			</div>
			<div>
				<label>Mobile Number</label>
				<input type="text" name="mobile" value="${contact.mobile }" 
				 required pattern="[1-9][0-9]{9}"/>
			</div>
			<div>
				<label>Date Of Birth</label>
				<input type="date" name="dateOfBirth" value="${contact.dateOfBirth }"
				required />
			</div>
			<div>				
				<button>SAVE</button>
			</div>
		</form>
	</body>
</html>