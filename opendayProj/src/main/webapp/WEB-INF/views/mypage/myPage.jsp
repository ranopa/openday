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



<script>
window.onload=function(){
    var modalBtn = document.querySelector("#profile-edit-btn");
    var modalEl = document.querySelector(".modal");
	var	cancelBtn = document.querySelector(".cancel-btn");
    
    modalBtn.addEventListener('click',()=>{
        if(!modalEl.classList.contains('hide')){
           modalEl.classList.add("hide"); 
        }
    })
    
    cancelBtn.addEventListener('click',()=>{
        if(modalEl.classList.contains('hide')){
        	modalEl.classList.remove('hide');
        }    	
    })
}
</script>
<style>

.m-h2 {
	color: rgb(98, 22, 168);
	margin-top:-2px;
	margin-left:13px;
}

.m-container {
	width: 450px;
	height: 650px;
	background-color: rgb(255, 255, 255);
	position: fixed;
	margin: auto;
	right: 0;
	left: 0;
	top: 0;
	bottom: 0;
	border-radius: 7px;
	padding: 15px;
}

.textbox {
	margin-top: 10%;
	width: 100%;
	margin-left: 15px;
}

.picture {
	border-radius: 50%;
	width: 139px;
	height: 139px;
	background-color: rgb(231, 231, 231);
	margin: 0 auto; 
	margin-bottom: 20px;
}

.edit-btn {
	width: 160px;
	height: 35px;
	border-radius: 3px;
	border: solid 1px rgba(124, 124, 124, 0.5);
	text-align: center;
	margin-top: 5px;
	font-size: 14px;
	color: rgba(129, 129, 129, 1);
	background-color: #f7f7f7;
	cursor: pointer;
}

.edit-btn:hover {
	background-color: rgba(223, 223, 223, 0.5);
}

.pf-box {
	width: 100%;
	display: flex;
	align-items: center;
	flex-direction: column;
}

.ipbox {
	padding-left: 10px;
	box-sizing: border-box;
	width: 300px;
	height: 43px;
	border-radius: 7px;
	margin-bottom: 10px;
	border: solid 1px rgba(124, 124, 124, 0.5);
	/* j쿼리로 outline solid 1px 색 지정*/
}

.ptxt {
	color: rgb(53, 53, 53);
	margin-bottom: 5px;
}

.txt1 {
	font-size: 15px;
	font-weight: bold;
}

.txt2 {
	margin-top: 13px;
	height: 50px;
	font-size: 15px;
}

.tel-check {
	cursor: pointer;
	margin-left: 10px;
	background-color: #f5f5f5;
	border-style: none;
	width: 100px;
	height: 40px;
	border-radius: 3px;
	border: solid 1px rgba(124, 124, 124, 0.5);
}

.tel-check:hover {
	background-color: rgba(223, 223, 223, 0.5);
}

.cs-btn {
	display: flex;
	justify-content: space-evenly;
	margin-top: 6%;
}

.submit-btn {
	box-sizing: border-box;
	width: 200px;
	height: 43px;
	background: #7C4AFF;
	border-radius: 7px;
	color: #fff;
	font-weight: bold;
	border-style: none;
	font-size: 14px;
	cursor: pointer;
}

.cancel-btn {
	box-sizing: border-box;
	width: 200px;
	height: 43px;
	background: #ffffff;
	border-radius: 7px;
	color: #7C4AFF;
	font-weight: bold;
	border-style: none;
	border: #7C4AFF 1px solid;
	cursor: pointer;
}

.modal {
	position: fixed;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	opacity: 0;
	visibility: hidden;
	transition: all .3s;
	z-index: 10;
}

.modal.hide {
	opacity: 1;
	visibility: visible;
}
</style>
</head>
<body>
	<!--모달  -->
	<div class="modal">
		<form action="/editprofile" method="post">
			<div class="m-wrap">
				<div class="m-container">
					<h2 class="m-h2">프로필 수정</h2>
					<div class="pf-box">
						<div class="picture"></div>
						<div class="center-box">
							<button type="button" class="edit-btn">프로필 사진 변경하기</button>
						</div>
					</div>
					<div class="textbox">
						<div class="e-box">
							<p class="txt1 ptxt">계정 ID</p>
							<p class="txt2 ptxt">tjdqls111@naver.com</p>
<!-- 							<p class="txt2 ptxt">${user.userId}</p> -->
						</div>
						<div class="e-box">
							<p class="txt1 ptxt">닉네임</p>
							<input type="text" class="ipbox">
						</div>
						<div class="e-box">
							<p class="txt1 ptxt">전화번호</p>
							<div class="e-box-tel">
								<input type="text" class="ipbox"> <input type="button"
									value="번호인증" class="tel-check">
							</div>
						</div>
					</div>
					<div class="cs-btn">
						<input type="button" value="취소" class="cancel-btn"> <input
							type="submit" value="수정" class="submit-btn">
					</div>
				</div>
			</div>
		</form>

	</div>
	<!--메인  -->
	<div id=wrap>

		<h2 class="my-h2">마이페이지</h2>
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
						<button id="profile-edit-btn" class="myprofile-btn" type="button">프로필
							수정하기</button>
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
	</div>




</body>
</html>