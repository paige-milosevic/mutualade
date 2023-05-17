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
    <title>Add Map</title>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script type="module" src="/index.js"></script>
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
			<h4><c:out value="${org.orgName}"></c:out></h4>
			<h6>Check out the MutualAde <c:out value="${org.orgName}"></c:out> is offering!</h6>
		</div>
		<div class="row">
		<c:forEach items="${orgAid}" var="orgAid">
			<div>
				<div class="card w-50 mt-2">
					<div class="card-body">
					<a href="/orgaid/${orgAid.id}"><p class="card-title fw-bold"><c:out value="${orgAid.title}"></c:out></p></a>
					<p class="card-text"><c:out value="${orgAid.description}"></c:out></p>
					<p class="card-text lh-1"><c:out value="${orgAid.dateSTR}"></c:out></p>
					<p class="card-text lh-1">Location:</p>
					<p class="card-text lh-1"><c:out value="${orgAid.address}"></c:out> <c:out value="${orgAid.apt}"></c:out></p>
					<p class="card-text lh-1"><c:out value="${orgAid.city}"></c:out>, <c:out value="${orgAid.state}"></c:out> <c:out value="${orgAid.zipCode}"></c:out></p>
					<c:if test="${orgAid.org.id == user.id}">
						<a class="btn btn-sm pink_button mt-2 " href="/org/aid/update/${orgAid.id}" role="button">Update MutualAde</a>
						<form:form action="/org/aid/delete/${orgAid.id}" method="delete">
						<button class="btn btn-sm yellow_button mt-2" onclick="return confirm("Are you sure you want to delete?")">Remove MutualAde</button>
						</form:form>
					</c:if>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
	<h3>Aid Map</h3>
    <!--The div element for the map -->
    <div id="map">
    </div>

    <!-- prettier-ignore -->
    <script>(g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})
        ({key: "AIzaSyDe07iwewSPWd_YZhPpuqXcsju_Oc_f2K0", v: "weekly"});</script>
	</div>
</body>
</html>