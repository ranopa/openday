<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/js/user/findId.js"/>'></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/findId.css"/>">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="findIdWrapper">
		<div class="findIdContentWrapper">
			<div class="findIdPageTitleWrapper">
				<p class="findIdPageTitle">아이디/비밀번호 찾기</p>
			</div>
			<ul class="findMenu">
				<li><a href="findid">아이디 찾기</a></li>
				<li class="pwFindMenu"><a href="findpw">비밀번호 찾기</a></li>
			</ul>
			<form type="text" action="findid" method="post">
			<ul class="findIdContainer">
				<li><input type="text" class="findIdPEmailBox"
					id="findIdEmailBox" name="userEmail" placeholder="이메일"
					required maxlength="15"></li>
				<div class="AuthenticationNumberWrapper">
				<!-- 	<li><input type="text" class="AuthenticationNumberBox"
						id="AuthenticationNumberBox" name="AuthenticationNumberBox"
						placeholder="인증번호" required maxlength="15"> <input
						type="button" class="AuthenticationNumber"
						id="AuthenticationNumber" value="인증번호 전송"></li> -->
				</div>
			</ul>


			<div class="findIdBtns">
				<input type="submit" class="findIdBtn" value="확인">
			</div>
			
			</form>
			<!-- 
			<div class="loginBtns">
				<button type="button" class="cancel-btn">취소</button>
				<button type="submit" class="submit-btn">가입완료</button>
			</div>

 -->
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>