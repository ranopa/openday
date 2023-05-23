<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@40,400,0,0" />
</head>
<style>
.container {
	width: 880px;
	height: 70vh;
	margin: 0 auto;
}
</style>
<body>
	<div class="container">
		<div class="inner-container" id="customer_info">
			<div class="inner-container-header">
				<span class="material-symbols-outlined">
						arrow_back_ios 
				</span>
				<span><h3>구매자정보</h3></span>
				<span><a href="#">수정하기</a></span>
			</div>
			<div class="inner-container-content">
				<table>
					<tr>
						<th>이름(닉네임)</th>
						<td>코스타코스타</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>코스타코스타</td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td>010-1234-5678</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="inner-container" id="refund_notice">
			<div class="inner-container-header">
				<span> <span><h3>취소 및 환불 안내</h3></span>
				</span>
			</div>
			<div class="inner-container-content"></div>
		</div>
		<div class="inner-container" id="payment_info">
			<div class="inner-container-header">
				<span> <span><h3>결제 정보</h3></span>
				</span>
			</div>
			<div class="inner-container-content">
				<div class="inner-container-content">
				<table>
						<tr>
							<th>선택 상품 금액</th>
							<td>45,000 원</td>
						</tr>
						<tr>
							<th>신청 인원 수</th>
							<td>3 명</td>
						</tr>
						<tr>
							<th>총 금액</th>
							<td>135,000 원</td>
						</tr>
				</table>
			</div>
			</div>
		</div>
		<div class="inner-container" id="final_payment_info">
			<div class="inner-container-content">
				<table>
					<tr>
						<th>포인트 적용</th>
						<td>보유 2,000</td>
						<td>2,000p</td>
					</tr>
					<tr>
						<th>최종 결제 금액</th>
						<td>133,000 원</td>
					</tr>
				</table>
			</div>
		</div>
		<button>결제하기</button>
	</div>
</body>
</html>