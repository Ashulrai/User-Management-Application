<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">User Management System</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="user">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="fullName">Full Name</form:label>
							<form:input path="fullName" type="text" class="form-control"
								required="required" />
							<form:errors path="fullName" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="dob">Date of birth</form:label>
							<form:input path="dob" type="date" class="form-control"
								required="required" />
							<form:errors path="dob" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="Mobile">Mobile No.</form:label>
							<form:input path="Mobile" type="text" class="form-control"
								required="required" />
							<form:errors path="Mobile" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="Email">Email</form:label>
							<form:input path="Email" type="email" class="form-control"
								required="required" />
							<form:errors path="Email" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>