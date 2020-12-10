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
			<h3>${isNew?'New':'Edit' } Contact </h3>

			<div class="col-sm-5">						
			<form:form
				action="/contacts/${isNew?'add':'update' }"
				method="POST"
				modelAttribute="contact"
				class="form"
				>
				<div class="form-control-group">
					<form:errors path="*"></form:errors>
				</div>
				<div class="form-control-group">
					<form:label path="contactId" class="form-control-label">Contact Id</form:label>
					<form:input path="contactId" class="form-control" type="number"/>
				</div>
				<div class="form-control-group">
					<form:label path="firstName" class="form-control-label">First Name</form:label>
					<form:input path="firstName" class="form-control"/>
				</div>
				<div class="form-control-group">
					<form:label path="lastNAme" class="form-control-label">Last Name</form:label>
					<form:input path="lastNAme" class="form-control"/>
				</div>
				<div class="form-control-group">
					<form:label path="adbGroup.groupId" class="form-control-label">Group</form:label>
					<form:select path="adbGroup.groupId" class="form-control">
						<form:options items="${groups}" itemLabel="groupTitle" itemValue="groupId"/>
					</form:select>
				</div>
				<div class="form-control-group">
					<form:label path="contactDetails.addressLine1" class="form-control-label">
						Address Line1
					</form:label>
					<form:input path="contactDetails.addressLine1" class="form-control"/>
				</div>
				<div class="form-control-group">
					<form:label path="contactDetails.addressLine2" class="form-control-label">
						Address Line2
					</form:label>
					<form:input path="contactDetails.addressLine2" class="form-control"/>
				</div>
				<div class="form-control-group">
					<form:label path="contactDetails.city" class="form-control-label">
						City
					</form:label>
					<form:input path="contactDetails.city" class="form-control"/>
				</div>
				<div class="form-control-group">
					<form:label path="contactDetails.state" class="form-control-label">
						State
					</form:label>
					<form:input path="contactDetails.state" class="form-control"/>
				</div>
				<div class="form-control-group">
					<form:label path="contactDetails.mobileNumber" class="form-control-label">
						Mobile Number
					</form:label>
					<form:input path="contactDetails.mobileNumber" class="form-control"/>
				</div>
				<div class="form-control-group">
					<form:label path="contactDetails.emailId" class="form-control-label">
						Email Id
					</form:label>
					<form:input path="contactDetails.emailId" class="form-control"/>
				</div>
				<div class="form-control-group">
					<button class="btn btn-primary">SAVE</button>
				</div>
			</form:form>
			</div>
		</section>
	</body>
</html>