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
	<%@ include file="../header.jsp"%>
	<div class="loginWrapper">
		<div class="loginContentWrapper">
			<div class="loginPageTitleWrapper">

				<p class="loginPageTitle">로그인</p>
			</div>
			<form id="loginForm" action="login" method="post">
				<ul class="loginContainer">
					<li><input type="text" class="loginBox" id="userId"
						name="userId" placeholder="아이디"></li>
					<li><input type="password" class="loginBox pwBox"
						id="userPassword" name="userPassword" placeholder="비밀번호" ></li>
				</ul>

				<ul class="loginPageFind">
					<li><a href="findid">아이디 찾기</a></li>
					<li class="pwFindMenu"><a href="findpw">비밀번호 찾기</a></li>
				</ul>

				<div class="loginPageBtns">
					<input type="submit" class="loginBtn" value="로그인"> <input
						type="button" class="joinBtn" value="회원가입">
				</div>


			</form>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>