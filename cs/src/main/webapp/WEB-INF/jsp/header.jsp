<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">PetShop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class=""><a href="home">Home</a></li>
      <c:if test="${sessionScope.user !=null }"> 
      <li><a href="userPet">My Pet</a></li>
      <li><a href="newPet">Add Pet</a></li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <c:if test="${sessionScope.user ==null}"> 
      <li><a href = "registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="signin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
  <c:if test="${sessionScope.user!=null}"> 
     <li>    <a href="viewProfile"><span class="glyphicon glyphicon-user"></span>Welcome ${sessionScope.user.userName}{${sessionScope.user.roles[0].name}}</a> </li>
      
     <li>    <a href="logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a> 
    </li>
  </c:if>
    </ul>
  </div>
</nav>

