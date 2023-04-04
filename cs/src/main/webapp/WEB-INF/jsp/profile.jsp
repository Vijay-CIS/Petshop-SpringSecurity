<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<div class="container-fluid">
		<jsp:include page="header.jsp"></jsp:include>

	</div>
	<div align="container-fluid">
		<div align="center">

			<h1>Profile</h1>
			<br /> <span>${error}</span>
			<form:form action="updateProfile" method="post"
				modelAttribute="profileForm" novalidate="novalidate">
				<table>
					<tr>
						<td>User Id:</td>
						<td><form:input path="userId" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>User Name:</td>
						<td><form:input path="userName" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:input path="userPassword" /></td>

					</tr>

					<tr>
						<td>Roles:</td>
						<td><spring:bind path="roles">
								<div class="form-group ${status.error ? 'has-error' : ''}">

									<form:checkbox path="roles" value="1" />
									ADMIN
									<form:checkbox path="roles" value="2" />
									USER
								</div>
							</spring:bind></td>

					</tr>


					<tr>
						<td><input type="submit" value="Update Profile" /></td>
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