<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
version 1 // main
version 1-1 // b1
</h1>
<h3>testtesttest</h3>
<h2>
version 2 // b2
</h2>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<c:url value="/resources/search/css/main.css"/>">
</head>
<body bgcolor='yellow'>
<%@ include file="header.jsp" %>
<div class="mainBg">
<div class="mainWrapper">
<p>도자기</p>
<p>가죽</p>
<p>도자기</p>
<p>도자기</p>
<p>도자기</p>
<p>도자기</p>
<p>도자기</p>
</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
