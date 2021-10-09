<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<form:form method="post" action="logout">
	<input type="submit" value="Logout" class="btn btn-info ml-3">
</form:form>

<script>
	function myFunction() {
		const theUrl = "/springsecurity/deleteUser?username=${username}";
		var txt;
		var r = confirm("Are you sure you want to delete your account???");
		if (r == true) {
			txt = "You pressed OK!";
			alert(theUrl);
			var response = httpGet(theUrl);
			if(response == 'success'){
				location.assign('/springsecurity/home');
			}
		} else {
			txt = "You pressed Cancel!";
		}
		document.getElementById("demo").innerHTML = txt;
		
	}

	
	function httpGet(theUrl) {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", theUrl, false); // false for synchronous request
		xmlHttp.send(null);
		//alert(xmlHttp.responseText);
		return xmlHttp.responseText;
	}
</script>
