<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Spring Security</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/user-dashboard" />">Dashboard</a>
      </li>
      <sec:authorize access="hasAuthority('USER')">
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value="/user" />">User</a>
	      </li>
      </sec:authorize>
      <sec:authorize access="hasAuthority('ADMIN')">
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value="/admin" />">Admin</a>
	      </li>
      </sec:authorize>
      <sec:authorize access="!hasAuthority('USER')">
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value="/login" />">Login</a>
	      </li>
      </sec:authorize>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/signup" />">Signup</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value="/denyall" />">DENYALL</a>
      </li>	
    </ul>
    <a class="nav-link" href="<c:url value="/change-password" />">Change Password</a>
    <!--this is not working  -->
    <%-- <c:if test="${param.logout==null}">
    <%@ include file="./logout.jsp" %>
    </c:if> --%>
    
  </div>
</nav>