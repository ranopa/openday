<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%=request.getContextPath() %>" />

<c:import url="/WEB-INF/views/header.jsp" />
<html>
<head>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- 결제 -->
  <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
  <link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@36,400,0,0" />
	<link rel="stylesheet"
		href="${contextPath}/resources/css/user/paymentProcess.css" />
  <script>
// call only once
  IMP.init('${storeIdCode}');

//주문번호, 아이템이름, 가격, 이메일, 이름, 전화번호, 상점아이디, 포스트코
function requestPay() {
  alert('request button')
  const merchant_uid = ""+Math.random();
  console.log(merchant_uid);
  console.log('${storeIdCode}');
  // const pg_kakao = `kakaopay.${storeIdCode}`;
  const pg_kakao = 'kakaopay';
	IMP.request_pay({
		pg: pg_kakao,
		pay_method: "card",
		merchant_uid: "" + Math.random(), // 주문번호
		name: "${data.clsName}",
		amount: ${data.clsPrice * (1 - (data.clsDiscount/100))},
		buyer_email: "${data.userEmail}",
		buyer_name: "${data.userName}",
		buyer_tel: "${data.userTel}",
		buyer_postcode: "00000"
		
	}, function(resp) {
		// callback
    console.log(resp);
    if(resp.success) {
      $('input[name="paymentMethod"]').val(resp.pay_method);
      $('input[name="pgProvider"]').val(resp.pg_provider);
      $( '#payment-form' ).submit();

    }
	});
}

$(function() {
  $("#payment-btn").on("click", function(e) {
    requestPay();
  })
})

</script>
</head>

<body>
	<div class="container">
		<form action="payment" method="POST" id="payment-form">
		
		<input type="hidden" name="userId" value="${data.userId }" />
		<input type="hidden" name="clsId" value="${data.clsId }" />
		<input type="hidden" name="scdNum" value="${data.scdNum }" />
		<input type="hidden" name="applyPersonnel" value="${data.applyPersonnel }" />
		<input type="hidden" name="pgProvider" />
    <input type="hidden" name="paymentMethod" />
    
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
						<td>${data.userName}(${data.userNickname})</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${data.userEmail}</td>
					</tr>
					<tr>
						<td>휴대폰 번호</td>
						<td>${data.userTel}</td>
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
						<td>${data.clsName}</td>
					</tr>
					<tr>
						<td>일정</td>
						<td>${data.scdDate}, ${data.scdTime}</td>
					</tr>
					<tr>
						<td>장소</td>
						<td>[${data.clsLoc}] ${data.scdPlace }(${data.scdPlaceDetail})</td>
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
						<td>
              <del>${data.clsPrice}</del> ${data.clsDiscount}%
              <span>${data.clsPrice * (1 - (data.clsDiscount/100))}원
            </td>
					</tr>
					<tr>
						<td>신청 인원 수</td>
						<td>${data.applyPersonnel} 명</td>
					</tr>
					<tr>
						<td>총 금액</td>
						<td id="total-price">${data.clsPrice * (1 - (data.clsDiscount/100))}원</td>
					</tr>
				</table>
			</div>
			<div class="inner-divide"></div>
			<div class="inner-container-content" id="payment-info-final">
				<table>
					<tr>
						<td>포인트 적용</td>
						<td><span>보유 0</span> <input type="text" name="point" id="point-to-use" value="0"/>p</td>
					</tr>
					<tr>
						<td>최종 결제 금액</td>
						<td id="final-price">${data.totalPrice}원</td>
					</tr>
				</table>
			</div>
		</div>
	
		</form>
    <div class="btn-wrapper">
			<button type="button" class="btn-last" id="payment-btn">결제하기</button>
		</div>
	</div>
	<c:import url="/WEB-INF/views/footer.jsp" />
</body>
</html>