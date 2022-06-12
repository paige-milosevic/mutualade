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
		<div class="row">
			<h1>Create A Mutual Aid Request</h1>
			<form:form action="/aid/create" method="post" modelAttribute="aid">
				<div>
					<div class="text-danger">
						<form:errors path="title"/>
					</div>
					<form:label path="title">Title: </form:label>
					<form:input path="title" input="text"/>
				</div>
				<div>
					<form:label path="dateSTR">Need Request Date: </form:label>
					<form:input path="dateSTR" type="date" />
				</div>
				<div>
					<div class="text-danger">
						<form:errors path="urgency"/>
					</div>
					<form:label path="urgency">Urgency: </form:label>
					<form:select path="urgency">
						<option value="High">High</option>
						<option value="Medium">Medium</option>
						<option value="Low">Low</option>
					</form:select>
				</div>
				<div>
					<div class="text-danger">
						<form:errors path="description"/>
					</div>
					<form:label path="description">Description: </form:label>
					<form:textarea path="description" input="text"/>
				</div>
				<div>
					<div class="text-danger">
						<form:errors path="privacy"/>
					</div>
					<form:label path="privacy">Private</form:label>
					<form:radiobutton path="privacy" value="private" checked="true"/>
					<form:label path="privacy">Public</form:label>
					<form:radiobutton path="privacy" value="public"/>
				</div>
				<div>
					<form:label path="venmo">Venmo Handle: </form:label>
					<form:input path="venmo" input="text"/>
				</div>
				<div>
					<form:label path="instagram">Instragram: </form:label>
					<form:input path="instagram" input="text"/>
				</div>
				<div>
					<form:input type="hidden" path="user" value="${user.id}"/>
					
				</div>
				<input class="btn btn-light" type="submit" value="Submit Request">
			</form:form>
		</div>
	</div>
</body>
</html>