<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="<c:url value="/resources/css/search/header.css"/>">

</head>
<body>
	<hr>
	<div class="headerWrapper">
	<div class="contentWrapper">
		<header>
			<ul class="topButtons">
				<li class="topButtonColor tB"><a href=#>강사신청</a></li> 
				
				<li class="topButton tB"><a href=#>클래스요청</a></li>
				
				<li class="topButton tB tBLast"><a href=#>고객센터</a></li>
			
			</ul>
			<div class="logo-menu">
				<h1><a href="#">열어데이</a></h1>
				<div class="search-and-icon">
				<input class="search" type="text" placeholder="검색어 입력">
				<a href="#"><span class="material-symbols-outlined search-icon">search</span></a>
				</div>
				<ul class="vertical-align">
					<li><a href="#"><span class="material-symbols-outlined login">
							person </span>
						<p>로그인</p></a></li>
					<li><a href="#"><span class="material-symbols-outlined menu"> menu
					</span>
						<p>메뉴</p></a></li>
				</ul>
			</div>




			
		</header>
	</div>
	
<!-- 	<div class="search-filter">
	검색필터
	</div> -->
	
	
	</div>
</body>
</html>