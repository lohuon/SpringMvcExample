<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
	<link rel="stylesheet" href="<spring:url value='/resources/vendor/bootstrap/css/bootstrap.min.css' />">
	<link rel="stylesheet" href="<spring:url value='/resources/vendor/bootstrap/css/bootstrap-theme.min.css' />">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<p><span class="glyphicon glyphicon-home"></span> Welcome to testproject version ${version}. </p>

</body>
<script type="text/javascript" src="<spring:url value='/resources/vendor/jquery/jquery-2.2.4.min.js' />" ></script>
<script type="text/javascript" src="<spring:url value='/resources/vendor/bootstrap/js/bootstrap.min.js' />" ></script>

</html>
