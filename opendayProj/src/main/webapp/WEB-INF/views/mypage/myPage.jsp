<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/user/mypage.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>
<body>
	<div id=wrap>
	
		<h2>마이페이지</h2>
		<div class="sec1">
			<div class="mybox1 square">
				<div class="myprofile-pic">
					<p>이미지</p>
					<P>성빈찡v</P>
				</div>
				<div class="myprofile">
					<div class="border-bottom">
						<p class="mymenu1">이메일</p>
						<p class="mymenu2">tjdqls111@gmail.com</p>
					</div>
					<div class="border-bottom">
						<p class="mymenu1">전화번호</p>
						<p class="mymenu2">010-5480-6972</p>
					</div>
					<div>
						<button class="myprofile-btn" type="button">프로필 수정하기</button>
					</div>
				</div>
			</div>
			<a href="">
				<div class="mybox2 square">
					<div class="mymenu-txt">
						<span class="material-symbols-outlined">
							face_retouching_natural </span>
						<p class="mymenu1">클래스 개설</p>
						<p class="mymenu2">열어데이의 강사님이 되어보세요</p>
					</div>
				</div>
			</a>
		</div>
		<div class="sec2">
			<a href="myprefer">
				<div class="mybox3 square">
					<div class="mymenu-txt">
						<span class="material-symbols-outlined"> star </span>
						<p class="mymenu1">선호 카테고리</p>
						<p class="mymenu2">선호에 맞는 클래스를 추천해 드릴게요</p>
					</div>
				</div>
			</a> <a href="myheart">
				<div class="mybox4 square">
					<div class="mymenu-txt">
						<span class="material-symbols-outlined"> favorite </span>
						<p class="mymenu1">찜한 클래스</p>
						<p class="mymenu2">내가 찜한 클래스</p>
					</div>
				</div>
			</a> <a href="reservedrecord">
				<div class="mybox5 square">
					<div class="mymenu-txt">
						<span class="material-symbols-outlined"> calendar_add_on </span>
						<p class="mymenu1">예약/결제 내역</p>
						<p class="mymenu2">신청한 클래스의 정보를 확인하세요</p>
					</div>
				</div>
			</a> <a href="myfollow">
				<div class="mybox6 square">
					<div class="mymenu-txt">
						<span class="material-symbols-outlined"> thumb_up </span>
						<p class="mymenu1">팔로우 목록</p>
						<p class="mymenu2">팔로우한 강사님들을 모아보세요</p>
					</div>
				</div>
			</a> <a href="">
				<div class="mybox7 square">
					<div class="mymenu-txt">
						<span class="material-symbols-outlined"> person_off </span>
						<p class="mymenu1">회원 탈퇴</p>
						<p class="mymenu2">열어데이 회원 탈퇴</p>
					</div>
				</div>
			</a> 
		</div>
		
		
	 
	 
<!-- 	 <script>
    $('.modal').click(function(event) {
      event.preventDefault();
 
      $(this).modal({
        fadeDuration: 250
      });
    });
</script>
 -->	 

</body>
</html>