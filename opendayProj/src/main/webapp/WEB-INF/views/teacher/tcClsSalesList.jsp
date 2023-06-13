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
				<span class="tc-mainSession">${userId.userName} 강사님</span>
				<span class="tc-mainTimer">남은시간 : <span id="timer"></span></span>
			</div>
			<hr>
			<div class="tc-classList">
				<div class="tc-sales">
					<h3>정산 관리</h3>
					<div class="tc-sales-tot">
						<div>정산 완료 총 수익금</div>
						<div>${tcSalesTotal } 원</div>
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
<script>
/* 전역 변수 */
var initMinute;  // 최초 설정할 시간(min)
var remainSecond;  // 남은시간(sec)
 
$(document).ready(function(){
   clearTime(${minusTime}); // 세션 만료 적용 시간 
   setTimer();    // 문서 로드시 타이머 시작
});
 
function clearTime(min){ // 타이머 초기화 함수
   initMinute = min; 
   remainSecond = min*60; 
}
 
function setTimer(){ // 1초 간격으로 호출할 타이머 함수 
 
   // hh : mm 으로 남은시간 표기하기 위한 변수
   remainMinute_ = parseInt(remainSecond/60);
   remainSecond_ = remainSecond%60;
 
   if(remainSecond > 0){
      $("#timer").empty();
      $("#timer").append(Lpad(remainMinute_,2) + ":" + Lpad(remainSecond_,2));    // hh:mm 표기
      remainSecond--;
      setTimeout("setTimer()",1000); //1초간격으로 재귀호출!
   }else{
      alert('세션종료');
      /*세션 종료시 작동할 이벤트*/ 
   }
}
 
function Lpad(str,len){  // hh mm형식으로 표기하기 위한 함수
   str = str+"";
   while(str.length<len){
      str = "0"+str;
   }
   return str;
}
</script>
