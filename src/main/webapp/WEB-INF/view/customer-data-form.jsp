<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customer-Data-Form</title>
</head>

<body>
	<h4>
		<div class="jumbotron">
			<i>CUSTOMER RELATIONSHIP MANAGEMENT</i>
		</div>
	</h4>
	<hr>
	<div class="container">
		<i>Add New Customer Details</i>
	</div>
	<form action="/CustomerRelationshipManagement/crmData/save"
		method="POST">
		<div class="container">
			<input type="hidden" name="id" value="${CustomerDetails.id}" />

			<i><table>
				<tr>
					<th>First Name</th>
					<td class="form-inline"><input type="text" name="firstName"
						value="${CustomerDetails.firstName}"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td class="form-inline"><input type="text" name="lastName"
						value="${CustomerDetails.lastName}"></td>
				</tr>
				<tr>
					<th>Email</th>
					<td class="form-inline"><input type="text" name="email"
						value="${CustomerDetails.email}"></td>
				</tr>
			</table></i>

			<button type="submit" class="btn btn-info">Save</button>
		</div>
	</form>
	<hr>
	<div class="container">
		<a href="/CustomerRelationshipManagement/crmData/list">Home</a>
	</div>

</body>

</html>