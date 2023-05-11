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
			<c:if test="${user.userType == 'Organization'}">
				<a href="/org/profile/${user.id}">Welcome, <c:out value="${user.firstName}"></c:out></a>
			</c:if>
			<c:if test="${user.userType == 'Member'}">
				<a href="/">Welcome, <c:out value="${user.firstName}"></c:out></a>
			</c:if>
			<a href="/logout">Logout</a>
		</div>
		<div class="row">
			<h4>Your Profile</h4>
			<p>Name: <c:out value="${user.firstName}"></c:out> <c:out value="${user.lastName}"></c:out></p>
			<p>Email Address: <c:out value="${user.email}"></c:out></p>
		</div>		
		<div>
			<a class="btn btn-sm yellow_button mt-2" href="/update/member/profile/${user.id}" role="button">Edit Profile</a>
			<a class="btn btn-sm pink_button mt-2" href="/update/member/password/${user.id}" role="button">Change Password</a>
		</div>
		<div>
			<c:forEach items="${aid}" var="aid">
				<td><a href="/aid/${aid.id}" style="color:#C2185B"><c:out value="${aid.title}"></c:out></a></td>
				<td><c:out value="${aid.member.firstName}"></c:out></td>
				<td><c:out value="${aid.urgency}"></c:out></td>
			</c:forEach>
		</div>

	</div>
</body>
</html>