<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new Pet</title>
 <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">

</head>
<body>
<div class="container-fluid">
<jsp:include page="header.jsp"></jsp:include>

</div>
<div align="container-fluid">	
<div align="center">

		<h1>Create New Pet</h1>
		<br/>
		  <span>${error}</span>
	<form:form action="save" method="post"  modelAttribute="petForm" novalidate="novalidate">
     <table>
			<tr>
				<td>Pet Name:</td>
				<td><form:input path="petName" /></td>
			</tr>
			<tr>
				<td>Pet Age:</td>
				<td><form:input path="petAge" /></td>
				<%-- <font color="red"><form:errors path="age" /></font> --%>
			</tr>
			<tr>
				<td>Pet Place:</td>
				<td><form:input path="petPlace" /></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="Add Pet" /></td>
				<td><input type="reset" value="Cancel" /></td>
			</tr>
		</table>

      </form:form>
      </div>
</div>

     <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>