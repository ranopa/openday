<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>열어데이 - 강사페이지</title>
<!-- 값 제어를 위해 jquery -->
<script src="resources/js/teacher/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/teacher/teacher.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<div class="tc-main">
		<jsp:include page="tcHaeder.jsp" />
		<div class="tc-container">
			<div class="tc-maintop">
				<span class="tc-mainTitle">강사페이지</span>
			</div>
			<hr>
			<div class="tc-dashboard">
				<div class="tc-dashboard-list">
					<div>총 누적 정산액</div>
					<div>0</div>
				</div>

				<div class="tc-dashboard-list">
					<div>이번 달 판매금액</div>
					<div>0</div>
				</div>

				<div class="tc-dashboard-list">
					<div>운영중인 클래스</div>
					<div>0</div>
				</div>

				<div class="tc-dashboard-list">
					<div>후기 수</div>
					<div>0</div>
				</div>

				<div class="tc-dashboard-list">
					<div>평점</div>
					<div>0</div>
				</div>

				<div class="tc-dashboard-list">
					<div>승인 대기중인 클래스</div>
					<div>0</div>
				</div>
			</div>
			<div class="tc-announcement">
				<h2 class="tc-announcement-title">공지사항</h2>
				<hr>
				<table class="tc-announcement-table">
					<colgroup>
						<col width="5%" />
						<col width="80%" />
						<col width="10%" />
					</colgroup>
					<c:forEach items="${tcAnlist }" var="tcAnlist">
						<tr>
							<td>공지</td>
							<td>${tcAnlist.ancTitle }</td>
							<td>${tcAnlist.ancUploadDate }</td>
						</tr>
					</c:forEach>
				</table>
				<div class="dataNon">${err }</div>
			</div>
		</div>

	</div>
	
	
</body>
</html>