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

	<div class="container p-4">
		<h2>Signup Form</h2>
		<div style="width: 40%; margin: auto;">
			<form:form action="process-signup" method="POST"
				modelAttribute="signupdto">
				<%-- <c:if test="${param.error != null}">
					<div class="alert alert-danger" role="alert">Invalid
						Username or password !!</div>
				</c:if> --%>
				<div class="form-group">
					<label for="username">Username</label>
					<form:input path="username" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<form:input path="password" cssClass="form-control" />
				</div>
				<button type="submit" class="btn btn-primary">SignUp</button>
			</form:form>
		</div>
	</div>
</body>
</html>