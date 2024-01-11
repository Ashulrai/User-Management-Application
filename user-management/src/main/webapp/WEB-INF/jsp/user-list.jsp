<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-user">Add Users</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Users</h3>
		</div>
		
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="25%">Full Name</th>
						<th width="25%">Date of Birth</th>
						<th width="25%">Mobile</th>
						<th width="25%">Email</th>
						<th width="25%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.fullName}</td>
							<td>${user.dob}</td>
							<td>${user.mobile}</td>
							<td>${user.email}</td>
							<td><a type="button" class="btn btn-sm btn-primary"
								href="/update-user?id=${user.id}">Update</a>
							<a type="button" class="btn btn-sm btn-danger ms-1"
								href="/delete-user?id=${user.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>