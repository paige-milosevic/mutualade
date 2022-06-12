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
			<a href="/dashboard">Dashboard</a>
			<a href="/">Welcome, <c:out value="${user.firstName}"></c:out></a>
			<a href="/logout">Logout</a>
		</div>
		<div>
			<h1><c:out value="${aid.title}"></c:out></h1>
			<h2>Name: <c:out value="${aid.user.firstName}"></c:out></h2>
			<p>Description: <c:out value="${aid.description}"></c:out></p>
			<p>Need Date: <c:out value="${aid.aidDate}"></c:out></p>
			<p>Urgency: <c:out value="${aid.urgency}"></c:out></p>
			<p>Instagram: <c:out value="${aid.instagram}"></c:out></p>
			<p>Venmo: <c:out value="${aid.venmo}"></c:out></p>
		</div>
		<c:if test ="${aid.user.id == user.id}">
		<a class="btn btn-light" href="/aid/edit/${aid.id}" role="button">Edit Aid Request</a>
			<form:form action="/aid/delete/${aid.id}" method="delete">
			<button class="btn btn-danger">Delete Aid Request</button>
			</form:form>
		</c:if>
	</div>
</body>
</html>