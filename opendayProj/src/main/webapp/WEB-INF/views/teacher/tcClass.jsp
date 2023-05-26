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
					<form action="" method="get">
						<h3>기간검색</h3>
						<input type="date"><input type="date">
						<button>전체</button>
						<button>오늘</button>
						<button>1개월</button>
						<button>6개월</button>
						<button>1년</button>
						<br>
						<h3>개설상태</h3>
						<select>
							<option>전체</option>
							<option>승인</option>
							<option>미승인</option>
						</select>
						<h3>키워드 검색</h3>
						<input type="text"> <br>
						<div class="tc-FilterBtn">
							<input type="reset" value="초기화"> 
							<input type="submit" value="검색">
						</div>
					</form>
				</div>
				<div class="tc-classBoard">
					<table class="tc-classBoardList">
						<%-- <colgroup>
						<col width="5%" />
						<col width="80%" />
						<col width="10%" />
					</colgroup> --%>
						<thead>
							<tr>
								<th>클래스번호</th>
								<th>클래스명</th>
								<th>신청인원</th>
								<th>스케줄</th>
								<th>수강료</th>
								<th>클래스상태</th>
								<th>클래스검수상태</th>
								<th>클래스개설날짜</th>
								<th>취소/수정</th>
								<th>수정/폐강</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							</tr>
						</tbody>
					</table>
					<div class="dataNon">데이터가 존재하지 않습니다.</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>