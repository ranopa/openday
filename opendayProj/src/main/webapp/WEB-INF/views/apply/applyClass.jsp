<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%=request.getContextPath() %>" />
<html>
<head>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
	<link rel="stylesheet" href="${contextPath}/resources/css/user/applyClass.css">
	<script src="${contextPath }/resources/js/user/applyClass.js"></script>
</head>
<body>
	<div class="wrapper">
		<div class="header-title">클래스 신청</div>
		<div class="container">

			<div class="box">
				<div class="class-image-card">이미지</div>
				<div class="class-detail">
					<h4>${oclass.clsName }</h4>

					<div class="detail-bottom">
						<span>카테고리</span> <span>${oclass.clsCode }</span>
					</div>
				</div>

			</div>
			<div class="box">
				<div class="apply-date-calendar">
					날짜 선택 - 캘린더
					<div class="class-calendar">
						<div id="datepicker"></div>
					</div>

				</div>
				<div class="apply-date-hour">
					<p>시간 선택 - 드롭다운</p>

					<select>
						<option>시간을 선택하세요</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>

					</select>
				</div>
			</div>
			<div class="box">
				<div class="apply-people-count">
					신청 인원 수 입력 - 카운터 <input type="number" min="1" max="100" value="1" />
				</div>
			</div>
			<div class="box">
				<div class="btn-wrapper">
					<button class="btn-next">다음으로</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
