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
			<c:if test="${user.userType == 'Organization'}">
				<a href="/org/profile/${user.id}">Welcome, <c:out value="${user.firstName}"></c:out></a>
			</c:if>
			<c:if test="${user.userType == 'Member'}">
				<a href="/member/profile/${user.id}">Welcome, <c:out value="${user.firstName}"></c:out></a>
			</c:if>
			<a href="/logout">Logout</a>
		</div>
		
		<div class="row align-items-start">
			<div class="col-md-6">
				<h4>Mutual Aid Requests</h4>
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
						<c:choose>
							<c:when test="${aid.privacy == 'public'}">
								<tr>
									<td><a href="/aid/${aid.id}" style="color:#C2185B"><c:out value="${aid.title}"></c:out></a></td>
									<td><c:out value="${aid.member.firstName}"></c:out></td>
									<td><c:out value="${aid.urgency}"></c:out></td>
								</tr>
							</c:when>
						</c:choose>
					</c:forEach>
					</tbody>
				</table>
   	 			<c:if test ="${user.userType == 'Member'}">
					<a class="btn pink_button" href="/aid/new" role="button">Make MutualAde</a>
				</c:if> 
			</div>
			<div class="col-md-6">
				<h4>Organizations Offering Aid</h4>
				<table class="table">
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
				<c:if test="${user.userType == 'Organization'}">
					<a class="btn pink_button" href="/org/make/aid" role="button">Make MutualAde</a>
				</c:if>
			</div>
		</div>
		<div class="row pt-4">
				<div class="col">
					<h3>Mutual Aid Locations</h3>
		    		<!--The div element for the map -->
				    <div id="map">
				    </div>
			
				    <!-- prettier-ignore -->
				    <script>(g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})
				        ({key: "AIzaSyDe07iwewSPWd_YZhPpuqXcsju_Oc_f2K0", v: "weekly"});</script>
				</div>
		</div>
	</div>
</body>
</html>