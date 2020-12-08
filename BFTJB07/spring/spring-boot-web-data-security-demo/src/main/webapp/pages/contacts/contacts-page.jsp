<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<title>Adb-Contacts</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	</head>
	<body>
		<jsp:include page="/header" />
		<section class="container-fluid p-4">
			<h3>Contacts </h3>
						
			<c:choose>
				<c:when test="${contacts==null || contacts.isEmpty() }">
					<div class="alert alert-info">
						<strong>No Contacts Available</strong>
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Contact#</th>
								<th>Name</th>								
								<th>Group</th>
								<th>Email</th>
								<th>Mobile</th>
								<th>Address</th>
								<th colspan="2"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${contacts }">
								<tr>
									<td>${c.contactId }</td>
									<td>${c.firstName } ${c.lastNAme }</td>
									<td>${c.adbGroup.groupTitle }</td>
									<td>${c.contactDetails.emailId }</td>
									<td>${c.contactDetails.mobileNumber }</td>
									<td>${c.contactDetails.addressLine1 } 
										${c.contactDetails.addressLine2 }
										${c.contactDetails.city }
										${c.contactDetails.state }
									</td>
									<td>
										<a href="/contacts/delete?cid=${c.contactId }" class="btn btn-sm btn-danger">
											DELETE
										</a>
									</td>
									<td>
										<a href="/contacts/edit?cid=${c.contactId }" class="btn btn-sm btn-info">
											EDIT
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>					
					</table>
				</c:otherwise>
			</c:choose>
			
		</section>
	</body>
</html>