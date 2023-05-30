<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="<c:url value="/resources/js/user/jquery-3.3.1.js"/>"></script>

<script src='<c:url value="/resources/js/user/header.js"/>'></script>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/header.css"/>">
<!-- 달력 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/header.css"/>">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 에이작스 밑에 쓰기 -->
<script>
/* $(function){
	#.ajax({
		url:category
	})
} */
</script>
</head>
<body>

	<div class="headerWrapper">
		<div class="contentWrapper">
			<header>
				<ul class="topButtons">
					<c:set var="userId" value="${sessionScope.userId}" />
					<!-- <li class="nickname">닉네임</li> -->
					<c:choose>
						<c:when test="${userId eq null}">
							<li class="logoutButton"></li>
						</c:when>
						<c:otherwise>
							<b><c:out value="${userId.userNickname}" /></b>

							<li class="logoutButton"><a href="logout"><button>로그아웃</button></a></li>
						</c:otherwise>
					</c:choose>


					<li class="topButtonColor tB topButtonsMargin"><a href=#>강사신청</a></li>

					<li class="topButton tB topButtonsMargin"><a href=#>클래스요청</a></li>

					<li class="topButton tB tBLast topButtonsMargin"><a href=#>고객센터</a></li>

				</ul>
		</div>
		<hr class="hr1">
		<div class="contentWrapper">
			<div class="logoMenu">
				<h1 class="logo">
					<a href="#">열어데이</a>
				</h1>
				<form type="text" action="search" method="get">
					<div class="searchAndIcon">

						<input class="search" type="text" onclick="dis()"
							placeholder="검색어 입력"> <a href="subClassList"><span
							class="material-symbols-outlined searchIcon">search</span></a>
					</div>
				</form>
				<ul class="verticalAlign">
					<li><a href="#"><span
							class="material-symbols-outlined alarm"> notifications </span>
							<p>알림</p></a></li>
					<c:set var="userId" value="${sessionScope.userId }" />
					<c:choose>
						<c:when test="${userId eq null}">
							<li><a href="loginform"><span
									class="material-symbols-outlined login"> person </span>
									<p>로그인</p></a></li>
						</c:when>
						<c:otherwise>

							<li><a href="loginform"><span
									class="material-symbols-outlined login"> person </span>
									<p>마이</p></a></li>
						</c:otherwise>
					</c:choose>

					<li id="menu" onclick="disMenu()"><a href="#"><span
							class="material-symbols-outlined menu"> menu </span>
							<p>카테고리</p></a></li>
				</ul>
			</div>





			</header>
		</div>
		<hr class="hr2">
	</div>
	<form type="text" action="search" method="get">
		<div id='dis' class="searchFilterWrapper">

			<div class="contentWrapper">
				<div class="filterUl1">
					<p class="filterUlTitle">지역</p>
					
						<input type="radio" name="scdLoc" value="all" checked/>전체
						<input type="radio" name="scdLoc" value="서울" />서울
						<input type="radio" name="scdLoc" value="경기" />경기
						<input type="radio" name="scdLoc" value="인천" />인천
						<input type="radio" name="scdLoc" value="강원" />강원
						<input type="radio" name="scdLoc" value="충북" />충북
						<input type="radio" name="scdLoc" value="충남" />충남
						<input type="radio" name="scdLoc" value="세종" />세종
						<input type="radio" name="scdLoc" value="대전" />대전
						<input type="radio" name="scdLoc" value="광주" />광주
						<input type="radio" name="scdLoc" value="전북" />전북
						<input type="radio" name="scdLoc" value="경북" />경북
						<input type="radio" name="scdLoc" value="대구" />대구
						<input type="radio" name="scdLoc" value="제주" />제주
						<input type="radio" name="scdLoc" value="전남" />전남
						<input type="radio" name="scdLoc" value="경남/울산" />경남/울산
						<input type="radio" name="scdLoc" value="부산" />부산
					

				</div>
				 
				<div class="filterUl2">
					<p class="filterUlTitle">카테고리</p>
					<select name="clsCode" id="category">
						<option value="all" selected>전체</option>
						<c:forEach items="${codeList}" var="code">
							<option value="${code.codNum}">${code.codName}</option>

						</c:forEach>

					</select>
				</div>
				<!-- 검색 필터 달력 -->
				<div class="filterUl3">
					<p class="filterUlTitle">요일</p>
					<div class="container px-1 px-sm-5 mx-auto searchDatepicker">
						<form autocomplete="off searchDatepickerForm">
							<div class="searchDatepickerDiv">
								<div class="col-lg-6 col-11">
									<div class="input-group input-daterange">
										<input type="text" class="form-control input1"
											name="startDate" placeholder="Start Date" readonly>
										<input type="text" class="form-control input2" name="endDate"
											placeholder="End Date" readonly>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>


				<!-- <div class="filterUl3">
				<p class="filterUlTitle">요일</p>
<div class="container px-1 px-sm-5 mx-auto searchDatepicker">
  <form autocomplete="off">
    <div class="flex-row d-flex justify-content-center">
      <div class="col-lg-6 col-11">
        <div class="input-group input-daterange">
          <input type="text" class="form-control input1" placeholder="Start Date" readonly>
          <input type="text" class="form-control input2" placeholder="End Date" readonly>
        </div>
      </div>
    </div>
  </form>
</div>
</div>-->
				<!-- 달력코드끝 -->
				<!-- <div class="filterUl3">
				<p class="filterUlTitle">요일</p>
				<button type="button" class="multiSelectButton"
					onclick="toggleSelection(this)">월</button>
				<button type="button" class="multiSelectButton"
					onclick="toggleSelection(this)">화</button>
				<button type="button" class="multiSelectButton"
					onclick="toggleSelection(this)">수</button>
				<button type="button" class="multiSelectButton"
					onclick="toggleSelection(this)">목</button>
				<button type="button" class="multiSelectButton"
					onclick="toggleSelection(this)">금</button>
				<button type="button" class="multiSelectButton"
					onclick="toggleSelection(this)">토</button>
				<button type="button" class="multiSelectButton"
					onclick="toggleSelection(this)">일</button>
			</div>
 -->
				<div class="searchFilterButton">
					<button type="button" class="refresh" onclick="resetFilters()">
						<span class="material-symbols-outlined"> refresh </span>
						<p>초기화</p>
					</button>



					<input type="submit" class="searchButton" value="검색">

				</div>
			</div>
		</div>
	</form>

	<div id='disMenu' class="menuWrapper">
		<div class="contentWrapper">
			<table class="mainMenuTable">
				<c:forEach items="${codeList}" var="code" varStatus="loop">
					<c:if test="${loop.index % 5 == 0}">
						<tr>
					</c:if>
					<c:if test="${loop.index == 0}">
						<td>
							<button type="button" class="mainCategoryButton"
								name="categoryButton" value="all">전체</button>
						</td>
					</c:if>
					<c:if test="${loop.index > 0 and loop.index <= 4}">
						<td>
							<button type="button" class="mainCategoryButton"
								name="categoryButton" value="${code.codNum}">${code.codName}</button>
						</td>
					</c:if>
					<c:if test="${loop.index > 4}">
						<td>
							<button type="button" class="mainCategoryButton"
								name="categoryButton" value="${code.codNum}">${code.codName}</button>
						</td>
					</c:if>
					<c:if test="${loop.index % 5 == 4 or loop.last}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>


</body>
</html>