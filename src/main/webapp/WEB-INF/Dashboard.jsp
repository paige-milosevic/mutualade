<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MutualAde</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row justify-content-between align-items-center">
			<h1 class="text-pink">MutualAde</h1>
			<a href="/">Welcome, <c:out value="${user.firstName}"></c:out></a>
			<a href="/logout">Logout</a>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Title</td>
						<td>Name</td>
						<td>Urgency</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${mutualAid}" var="aid">
					<tr>
						<td><a href="/aid/${aid.id}"><c:out value="${aid.title}"></c:out></a></td>
						<td><c:out value="${aid.user.firstName}"></c:out></td>
						<td><c:out value="${aid.urgency}"></c:out></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<a class="btn btn-light" href="/aid/new" role="button">Create Aid Request</a>
		</div>
	</div>
</body>
</html>