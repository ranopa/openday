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
<link rel="stylesheet"
	href="<c:url value="/resources/css/search/css/header.css"/>">

</head>
<body>

	<div class="headerWrapper">
		<div class="contentWrapper">
			<header>
				<ul class="topButtons">
					<li class="topButtonColor tB"><a href=#>강사신청</a></li>

					<li class="topButton tB"><a href=#>클래스요청</a></li>

					<li class="topButton tB tBLast"><a href=#>고객센터</a></li>

				</ul>
				<hr>
				<div class="logoMenu">
					<h1>
						<a href="#">열어데이</a>
					</h1>
					<div class="searchAndIcon">
						<input class="search" type="text" placeholder="검색어 입력"> <a
							href="#"><span class="material-symbols-outlined searchIcon">search</span></a>
					</div>
					<ul class="verticalAlign">
						<li><a href="#"><span
								class="material-symbols-outlined login"> person </span>
								<p>로그인</p></a></li>
						<li><a href="#"><span
								class="material-symbols-outlined menu"> menu </span>
								<p>메뉴</p></a></li>
					</ul>
				</div>





			</header>
		</div>
	</div>
	<div class="searchFilterWrapper">
		
		<div class="contentWrapper">
		<div class="filterUl1">
		<p>지역</p>
		<ul>
		<li>전체</li>
		<li>서울</li>
		<li>경기</li>
		<li>인천</li>
		<li>강원</li>
		<li>충북</li>
		<li>충남</li>
		<li>세종</li>
		<li>대전</li>
		<li>광주</li>
		<li>전북</li>
		<li>경북</li>
		<li>대구</li>
		<li>제주</li>
		<li>전남</li>
		<li>경남/울산</li>
		<li>부산</li>
		</ul>
		</div>
		<div class="filterUl2">
		<p>카테고리</p>
		<select name="category" id="category">
  <option value="javascript">JavaScript</option>
  <option value="python">Python</option>
  <option value="c++" disabled>C++</option>
  <option value="all" selected>전체</option>
</select>
		</div>
		
		</div>
	</div>
</body>
</html>