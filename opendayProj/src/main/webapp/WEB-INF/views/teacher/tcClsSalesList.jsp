<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>열어데이 - 강사페이지</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/teacher/teacher.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="resources/css/teacher/datepicker.min.css" rel="stylesheet"
	type="text/css" media="all">
<!-- 값 제어를 위해 jquery -->
<script src="resources/js/teacher/jquery-3.1.1.min.js"></script>
<!-- Air datepicker css -->
<script src="resources/js/teacher/datepicker.js"></script>
<script src="resources/js/teacher/datepickerSetting.js"></script>
<!-- Air datepicker js -->
<script src="resources/js/teacher/datepicker.ko.js"></script>
<!-- 달력 한글 추가를 위해 커스텀 -->
</head>
<body>
	<div class="tc-main">
		<jsp:include page="tcHaeder.jsp" />
		<div class="tc-container">
			<div class="tc-maintop">
				<span class="tc-mainTitle">강사페이지</span>
			</div>
			<hr>
			<div class="tc-classList">
				<div class="tc-sales">
					<h3>정산 관리</h3>
					<div class="tc-sales-tot">
						<div>정산 완료 총 수익금</div>
						<div>0 원</div>
					</div>
				</div>
				<div>
					<h3>정산 신청 내역</h3>
					<c:forEach items="${tcSaleslist }" var="tcSaleslist">
						<div class="tc-sales-list">
							<div>
								<span>${tcSaleslist.saStatus }</span>
								<span>${tcSaleslist.saSettleAmount } 원</span>
							</div>
							<div>
								<div>신청일</div>
								<div>${tcSaleslist.saAppDate }</div>
							</div>
							<div>
								<div>예상 지급일</div>
								<div>${tcSaleslist.estimatedPaymentDate }</div>
							</div>
							<div>예금주 : ${tcSaleslist.userName } | 정산계좌 : ${tcSaleslist.userAccount }</div>
						</div>
					</c:forEach>
				</div>
				
			</div>
		</div>

	</div>
</body>
</html>
