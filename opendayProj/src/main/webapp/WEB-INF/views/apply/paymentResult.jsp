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
		<div class="header-title">결제 완료(상태:${result.apPstatus})</div>
		<div class="container">
			<div class="payment-result-summary">
				<p>신청번호: ${result.apNum }</p>
				<p>결제일자: ${result.apDate }</p>
				<p>결제금액: ${result.apFinalAmount }원 </p>
				<p>결제방식: ${result.apMethod } </p>
				
				
			</div>
			<div class="class-image-card">이미지</div>
			<div class="class-detail">
				<h4>${result.oClass.clsName }</h4>
			</div>

			<div class="">
				<h3>일시</h3>
				${result.schedule.scdDate }, ${result.schedule.scdTime }
			</div>
		
			<div class="">
				<h3>장소</h3>
				${result.schedule.scdLoc }
			</div>

			<a href="">메인으로</a>
		</div>
	</div>
</body>
</html>
