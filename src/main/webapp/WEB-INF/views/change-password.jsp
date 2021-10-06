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
		<h2 class="text-center">Change password</h2>
		<div style="width: 40%; margin: auto;">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger" role="alert">
					${param.error}</div>
			</c:if>
			<form:form action="process-change-password" method="POST"
				modelAttribute="cpdto">
				<div class="form-group">
					<label for="oldPassword">Old Passowrd</label>
					<form:input path="oldPassword" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label for="newPassword">New Password</label>
					<form:input path="newPassword" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label for="confirmPassword">Confirm Password</label>
					<form:input path="confirmPassword" cssClass="form-control" />
				</div>
				<button type="submit" class="btn btn-primary">SignUp</button>
			</form:form>
		</div>
	</div>
</body>
</html>