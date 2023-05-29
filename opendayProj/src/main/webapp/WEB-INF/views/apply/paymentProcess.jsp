<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@36,400,0,0" />
</head>
<style>
.container {
	width: 880px;
	height: 70vh;
	margin: 0 auto;
}

.inner-container-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 10px;
}
.inner-container-header-left {
	display: flex;
	align-items: center;
}

.inner-container-content {
	padding: 10px 20px;
	background-color: #f7f5fd;
}

.inner-container {
	margin-bottom: 30px;
}


#payment-info-sum table, #payment-info-final table {
	width: 90%;
}

#payment-info-sum tr td:nth-child(2), #payment-info-final tr td:nth-child(2)
	{
	text-align: right;
}

.btn-last {
	width: 120px;
	height: 60px;
	background-color: #5a2ece;
	color: white;
	font-size: 20px;
	font-weight: bold;
	border-radius: 5px;
	margin: 30px 0 auto;
}

.btn-wrapper {
	text-align: center;
}
.inner-divide {
	height: 10px;
	background-color: #ffffff;
}
.header-title {
	font-weight: bold;
	font-size: 20px;
	color: #5a2ece;
}
</style>
<body>
	<div class="container">
		<div class="inner-container" id="customer-info">
			<div class="inner-container-header">
				<div class="inner-container-header-left">
					<span class="material-symbols-outlined"> arrow_back_ios </span> <span
						class="header-title">구매자정보</span>
				</div>
				<div class="inner-container-header-right">
					<span><a href="#">수정하기</a></span>
				</div>
			</div>
			<div class="inner-container-content">
				<table>
					<colgroup>
						<col width="200px">
						<col width="200px">
					</colgroup>
					<tr>
						<td>이름(닉네임)</td>
						<td>${user.userName}(${user.userNickname})</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${user.userEmail}</td>
					</tr>
					<tr>
						<td>휴대폰 번호</td>
						<td>${user.userTel}</td>
					</tr>
				</table>
			</div>
		</div>
    <!-- 구매한 클래스 정보 -->
    <div class="inner-container" id="product-info">
			<div class="inner-container-header">
				<div class="inner-container-header-left">
				  <span class="header-title">상품 정보</span>
				</div>
			</div>
			<div class="inner-container-content">
				<table>
					<colgroup>
						<col width="200px">
						<col width="200px">
					</colgroup>
					<tr>
						<td>클래스 명</td>
						<td>${oClass.clsName}</td>
					</tr>
					<tr>
						<td>일정</td>
						<td>${schedule.scdDate}, ${schedule.scdTime}</td>
					</tr>
					<tr>
						<td>장소</td>
						<td>${schedule.scdLoc}</td>
					</tr>
				</table>
			</div>
		</div>


		<div class="inner-container" id="refund-notice">
			<div class="inner-container-header">
				<span class="header-title">취소 및 환불 안내</span>
			</div>
			<div class="inner-container-content">

				<h3>1. 날짜 별 취소 및 환불 정책</h3>
				<table border="1px solid" style="width: 80%;">
					<tr>
						<td>결제 후 1시간 이내 취소</td>
						<td>100% 환불</td>
					</tr>
					<tr>
						<td>결제 후 1시간 이내 취소</td>
						<td>100% 환불</td>
					</tr>
					<tr>
						<td>결제 후 1시간 이내 취소</td>
						<td>100% 환불</td>
					</tr>
					<tr>
						<td>결제 후 1시간 이내 취소</td>
						<td>100% 환불</td>
					</tr>
					<tr>
						<td>결제 후 1시간 이내 취소</td>
						<td>100% 환불</td>
					</tr>
				</table>
				<h3>2. 취소 방법</h3>
				클래스 결제/예약 내역 페이지에서 취소하고자 하는 클래스 티켓의 수강 취소 버튼을 클릭하시면 취소 신청이 완료됩니다.
			</div>
		</div>
		<div class="inner-container">
			<div class="inner-container-header" >
				<span class="header-title"> 결제 정보</span>
			</div>
			<div class="inner-container-content" id="payment-info-sum">
				<table>
					<tr>
						<td>선택 상품 금액</td>
						<td>${oClass.clsPrice} 원</td>
					</tr>
					<tr>
						<td>신청 인원 수</td>
						<td>${personnel} 명</td>
					</tr>
					<tr>
						<td>총 금액</td>
						<td>${totalPrice}원</td>
					</tr>
				</table>
			</div>
			<div class="inner-divide"></div>
			<div class="inner-container-content" id="payment-info-final">
				<table>
					<tr>
						<td>포인트 적용</td>
						<td><span>보유 2,000</span> <input type="text" />p</td>
					</tr>
					<tr>
						<td>최종 결제 금액</td>
						<td>${finalPrice} 원</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="btn-wrapper">
			<button class="btn-last">결제하기</button>
		</div>

	</div>
</body>
</html>