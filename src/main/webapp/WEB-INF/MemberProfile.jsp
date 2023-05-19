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
				<a href="/">Dashboard</a>
			</c:if>
			<a href="/logout">Logout</a>
		</div>
		
		<div>
			<h4>Your Profile</h4>
			<p>Name: <c:out value="${user.firstName}"></c:out> <c:out value="${user.lastName}"></c:out></p>
			<p>Email Address: <c:out value="${user.email}"></c:out></p>
		</div>		
		<div>
			<a class="btn btn-sm yellow_button mt-2" href="/update/member/profile/${user.id}" role="button">Edit Profile</a>
			<a class="btn btn-sm pink_button mt-2" href="/update/member/password/${user.id}" role="button">Change Password</a>
		</div>
		<div class="row pt-5">

			<h3>Your Current Aid Requests</h3>
			<c:forEach items="${aid}" var="aid">
			<div class="col-md-6 pt-3">
				<div class="card">
					<div class="w-50 mt-2">
						<div class="card-body">
							<p class="card-title fw-bold"><c:out value="${aid.title}"></c:out></p>
							<p><c:out value="${aid.dateSTR}"></c:out></p>
							<c:if test ="${aid.member.id == user.id}">
								<a class="btn btn-sm pink_button mt-2 " href="/aid/edit/${aid.id}" role="button">Update Aid Request</a>
								<form:form action="/aid/delete/${aid.id}" method="delete">
								<button class="btn btn-sm yellow_button mt-2">I Have Received Aid</button>
								</form:form>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>

	</div>
</body>
</html>