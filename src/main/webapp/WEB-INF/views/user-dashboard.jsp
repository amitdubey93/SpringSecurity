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
<title>Dashboard</title>
</head>
<body>
	<%@ include file="./header.jsp"%>
	<a class="btn btn-danger" href="<c:url value="/deleteUser?username=${username}" />">Delete Account</a>
	<div>
		Hi ${username}
		<br>
		roles ${authorities}
	</div>

</body>
</html>