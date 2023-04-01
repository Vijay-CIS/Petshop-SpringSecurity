<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

  <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
    <style>
    .table {
   margin: auto;
   width: 50%; 
}
    </style>
</head>
<body>

<div class="container-fluid">

<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="container-fluid">
<div align="center">	
	<h1>Pet Manager</h1>
	<div>
	<c:if test="${sessionScope.user !=null }"> 
		<a href="newPet">Create New Pet</a>
		</c:if>
	</div>
	
	<br/><br/>	
	<table class="table table-stripped">
		<thead>
			<tr>
				<th>Pet ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Place</th>
				<th>Owner </th>
				<th>Status</th>
				<th>Buy </th>
				
			</tr>
		</thead>
		<c:forEach var="pet" items="${plist}">
		<tbody>
		<tr>
			<td>${pet.petId}</td>
			<td>${pet.petName}</td>
			<td>${pet.petAge}</td>
			<td>${pet.petPlace}</td>
			<td>${pet.user!=null?pet.user.userName:""}</td>
			<td>${pet.available}</td>
			<td>
			<c:if test="${pet.available && (sessionScope.user==null || sessionScope.user.userId!=pet.user.userId)}"> 
			<a href="/buyproduct/${pet.petId}">Buy</a>
			</c:if>
			<c:if test="${not pet.available}"> 
			 Sold Out
			</c:if>
			
			<td>
			<c:if test="${sessionScope.user !=null &&  sessionScope.user.userId==pet.user.userId }"> 
		 	<a href="/editproduct/${pet.petId}">Edit</a> 
            <a href="/deleteproduct/${pet.petId}">Delete</a>
            </c:if> 
            </td> 
		</tr>
		</tbody>
		</c:forEach>
	</table>
</div>
</div>

   <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
