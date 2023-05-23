<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">

</head>
<body>
	<hr>
	<div class="contentWrapper">
		<header>
			<ul class="topButtons">
				<li class="topButtonColor tB">강사신청</li>
				<hr class="vertical">
				<li class="topButton tB">클래스요청</li>
				<hr class="vertical">
				<li class="topButton tB">고객센터</li>
				<hr class="vertical">
			</ul>
			<div class="logo-menu">
				<h1>열어데이</h1>

				<div class="search">검색</div>
				<span class="material-symbols-outlined search-icon">search</span>

				<ul class="vertical-align">
					<li><span class="material-symbols-outlined login">
							person </span>
						<p>로그인</p></li>
					<li><span class="material-symbols-outlined menu"> menu
					</span>
						<p>메뉴</p></li>
				</ul>
			</div>




			<div>
				<div class="menuIcon"></div>
				<span>메뉴</span>
			</div>
		</header>
	</div>

</body>
</html>