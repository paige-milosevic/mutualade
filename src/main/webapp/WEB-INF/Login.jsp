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
			<a href="/">Community Member Login</a>
			<a href="/org">Organization Login</a>
		</div>
		<div class="row">
			<h4>When life give you <span style="color:#FBC02D""font-weight:bold">lemons</span>... Give MutualAde!</h4>
			<p style="color:#C2185B">MutualAde is a community board that connects individuals looking for aid to those with the capacity to give it.</p>
		</div>
		<div class="row">
			<div class="col">
				<h4>Community Member Registration</h4>
				<form:form action="/register" method="post" modelAttribute="newUser" class="form">
					<div class="form-row mt-2 col-md-12">
						<div class="alert-danger">
							<form:errors path="firstName"/>
						</div>
						<form:label path="firstName">First Name</form:label>
						<form:input path="firstName" type="text"/>
					</div>
					<div class="form-row mt-2 col-md-12">
						<div class="text-danger">
							<form:errors path="lastName"/>
						</div>
						<form:label path="lastName">Last Name</form:label>
						<form:input path="lastName" type="text"/>
					</div>
					<div class="form-row mt-2 col-md-12">
						<div class="text-danger">
							<form:errors path="email"/>
						</div>
						<form:label path="email">Email</form:label>
						<form:input path="email" type="email"/>
					</div>
					<div class="form-row mt-2 col-md-12">
						<div class="text-danger">
							<form:errors path="password"/>
						</div>
						<form:label path="password">Password</form:label>
						<form:input path="password" type="password"/>
					</div>
					<div class="form-row mt-2 col-md-12">
						<div class="text-danger">
							<form:errors path="confirm"/>
						</div>
						<form:label path="confirm">Confirm Password</form:label>
						<form:input path="confirm" type="password"/>
					</div>
					<form:input type="hidden" path="userType" value="Member"/>
					<button class="btn btn-sm pink_button" type="submit">Submit</button>
				</form:form>
			</div>
		
			<div class="col">
				<h4>Login</h4>
				<form:form action="/login" method="post" modelAttribute="newLogin" class="form">
					<div class="form-row mt-2 col-md-12">
						<div class="text-danger">
							<form:errors path="email"/>
						</div>
						<form:label path="email">Email</form:label>
						<form:input path="email" type="email"/>
					</div>
					<div class="form-row mt-2 col-md-12">
						<div class="text-danger">
							<form:errors path="password"/>
						</div>
						<form:label path="password">Password</form:label>
						<form:input path="password" type="password"/>
					</div>
					<div>
						<a href="/forgot_password">Forgot Password?</a>
					</div>
					<button class="btn btn-sm yellow_button" type="submit">Login</button>
				</form:form>
			</div>
		
		</div>
	</div>
</body>
</html>