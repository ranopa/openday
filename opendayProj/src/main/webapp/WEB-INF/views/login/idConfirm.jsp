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
			
			<div class="findUserIdInfo">
					<p>${findId.userName}님의 아이디는 ${findId.userId} 입니다.</p>
				</div>
			
			<%-- 아이디 찾기 결과 --%>
			<%-- <c:if test="${requestScope.menu eq 'id'}">
				<div class="findUserIdInfo">
					<p>${findId.userName}님의아이디는${findId.userId}입니다.</p>
				</div>
			</c:if>
 --%>
			<%-- 비밀번호 찾기 결과 --%>
				
	<%-- 		<c:if test="${requestScope.menu eq 'pw'}">
		
				<div class="findUserIdInfo">
					<p>${findId.userName}님의비밀번호는${userPassword}입니다.</p>
				</div>
			</c:if>

 --%>			<!-- 아래부분 낫이퀄로 바꾸기 -->
	<%-- 		<c:if test="${requestScope.menu eq 'pw'}">
				<div class="findUserIdInfo">
				
					<p>해당하는 정보를 찾을 수 없습니다.</p>
			
			
				</div>
			</c:if>
 --%>

			<div class="idConfirmBtns">
				<button type="button" class="loginBtn">로그인하기</button>
				<button type="button" class="findPwBtn">비밀번호찾기</button>
			</div>

		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>