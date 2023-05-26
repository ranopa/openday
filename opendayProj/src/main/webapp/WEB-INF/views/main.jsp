<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
<script src='<c:url value="/resources/js/user/main.js"/>'></script>
<link rel="stylesheet" href="<c:url value="/resources/css/user/main.css"/>">

<!-- 일단 임시로 넣어줌 아이콘 문제임 -->
<link rel="shortcut icon" href="#">
</head>
<body>
	<div id="includeWrapper">
		<div id="includeHeader" class="includeHeader">
			<%@ include file="header.jsp"%>
		</div>
		<div id="includeContent" class="includeContent">
			<%@ include file="mainContent.jsp"%>
		</div>
		<div id="includeFooter" class="includeFooter">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>