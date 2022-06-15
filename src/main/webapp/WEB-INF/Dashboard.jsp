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
			<a href="/org/profile/${user.id}">Welcome, <c:out value="${user.firstName}"></c:out></a>
			<a href="/logout">Logout</a>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Name</th>
						<th>Urgency</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${mutualAid}" var="aid">
					<tr>
						<td><a href="/aid/${aid.id}" style="color:#C2185B"><c:out value="${aid.title}"></c:out></a></td>
						<td><c:out value="${aid.user.firstName}"></c:out></td>
						<td><c:out value="${aid.urgency}"></c:out></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<a class="btn pink_button" href="/aid/new" role="button">Create Aid Request</a>
<%-- 			<c:if test ="${user.orgName != null}">
				<a class="btn pink_button" href="/aid/new" role="button">Make MutualAde</a>
			</c:if> --%>
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<th>Organization Name</th>
					</tr>
					
				</thead>
				<tbody>
				<c:forEach items="${organization}" var="org">
					<tr>
						<td><a href="/org/page/${org.id}" style="color:#C2185B"><c:out value="${org.orgName}"></c:out></a></td>
					</tr>
				</c:forEach>				
				</tbody>
			</table>
			<a class="btn pink_button" href="/org/make/aid" role="button">Make MutualAde</a>
		</div>
		
	</div>
</body>
</html>