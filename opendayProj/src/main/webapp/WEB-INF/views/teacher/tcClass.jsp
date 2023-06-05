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
			</div>
			<hr>
			<div class="tc-classList">
				<h2>클래스 목록</h2>
				<div class="tc-classFilter">
					<form action="tcClass" method="get">
						<h3>기간검색</h3>
						<input type="text" id="datepicker1" name="prevDate" readonly="readonly" value="${map.prevDate }"> - <input
							type="text" id="datepicker2" name="nextDate" readonly="readonly" value="${map.nextDate }">
						<button class="filterBtn" type="button" name="date_range_All"
							onclick="dateFunc(this)">전체</button>
						<button class="filterBtn" type="button" name="date_range_Now"
							onclick="dateFunc(this)">오늘</button>
						<button class="filterBtn" type="button" name="date_range_1Mon"
							onclick="dateFunc(this)">1개월</button>
						<button class="filterBtn" type="button" name="date_range_6Mon"
							onclick="dateFunc(this)">6개월</button>
						<button class="filterBtn" type="button" name="date_range_1Year"
							onclick="dateFunc(this)">1년</button>
						<br>
						<div class="tc-openStatus">
							<h3>개설상태</h3>
							<select name="clsStatus" id="clsStatus">
								<option value="">전체</option>
								<c:forEach items="${codeList }" var="code">
									<option value="${code.codName }" <c:if test="${map.clsStatus eq code.codName }">selected</c:if>>${code.codName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="tc-keywordSearch">
							<h3>키워드 검색</h3>
							<input type="text" class="tc-keywordInput" name="keyword" id="keyword" value="${map.keyword }"> <br>
						</div>
						<div class="tc-FilterBtn">
							<input type="button" value="초기화" onclick="resetBtn()"> <input type="submit"
								value="검색">
						</div>
					</form>
				</div>
				<div class="tc-classBoard">
					<table class="tc-classBoardList">
						<colgroup>
							<col width="5%" />
							<col width="10%" />
							<col width="20%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="7%" />
							<col width="7%" />
						</colgroup>
						<thead>
							<tr>
								<th>ㅁ</th>
								<th>개설 상태</th>
								<th>클래스명</th>
								<th>검수상태</th>
								<th>현재 상태</th>
								<th>개설일</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tcCllist }" var="tcCllist">
								<tr>
									<td>${tcCllist.clsId }</td>
									<td>${tcCllist.clsStatus }</td>
									<td>${tcCllist.clsName }</td>
									<td>검토중</td>
									<td>오픈</td>
									<td>${tcCllist.clsCreatedAt }</td>
									<td><button>취소</button></td>
									<td><button>폐강</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="dataNon">${err }</div>

					<div class="tc-paging">
						<c:if test="${pu.startPageNum>5 }">
							<a href="tcClass?pageNum=${pu.startPageNum-1 }&prevDate=${map.prevDate}&nextDate=${map.nextDate}&clsStatus=${map.clsStatus}&keyword=${map.keyword}">이전</a>
						</c:if>

						<c:forEach var="i" begin="${pu.startPageNum }"
							end="${pu.endPageNum }">
							<c:choose>
								<c:when test="${pu.pageNum==i }">
									<!-- 현재페이지 -->
									<a href="tcClass?pageNum=${i }&prevDate=${map.prevDate}&nextDate=${map.nextDate}&clsStatus=${map.clsStatus}&keyword=${map.keyword}"> <span
										style='color: blue; font-weight: bold'>[${i }]</span>
									</a>
								</c:when>
								<c:otherwise>
									<a href="tcClass?pageNum=${i }&prevDate=${map.prevDate}&nextDate=${map.nextDate}&clsStatus=${map.clsStatus}&keyword=${map.keyword}"> <span style='color: gray;'>[${i }]</span>
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${pu.endPageNum<pu.totalPageCount }">
							<a href="tcClass?pageNum=${pu.endPageNum+1 }&prevDate=${map.prevDate}&nextDate=${map.nextDate}&clsStatus=${map.clsStatus}&keyword=${map.keyword}">다음</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
