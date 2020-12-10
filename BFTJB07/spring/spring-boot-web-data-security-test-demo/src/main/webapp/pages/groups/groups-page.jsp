<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<title>Adb-Groups</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	</head>
	<body>
		<jsp:include page="/header" />
		<section class="container-fluid p-4">
			<h3>Groups </h3>
			
			<div class="mb-4">
				<form:form action="/groups/add" method="POST" 
					modelAttribute="group" class="form-inline">
					
					<div>
						<form:errors path="*" />
					</div>
					
					<form:input path="groupId" type="number" 
						class="form-control mr-2" placeholder="Group Id"/>
					<form:input path="groupTitle" type="text" 
						class="form-control mr-2" placeholder="Group Title"/>
					<button class="btn btn-sm btn-primary">ADD</button>
				</form:form>
			</div>
			
			<c:choose>
				<c:when test="${groups==null || groups.isEmpty() }">
					<div class="alert alert-info">
						<strong>No Groups Available</strong>
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Group#</th>
								<th>Title</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="g" items="${groups }">
								<tr>
									<td>${g.groupId }</td>
									<td>${g.groupTitle }</td>
									<td>
										<a href="/groups/delete?gid=${g.groupId }" class="btn btn-sm btn-danger">
											DELETE
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