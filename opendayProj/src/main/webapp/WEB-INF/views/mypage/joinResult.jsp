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
<style >
</style>
<body>
	<%@ include file="../header.jsp"%>
	<div id="join-result">
		<div class="idConfirmWrapper">
			<div class="idConfirmContentWrapper">
				<div class="idConfirmPageTitleWrapper">
					<p class="idConfirmPageTitle">회원가입 완료</p>
				</div> 

				<div class="findUserIdInfo">
					<p>회원가입이 완료되었습니다!</p>
					<p>열어데이이의 다양한 원데이 클래스를 즐겨보세요!</p>
				</div>
				<div class="idConfirmBtns">
					<a href="./"><button type="button" class="loginBtn">로그인하기</button></a>
				</div>
			</div>
		</div>
		<%@ include file="../footer.jsp"%>
</body>
</html>