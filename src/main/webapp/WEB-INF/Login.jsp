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
			<a href="/">Community Member Login</a>
			<a href="/">Organization Login</a>
		</div>
		<div class="row">
			<div class="col">
				<h2>Community Member Registration</h2>
				<form:form action="/register" method="post" modelAttribute="newUser" class="form">
					<div class="form-row">
						<form:errors path="firstName"/>
						<form:label path="firstName">First Name</form:label>
						<form:input path="firstName" type="text"/>
					</div>
					<div class="form-row">
						<form:errors path="lastName"/>
						<form:label path="lastName">Last Name</form:label>
						<form:input path="lastName" type="text"/>
					</div>
					<div class="form-row">
						<form:errors path="email"/>
						<form:label path="email">Email</form:label>
						<form:input path="email" type="email"/>
					</div>
					<div class="form-row">
						<form:errors path="password"/>
						<form:label path="password">Password</form:label>
						<form:input path="password" type="password"/>
					</div>
					<div class="form-row">
						<form:errors path="confirm"/>
						<form:label path="confirm">Confirm Password</form:label>
						<form:input path="confirm" type="password"/>
					</div>
					<button type="submit">Submit</button>
				</form:form>
			</div>
		
			<div class="col">
				<h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="newLogin" class="form">
					<div class="form-row">
						<p><form:errors path="email"/></p>
						<form:label path="email">Email</form:label>
						<form:input path="email" type="email"/>
					</div>
					<div>
						<form:errors path="password"/>
						<form:label path="password">Password</form:label>
						<form:input path="password" type="password"/>
					</div>
					<button type="submit">Login</button>
				</form:form>
			</div>
		
		</div>
	</div>
</body>
</html>