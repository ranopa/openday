<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	$(function() {
		$.datepicker.setDefaults({

			closeText : "닫기",
			currentText : "오늘",
			prevText : '이전 달',
			nextText : '다음 달',
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
			weekHeader : "주",
			yearSuffix : '년',
			showMonthAfterYear : true,
		});

		$("#datepicker").datepicker({
			beforeShowDay : function(date) {
				var currentDate = new Date();
				currentDate.setHours(0, 0, 0, 0); // 오늘 날짜의 시간을 00:00:00으로 설정
				if (date < currentDate) {
					return [ true, "past-date", "과거 날짜" ];
				}
				return [ true, "", "" ];
			}
		});
	});
</script>
<style>
/* ================== <캘린더> ================== */
.ui-datepicker {
	width: 80%;
	padding: 10px 10px;
	text-align: center;
}

.ui-datepicker .ui-datepicker-title {
	margin: 0 0;
	line-height: 2em;
	text-align: center;
}

/* 날짜 영역 높이 */
.ui-state-default {
	height: 2.2em;
	line-height: 2.2em;
	padding: 0;
}

/* 전체 셀 기본 적용 */
.ui-widget-header, .ui-widget-header .ui-state-default,
	.ui-widget-content .ui-state-default, .ui-button.ui-state-disabled:active
	{
	border: none;
	background: #ffffff;
	color: #050505;
	text-align: center;
	vertical-align: middle;
}

/* 오늘 날짜 */
.ui-state-highlight, .ui-widget-content .ui-state-highlight,
	.ui-widget-header .ui-state-highlight {
	border: none;
	background: #edbaed;
}

/* 선택한 날짜  */
.ui-state-active, .ui-widget-content .ui-state-active, .ui-widget-header .ui-state-active,
	a.ui-button:active, .ui-button:active, .ui-button.ui-state-active:hover
	{
	background: #5a2ec2;
	color: white;
}

/*  과거 날짜 */
.past-date .ui-state-default {
	background-color: #dddddd;
	color: #aaaaaa;
}

/* ================== </캘린더> ================== */
.wrapper {
	width: 880px;
	margin: 0 auto;
}

.container {
	display: grid;
	grid-template-columns: 45% 55%;
	grid-template-rows: repeat(5, 1fr);
	height: 70vh;
}

.box {
	padding: 25px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.box:nth-child(1), .box:nth-child(3) {
	margin-right: 20px;
}

.box:nth-child(1), .box:nth-child(2) {
	margin-bottom: 20px;
}

.box:nth-child(1), .box:nth-child(2) {
	grid-row: span 4;
}

.box:nth-child(3), .box:nth-child(4) {
	grid-row: span 1;
}

.box:nth-child(1), .box:nth-child(2), .box:nth-child(3) {
	background-color: #f7f5fd;
}

.btn-next {
	width: 120px;
	height: 60px;
	background-color: #5a2ece;
	color: white;
	font-size: 20px;
	font-weight: bold;
	border-radius: 5px;
	float: right;
}

.class-detail {
	display: flex;
	flex-direction: column;
}

.class-detail .detail-bottom {
	display: flex;
	justify-content: space-between;
}

input[type="number"]::-webkit-inner-spin-button, input[type="number"]::-webkit-outer-spin-button
	{
	opacity: 1;
	background-color: red;
}

input[type="number"], select {
	padding: 5px 10px;
	border: none; /* 테두리 제거 */
	outline: none; /* 포커스 시 나타나는 외곽선 제거 */
}

select {
	width: 80%;
}

.header-title {
	font-weight: bold;
	font-size: 22px;
	color: #5a2ece;
	margin-bottom:10px;
}
</style>

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
			<div class="box" style="padding-right: 0;">
				<div class="btn-wrapper">
					<button class="btn-next">다음으로</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
