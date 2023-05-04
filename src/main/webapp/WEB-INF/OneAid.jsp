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
    <link rel="stylesheet" href="/style.css">
</head>
<body>
	<div class="container">
		<div class="navbar justify-content-between align-items-center">
			<h1 style="font-weight: bold"><span style="color:#C2185B">Mutual</span><span style="color:#FBC02D">Ade</span></h1>
			<a href="/dashboard">Dashboard</a>
			<a href="/">Welcome, <c:out value="${user.firstName}"></c:out></a>
			<a href="/logout">Logout</a>
		</div>
		<div class="card w-50 mt-2">
			<div class="card-body">
				<p class="card-title fw-bold"><c:out value="${aid.title}"></c:out></p>
				<p class="card-text lh-1"><c:out value="${aid.member.firstName}"></c:out> is seeking mutual aid.</p>
				<p class="card-text lh-1">Description: <c:out value="${aid.description}"></c:out></p>
				<p class="card-text lh-1">Need Date: <c:out value="${aid.dateSTR}"></c:out></p>
				<p class="card-text lh-1">Urgency: <c:out value="${aid.urgency}"></c:out></p>
				<p class="card-text lh-1"><c:out value="${aid.member.firstName}"></c:out>'s contact information: </p>
				<p class="card-text lh-1">Instagram: <c:out value="${aid.instagram}"></c:out></p>
				<p class="card-text lh-1">Venmo: <c:out value="${aid.venmo}"></c:out></p>
				<c:if test ="${aid.member.id == user.id}">
					<a class="btn btn-sm pink_button mt-2 " href="/aid/edit/${aid.id}" role="button">Update Aid Request</a>
					<form:form action="/aid/delete/${aid.id}" method="delete">
					<button class="btn btn-sm yellow_button mt-2">I Have Received Aid</button>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>