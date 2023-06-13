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
				<span class="tc-mainTitle">강사페이지</span> <span class="tc-mainSession">${userId.userName}
					강사님</span> <span class="tc-mainTimer">남은시간 : <span id="timer"></span></span>
			</div>
			<hr>
			<div class="tc-dashboard">
				<div class="tc-dashboard-list">
					<div>총 누적 정산액</div>
					<div>${tcSalesTotal }원</div>
				</div>

				<div class="tc-dashboard-list">
					<div>한달 정산액</div>
					<div>${tcSalesMonthTotal }원</div>
				</div>

				<div class="tc-dashboard-list">
					<div>운영중인 클래스</div>
					<div>${tcClassListStatus1Count }개</div>
				</div>

				<div class="tc-dashboard-list">
					<div>총 후기 수</div>
					<div>${tcClassListReviewCount }개</div>
				</div>

				<div class="tc-dashboard-list">
					<div>평점</div>
					<div>${tcClassListAvgStarCount }점</div>
				</div>

				<div class="tc-dashboard-list">
					<div>승인 대기중인 클래스</div>
					<div>${tcClassListStatus2Count }개</div>
				</div>
			</div>
			<div class="tc-announcement">
				<h2 class="tc-announcement-title">공지사항</h2>
				<table class="tc-announcement-table">
					<colgroup>
						<col width="5%" />
						<col width="80%" />
						<col width="10%" />
					</colgroup>
					<c:forEach items="${tcAnlist }" var="tcAnlist">
						<tr onclick="tcAnFunc(${tcAnlist.ancId })">
							<td >공지</td>
							<td>${tcAnlist.ancTitle }</td>
							<td>${tcAnlist.ancUploadDate }</td>
						</tr>
					</c:forEach>
				</table>
				<div class="dataNon">${err }</div>
			</div>
		</div>
	</div>
	<div id="modal1" onclick="tcModalClose()">
		<div class="modal1-content">
			<div class="tc-title">
				<span class="tcAnnouncement">공지사항</span>
				<span class="close-modal1 float-r"  onclick="tcAnClose()">X</span>
			</div>
			<table class="modal1-table" border>
				<tr>
					<th>공지</th>
					<td>공지사항</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>0000-00-00</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>첨부파일</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>내용</td>
				</tr>
			</table>
			
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
/* let modal1 = document.getElementById("modal1");
let closeModalBtn1 = document.getElementById("close-modal1"); */
/* // 모달창 열기
openModalBtn1.addEventListener("click", () => {
  modal1.style.display = "block";
  document.body.style.overflow = "hidden"; // 스크롤바 제거
}); */
// 모달창 닫기
/* closeModalBtn1.addEventListener("click", () => {
  modal1.style.display = "none";
  document.body.style.overflow = "auto"; // 스크롤바 보이기
});
modal1.addEventListener("click", (e) => {
	if(e.target === modal1) {
	  modal1.style.display = "none";
	  document.body.style.overflow = "auto"; // 스크롤바 보이기
	}
}); */
function tcAnFunc(num) {
	modal1.style.display = "block";
 	document.body.style.overflow = "hidden"; // 스크롤바 제거
}
function tcAnClose() {
	modal1.style.display = "none";
	  document.body.style.overflow = "auto"; // 스크롤바 보이기
}
function tcModalClose() {
	if(!(document.getElementById("modal1"))) {
		  modal1.style.display = "none";
		  document.body.style.overflow = "auto"; // 스크롤바 보이기
		}
}
</script>
