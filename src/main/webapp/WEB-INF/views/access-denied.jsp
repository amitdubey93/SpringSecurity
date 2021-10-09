<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="page-wrap d-flex flex-row align-items-center">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-12 text-center">
					<span class="display-1 d-block">Access denied</span>
					<div class="mb-4 lead">You're not allowed to view this url.</div>
					<a href="/springsecurity/user-dashboard" class="btn btn-link">Back
						to Dashboard</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>