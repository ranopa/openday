<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/js/user/findPw.js"/>'></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/findPw.css"/>">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="findPwWrapper">
		<div class="findPwContentWrapper">
			<div class="findPwPageTitleWrapper">
				<p class="findPwPageTitle">아이디/비밀번호 찾기</p>
			</div>
			<ul class="findMenu">
				<li><a href="findid">아이디 찾기</a></li>
				<li class="pwFindMenu"><a href="findpw">비밀번호 찾기</a></li>
			</ul>
			<form type="text" action="findpw" method="post">
				<ul class="findPwContainer">
						<li>
							<input type="text" class="findPwPIdBox" id="findPwPIdBox"
							name="userId" placeholder="아이디">
						</li>

						<li>
							<input type="text" class="findPwPEmailBox"
							id="findPwEmailBox" name="userEmail" placeholder="이메일">
						</li>
					<div class="AuthenticationNumberWrapper">
						<li>
							<input type="text" class="AuthenticationNumberBox"
							id="AuthenticationNumberBox" name="AuthenticationNumberBox"
							placeholder="인증번호"> 
							<input type="button"
							class="AuthenticationNumber" id="AuthenticationNumber"
							value="인증번호 전송">
						</li>
					</div>
				</ul>



				<div class="findPwBtns">
					<input type="submit" class="findPwBtn" value="확인">
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