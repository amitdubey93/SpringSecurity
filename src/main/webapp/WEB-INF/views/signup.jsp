<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<title>Sign Up Form</title>
</head>
<body>
<%@ include file="./header.jsp" %>
	<div class="container p-4">
		<h2 class="text-center">Signup Form</h2>
		<div style="width: 80%; margin: auto;">
			<form:form action="process-signup" method="POST"
				modelAttribute="signupdto">
				<%-- <c:if test="${param.error != null}">
					<div class="alert alert-danger" role="alert">Invalid
						Username or password !!</div>
				</c:if> --%>
				<div class="form-row">
					<div class="form-group col-sm-6 col-md-4">
						<label for="firstname">Firstname</label>
						<form:input path="firstname" cssClass="form-control" />
					</div>
					<div class="form-group col-sm-6 col-md-4">
						<label for="lastname">Lastname</label>
						<form:input path="lastname" cssClass="form-control" />
					</div>
					<div class="form-group col-sm-6 col-md-4">
						<label for="email">Email</label>
						<form:input path="email" cssClass="form-control" />
					</div>
					<div class="form-group col-sm-6 col-md-4">
						<label for="mobile">Mobile</label>
						<form:input path="mobile" cssClass="form-control" />
					</div>
					<div class="form-group col-sm-6 col-md-4">
						<label for="username">Username</label>
						<form:input path="username" cssClass="form-control" />
					</div>
					<div class="form-group col-sm-6 col-md-4">
						<label for="password">Password</label>
						<form:input path="password" cssClass="form-control" />
					</div>
					
				</div>
				<button type="submit" class="btn btn-primary">SignUp</button>
			</form:form>
		</div>	
	</div>
</body>
</html>