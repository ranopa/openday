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
								<tr  onclick="classInquiryList(${tcCllist.clsId })">
									<td>${tcCllist.clsId }</td>
									<td>${tcCllist.clsName }</td>
									<td>${tcCllist.clsStar }</td>
									<td>${tcCllist.clsHeart }</td>
									<td>${tcCllist.clsInquiry  }</td>
									<td>${tcCllist.clsCreatedAt }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
				<div class="tc-paging">
						<c:if test="${pu.startPageNum>5 }">
							<a href="tcClassInquiry?pageNum=${pu.startPageNum-1 }">이전</a>
						</c:if>

						<c:forEach var="i" begin="${pu.startPageNum }"
							end="${pu.endPageNum }">
							<c:choose>
								<c:when test="${pu.pageNum==i }">
									<!-- 현재페이지 -->
									<a href="tcClassInquiry?pageNum=${i }"> <span
										style='color: blue; font-weight: bold'>[${i }]</span>
									</a>
								</c:when>
								<c:otherwise>
									<a href="tcClassInquiry?pageNum=${i }"> <span style='color: gray;'>[${i }]</span>
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${pu.endPageNum<pu.totalPageCount }">
							<a href="tcClassInquiry?pageNum=${pu.endPageNum+1 }">다음</a>
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
					let str = "<button>답변하기</button>";
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