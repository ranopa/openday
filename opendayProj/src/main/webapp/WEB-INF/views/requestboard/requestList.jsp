<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		padding: 0;
		margin: 0;
	}

	#wrap {
		width: 1280px;
		margin: 0 auto;
	}

	h1 {
		font-family: Gothic;
		font-size: 24px;
		color: #5A2ECE;
		margin: 20px 0;
	}

	.button {
		display: inline-block;
		padding: 5px 15px;
		background-color: #5A2ECE;
		color: white;
		font-size: 14px;
		text-decoration: none;
		border-radius: 4px;
		margin-bottom: 20px;
	}

	table {
		width: 100%;
		margin: 0 auto;
		border-collapse: collapse;
	}

	th, td {
		padding: 10px;
		font-size: 14px;
	}

	th {
		background-color: #D9D9D9;
		font-weight: bold;
	}
	
	th:nth-child(2), td:nth-child(2) {
        width: 40%;
    }

	.container {
		width: 65%;
		height: 800px;
		margin: 0 auto;
	}

	.btn1 {
		width: 65px;	
	}
</style>
</head>
<body>
	<div id="wrap">
		<h1>클래스 개설 요청</h1>
		&nbsp;&nbsp;
		<div class="container">
			<div class="btn1">
				<a href="requestwrite" class="button">새 글</a>
			</div>
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회</th>
					</tr>
					<c:forEach items="${requestList}" var="request">						
					<tr>
						<td>${request.reqId}</td>
						<td><a href="requestdetail?reqId=${request.reqId} ">${request.reqTitle}</a></td>
						<td>${request.userId}</td>
						<td>${request.reqDate}</td>
						<td>${request.reqViews}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>