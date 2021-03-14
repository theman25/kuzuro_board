<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- <%@ page session="false" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
		
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js">
</head>
<body>
<!-- <div id="root"> -->
<div id="container">
	<div id="header">
		<%@ include file="./include/header.jsp" %>
	</div>
	<div id="nav">
		<%@ include file="./include/nav.jsp" %>
	</div>
	
	<div class="main">
		<div style="text-align:center;">
			<h3>home page</h3>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="./include/footer.jsp" %>
	</div>
</div>
</body>
</html>
