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
		<div class="col">
			<h2>Forgot Password</h2>
			<div>
			<c:if test="${error != null}">
				<p class="text-danger"><c:out value="${error}"></c:out></p>
			</c:if>
			</div> 
			<form action="/forgot_password" method="post" class="form" >
				<div>
					<p>We will send a reset password link to your email.</p>
				</div>
	 			<div class="form-row mt-2 col-md-12">
					<label name="email">Email</label>
					<form:input path="email" type="email"/>
				</div> 
				<input type="submit" value="Send" class="btn btn-sm pink_button" />
			</form>
		</div>
		
		
	</div>	
</body>
</html>