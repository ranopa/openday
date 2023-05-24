<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/login.css"/>">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="loginWrapper">
		<div class="loginContentWrapper">
			<div class="loginPageTitleWrapper">
				<p class="loginPageTitle">로그인</p>
			</div>
			<ul class="loginContainer">
				<li><input type="text" class="loginBox" id="loginUserId"
					name="loginUserId" placeholder="아이디" required maxlength="15">
					<!-- <input type="button" class="loginIdcheck loginCk" id="idCheckBtn"
					value="중복확인">
					 --></li>
				<li><input type="password" class="loginBox pwBox"
					id="loginUserPassword" name="loginUserPassword" placeholder="비밀번호"
					required maxlength="15"></li>
			</ul>

			<ul class="loginPageFind">
				<li>아이디 찾기</li>
				<li>비밀번호 찾기</li>
			</ul>

			<div class="loginPageBtns">
				<button type="submit" class="loginBtn">로그인</button>
				<button type="button" class="joinBtn">회원가입</button>
			</div>
			<!-- 
			<div class="loginBtns">
				<button type="button" class="cancel-btn">취소</button>
				<button type="submit" class="submit-btn">가입완료</button>
			</div>

 -->
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>