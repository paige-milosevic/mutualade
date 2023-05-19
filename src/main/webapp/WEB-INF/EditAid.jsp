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
		<div class="row">
<%-- 			<h4><c:out value="${aid.title}"></c:out></h4> --%>
			<h4>Edit Aid Request</h4>
			<form:form action="/aid/update/${aid.id}" method="post" modelAttribute="aid">
				<input type="hidden" name="_method" value="put"/>
				<div class="form-row mt-2 col-md-12">
					<div class="text-danger">
						<form:errors path="title"/>
					</div>
					<form:label path="title">Title: </form:label>
					<form:input path="title" input="text"/>
				</div>
				<div class="form-row mt-2 col-md-12">
					<form:label path="dateSTR">Need Request Date: </form:label>
					<form:input path="dateSTR" type="date" value="${aid.aidDate}"/>

				</div>
				<div class="form-row mt-2 col-md-12">
					<div class="text-danger">
						<form:errors path="urgency"/>
					</div>
					<form:label path="urgency">Urgency: </form:label>
					<form:select path="urgency" value="${aid.urgency}">
						<option value="${aid.urgency}"><c:out value="${aid.urgency}"></c:out></option>
						<option value="High">High</option>
						<option value="Medium">Medium</option>
						<option value="Low">Low</option>
					</form:select>
				</div>
				<div class="form-row mt-2 col-md-12">
					<div class="text-danger">
						<form:errors path="description"/>
					</div>
					<form:label path="description">Description: </form:label>
					<form:textarea path="description" input="text"/>
				</div>
				<div class="form-row mt-2 col-md-12">
					<div class="text-danger">
						<form:errors path="privacy"/>
					</div>
					<form:label path="privacy">Private</form:label>
					<form:radiobutton path="privacy" value="private" checked="true"/>
					<form:label path="privacy">Public</form:label>
					<form:radiobutton path="privacy" value="public"/>
				</div>
				<div class="form-row mt-2 col-md-12">
					<form:label path="venmo">Venmo Handle: </form:label>
					<form:input path="venmo" input="text"/>
				</div>
				<div class="form-row mt-2 col-md-12">
					<form:label path="instagram">Instragram: </form:label>
					<form:input path="instagram" input="text"/>
				</div>
				<div>
					<form:input type="hidden" path="member" value="${member.id}"/>
				</div>
				<input class="btn btn-sm pink_button mt-2" type="submit" value="Submit Request">
			</form:form>
		</div>
	</div>
</body>
</html>