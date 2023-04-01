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
   
</head>
<body>

<div class="container-fluid">
<jsp:include page="header.jsp"></jsp:include>

</div>
<div class="container-fluid">
<div align="center">	
	<h1>Welcome to My Pet!</h1>
	
	<br/><br/>	
	<table class="table table-stripped">
		<thead>
			<tr>
				<th>Pet ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Place</th>
				<th>Status</th>
				<th>Action</th>
			
			
			</tr>
		</thead>
		<c:forEach var="pet" items="${plist}">
		<tbody>
		<tr>
			<td>${pet.petId}</td>
			<td>${pet.petName}</td>
			<td>${pet.petAge}</td>
			<td>${pet.petPlace}</td>
			<td>${pet.available}</td>
			<td>
			<c:if test="${not pet.available}">
			<a href="updatePetAvailableStatus/${pet.petId}/1">Ready to sale</a>
			</c:if>
			<c:if test="${pet.available}">
			<a href="updatePetAvailableStatus/${pet.petId}/0">Cancel</a>
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
