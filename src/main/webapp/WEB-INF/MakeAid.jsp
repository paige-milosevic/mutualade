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
			<h4>Make Mutual Aid</h4>
			<form:form action="/org/create/aid" method="post" modelAttribute="orgAid">
				<div class="form-row mt-2 col-md-12">
					<div class="text-danger">
						<form:errors path="title"/>
					</div>
					<form:label path="title">Title: </form:label>
					<form:input path="title" input="text"/>
				</div>
				<div class="form-row mt-2 col-md-12">
					<div class="text-danger">
						<form:errors path="frequency"/>
					</div>
					<form:label path="frequency">Frequency: </form:label>
					<form:select path="frequency">
						<option value="Daily">Daily</option>
						<option value="Weekly">Weekly</option>
						<option value="Bi-Weekly">Bi-Weekly</option>
						<option value="Monthly">Monthly</option>
						<option value="One Time">One Time</option>
					</form:select>
				</div>
				<div class="form-row mt-2 col-md-12">
					<form:label path="dateSTR">Date: </form:label>
					<form:input path="dateSTR" type="date" />
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
						<form:errors path="address"/>
					</div>
					<div class="form-row mt-2 col-md-12">
						<form:label path="address">Address: </form:label>
						<form:input path="address" input="text"/>
						<form:label path="apt">Apt/Ste: </form:label>
						<form:input path="apt" input="text"/>
					</div>
					<div class="form-row mt-2 col-md-12">
						<div class="text-danger">
							<form:errors path="city"/>
						</div>
						<form:label path="city">City: </form:label>
						<form:input path="city" input="text"/>
						<div class="text-danger">
							<form:errors path="state"/>
						</div>
						<form:label path="state">State: </form:label>
						<form:input path="state" input="text"/>
						<div class="text-danger">
							<form:errors path="zipCode"/>
						</div>
						<form:label path="zipCode">Zip Code: </form:label>
						<form:input path="zipCode" input="text"/>
					</div>
				</div>
				<div>
					<form:input type="hidden" path="org" value="${org.id}"/>
				</div>
				<input class="btn btn-sm pink_button mt-2" type="submit" value="Submit Request">
			</form:form>
		</div>
	</div>

</body>
</html>