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
<style>
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

.class-detail {
	display: flex;
	flex-direction: column;
}

.class-detail .detail-bottom {
	display: flex;
	justify-content: space-between;
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
		<div class="header-title">결제 완료</div>
		<div class="container">

			<div class="class-image-card">이미지</div>
			<div class="class-detail">
				<h4>[서울/건대]마카롱 원데이 클래스 스위스머랭&비정제설탕</h4>

				<div class="detail-bottom">
					<span>카테고리</span> <span>가격</span>
				</div>
			</div>

			<div class="">
				<h3>결제 금액</h3>
				133,000원
			</div>
			<div class="">
				<h3>일시</h3>
				2023년 5월 19일 토요일 14:00~16:00
			</div>
		

			<div class="">
				<h3>장소</h3>
				서울특별시 호서대벤처타워 912호
			</div>

			<a href="">메인으로</a>
		</div>
	</div>
</body>
</html>
