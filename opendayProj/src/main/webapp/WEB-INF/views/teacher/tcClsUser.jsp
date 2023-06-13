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
				<span class="tc-mainTitle">강사페이지</span>
				<span class="tc-mainSession">${userId.userName} 강사님</span>
				<span class="tc-mainTimer">남은시간 : <span id="timer"></span></span>
			</div>
			<hr>
			<div class="tc-classList">
				<div class="tc-classSchedule">
					<h2>클래스 수강생 관리</h2>
					<table class="tc-classTable">
						<colgroup>
							<col width="5%" />
							<col width="15%" />
							<col width="15%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>강의명</th>
								<th>일정</th>
								<th>장소</th>
								<th>수강인원</th>
								<th>등록일</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tcClassScdlist }" var="tcClScdlist">
								<tr onclick="classUserList(${tcClScdlist.scdNum })">
									<td>${tcClScdlist.scdNum }</td>
									<td>${tcClScdlist.clsName }</td>
									<td>${tcClScdlist.scdStartTime }</td>
									<td>${tcClScdlist.scdPlaceDetail }</td>
									<td>0/${tcClScdlist.scdMinPersonnel }</td>
									<td>${tcClScdlist.scdUploadDate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
				<div class="tc-paging">
						<c:if test="${pu.startPageNum>5 }">
							<a href="tcClassUser?pageNum=${pu.startPageNum-1 }">이전</a>
						</c:if>

						<c:forEach var="i" begin="${pu.startPageNum }"
							end="${pu.endPageNum }">
							<c:choose>
								<c:when test="${pu.pageNum==i }">
									<!-- 현재페이지 -->
									<a href="tcClassUser?pageNum=${i }"> <span
										style='color: blue; font-weight: bold'>[${i }]</span>
									</a>
								</c:when>
								<c:otherwise>
									<a href="tcClassUser?pageNum=${i }"> <span style='color: gray;'>[${i }]</span>
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${pu.endPageNum<pu.totalPageCount }">
							<a href="tcClassUser?pageNum=${pu.endPageNum+1 }">다음</a>
						</c:if>
					</div>
				<div class="tc-classScheduleUser">
					<h2>수강생 목록</h2>
					<table class="tc-classUserTable">
						<colgroup>
							<col width="10%" />
							<col width="15%" />
							<col width="20%" />
							<col width="20%" />
							<col width="20%" />
							<col width="15%" />
						</colgroup>
						<thead>
							<tr>
								<th>신청번호</th>
								<th>이름</th>
								<th>전화번호</th>
								<th>주소</th>
								<th>이메일</th>
								<th>신청일</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
<script>
	function classUserList(num) {
		$.ajax({
			type:"POST",
			url:"classUserList",
			data:{
				"scdNum": num
			},
			dataType: "json",
			success:function(data){
				$(".tc-classUserTable>tbody *").remove();
				let text = "";
				for(let i=0; i<data.length; i++){
					text += "<tr><td>"+data[i].apNum+"</td>"
						+ "<td>"+data[i].userName+"</td>"
						+ "<td>"+data[i].userTel+"</td>"
						+ "<td>"+data[i].userAddress+"</td>"
						+ "<td>"+data[i].userEamil+"</td>"
						+ "<td>"+data[i].apDate+"</td></tr>"
				} 
				$(".tc-classUserTable>tbody").append(text);
				
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
