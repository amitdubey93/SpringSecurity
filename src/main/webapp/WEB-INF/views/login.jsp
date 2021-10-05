<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<div class="container p-4">
		<div style="width:40%;margin: auto;">
			<form:form class="m-auto">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger" role="alert">Invalid
						Username or password !!</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-info" role="alert">Invalid
						You're successfully logged out. Sign in again !!</div>
				</c:if>
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" name="username">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>