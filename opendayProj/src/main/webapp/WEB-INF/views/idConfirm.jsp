<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/js/user/idConfirm.js"/>'></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/idConfirm.css"/>">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="idConfirmWrapper">
		<div class="idConfirmContentWrapper">
			<div class="idConfirmPageTitleWrapper">
				<p class="idConfirmPageTitle">아이디/비밀번호 찾기</p>
			</div>
			<ul class="findMenu">
				<li>아이디 찾기</li>
				<li class="pwFindMenu">비밀번호 찾기</li>
			</ul>
			 <div>
			 <p>${userName}님의 아이디는 ${userId}입니다.</p>
			 </div>
			<div class="idConfirmBtns">
				<button type="button" class="loginBtn">로그인하기</button>
				<button type="button" class="findPwBtn">비밀번호찾기</button>
			</div>

		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>