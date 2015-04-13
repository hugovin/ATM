<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To ATM </title>
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/css/signin.css' />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">

		<form class="form-signin" id="loginForm">
			<h2 class="form-signin-heading">Type your Pin</h2>
			<label for="inputPin" class="sr-only">Pin =</label> 
			<input type="password" id="inputPin"  data-bind="value : pin" class="form-control"
				placeholder="1234" required="" autofocus="">
			<button class="btn btn-lg btn-primary btn-block"  data-bind="click : doLogin" type="button">Go</button>
			<p class="bg-danger" data-bind="text: error"></p>
			
		</form>

	</div>
	<!-- Scripts -->
	<script src="<c:url value ="/resources/js/knockout-3.3.0.js" />"
		type="text/javascript"></script>
		<script src="<c:url value ="resources/js/jquery-2.1.0.min.js"/>"
		type="text/javascript"></script>
		<script src="<c:url value ="/resources/js/knockout.validation.min.js" />"
		type="text/javascript"></script>
	<script src="<c:url value ="/resources/js/signin.js" />"
		type="text/javascript"></script>

</body>
</html>