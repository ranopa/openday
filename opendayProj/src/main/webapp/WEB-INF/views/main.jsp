<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	
	<link rel="stylesheet" href="<c:url value="/resources/css/user/main.css"/>">
</head>
<body>
<div class="includeWrapper">
<%@ include file="header.jsp" %>
<div class="includeContent">
<%@ include file="mainContent.jsp" %>
</div>
<div class="includeFooter">
<%@ include file="footer.jsp" %>
</div>
</div>
</body>
</html>
