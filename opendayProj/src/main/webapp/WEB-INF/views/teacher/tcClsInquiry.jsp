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
			<div class="tc-classList">
				<div class="tc-classSchedule">
					<h2>클래스 수강생 1:1 문의</h2>
					<table class="tc-classTable">
						<colgroup>
							<col width="10%" />
							<col width="45%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="15%" />
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>클래스명</th>
								<th>별점</th>
								<th>하트수</th>
								<th>문의수</th>
								<th>등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tcCllist }" var="tcCllist">
								<tr onclick="classInquiryList(${tcCllist.clsId })">
									<td>${tcCllist.clsId }</td>
									<td>${tcCllist.clsName }</td>
									<td>${tcCllist.rvStar }</td>
									<td>${tcCllist.heartCount }</td>
									<td>${tcCllist.clsInquiry  }</td>
									<td>${tcCllist.clsCreatedAt }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
				<div class="tc-paging">
					<c:if test="${pu.startPageNum>5 }">
						<a href="tcClsInquiry?pageNum=${pu.startPageNum-1 }"><span
							class="material-symbols-outlined pagenp pagep">chevron_left</span></a>
					</c:if>

					<c:forEach var="i" begin="${pu.startPageNum }"
						end="${pu.endPageNum }">
						<c:choose>
							<c:when test="${pu.pageNum==i }">
								<!-- 현재페이지 -->
								<div class="numBox" style='color: #8556FF;'>
									<a href="tcClsInquiry?pageNum=${i }"> <span
										style='color: #8556FF; font-weight: bold'>${i }</span>
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="numBox" style='color: #CFCFCF;'>
									<a href="tcClsInquiry?pageNum=${i }"> <span
										style='color: gray;'>${i }</span>
									</a>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${pu.endPageNum<pu.totalPageCount }">
						<a href="tcClsInquiry?pageNum=${pu.endPageNum+1 }"><span
							class="material-symbols-outlined pagenp">chevron_right</span></a>
					</c:if>
				</div>
				<div class="tc-classScheduleUser">
					<h2>문의 내역</h2>
					<table class="tc-classUserTable">
						<colgroup>
							<col width="10%" />
							<col width="20%" />
							<col width="30%" />
							<col width="15%" />
							<col width="15%" />
						</colgroup>
						<thead>
							<tr>
								<th>문의번호</th>
								<th>제목</th>
								<th>내용</th>
								<th>작성일</th>
								<th>답변상태</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="modal1" onclick="tcModalClose()">
		<div class="modal1-content">
			<div class="tc-title">
				<span class="tcAnnouncement">문의 답글</span> <span
					class="close-modal1 float-r" onclick="tcAnClose()">X</span>
			</div>
			<table class="modal1-table" border>
				<tr>
					<th>수강생명</th>
					<td id="ancUploadDate"></td>
				</tr>
				<tr>
					<th>문의제목</th>
					<td id="filNum"></td>
				</tr>
				<tr>
					<th>문의내용</th>
					<td id="ancContent"></td>
				</tr>
				<tr>
					<th>문의답글</th>
					<td id="ancContent"><textarea rows="" cols="" style="height: 150px;" id="answer"></textarea><br>
						<button id="save-modal">저장</button></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
<script>
	function classInquiryList(num) {
		$.ajax({
			type:"POST",
			url:"classInquiryList",
			data:{
				"clsId": num
			},
			dataType: "json",
			success:function(data){
				console.log(data);
				$(".tc-classUserTable>tbody *").remove();
				let text = "";
				for(let i=0; i<data.length; i++){
					let str = "<button onclick='tcAnFunc(" + data[i].ciNum + ")'>답변하기</button>";
					if(data[i].ciStatus == true) {
						str = "답변완료";
					}
					text += "<tr><td>"+data[i].ciNum+"</td>"
						+ "<td>"+data[i].ciTitle+"</td>"
						+ "<td>"+data[i].ciContent+"</td>"
						+ "<td>"+data[i].ciDate+"</td>"
						+ "<td>"+str+"</td></tr>"
				} 
				$(".tc-classUserTable>tbody").append(text);
			},
			fail:function(data){
				console.log(data);
			}
		}); 
	}
</script>
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
function tcAnFunc(num) {
	modal1.style.display = "block";
 	document.body.style.overflow = "hidden"; // 스크롤바 제거
 	$.ajax({
		type:"POST",
		url:"tcAnInfo",
		data:{
			"ciNum": num
		},
		dataType: "json",
		success:function(data){
			console.log(data);
			$("#ancTitle").text(data.ancTitle);
			$("#ancContent").text(data.ancContent);
			$("#ancUploadDate").text(data.ancUploadDate);
			$("#filNum").text(data.filNum);
		},
		fail:function(data){
			console.log(data);
		}
	});
}
function tcAnClose() {
	modal1.style.display = "none";
 	document.body.style.overflow = "auto"; // 스크롤바 보이기
}
function tcModalClose() {
	if(!document.getElementById("modal1")) {
		  modal1.style.display = "none";
		  document.body.style.overflow = "auto"; // 스크롤바 보이기
	}
}
</script>
