<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/registration" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="userName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="userName" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="userName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="userPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="userPassword" class="form-control" placeholder="Password"></form:input>
                <form:errors path="userPassword"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="confirmPassword"></form:errors>
            </div>
        </spring:bind>

        
        <spring:bind path="roles">
            <div class="form-group ${status.error ? 'has-error' : ''}">
              
               <form:checkbox path="roles" value="1" />ADMIN
                <form:checkbox path="roles" value="2" />USER
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>