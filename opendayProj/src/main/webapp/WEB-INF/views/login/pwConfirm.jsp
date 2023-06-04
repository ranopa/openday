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
	<%@ include file="../header.jsp"%>
	<div class="idConfirmWrapper">
		<div class="idConfirmContentWrapper">
			<div class="idConfirmPageTitleWrapper">
				<p class="idConfirmPageTitle">아이디/비밀번호 찾기</p>
			</div>
			<ul class="findMenu">
				<li><a href="findid">아이디 찾기</a></li>
				<li class="pwFindMenu"><a href="findpw">비밀번호 찾기</a></li>
			</ul>
			 <c:choose>
        <c:when test="${not empty user}">
            <p>비밀번호가 성공적으로 변경되었습니다.</p>
            <p>새 비밀번호는 이메일로 전송되었습니다.</p>
        </c:when>
        <c:otherwise>
            <p>비밀번호 변경에 실패하였습니다.</p>
            <p>유효한 이메일 주소를 입력하였는지 확인해주세요.</p>
        </c:otherwise>
    </c:choose>

			<div class="idConfirmBtns">
				<button type="button" class="loginBtn">로그인하기</button>
				<button type="button" class="findPwBtn">비밀번호찾기</button>
			</div>

		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>