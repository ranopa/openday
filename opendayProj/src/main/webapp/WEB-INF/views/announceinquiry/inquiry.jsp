<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/adm/inquiryDetail.css" />' rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/announcement/inquiryDetail.js" />'></script>

<!-- 일단 임시로 넣어줌 아이콘 문제임 -->
<link rel="shortcut icon" href="#">
</head>
<body>
	<div id="includeWrapper">
	<div id="includeHeader" class="includeHeader">
		<%@ include file="../header.jsp"%>
	</div>
	<div id="noticeWrapper">	
			<a href="announcementList" class="atag">공지사항</a>
			<a href="inquiry" class="atag">문의하기</a>
			<a href="inquiryList" class="atag">문의내역</a>
			<br><br><hr><br><br>
			
			<table>
			<tr>
			<th>작성날짜</th><td colspan="3"> <input type="date" id="now_date" readonly></input></td>
			<script>
			document.getElementById('now_date').valueAsDate = new Date();
			</script>
			</tr>
			<tr>
			<th>제목</th><td colspan="3"><input type="text"></input></td>
			</tr>
			<tr style="height:400px">
			<th>내용</th><td colspan="3"><textarea style="height:380px; width:818px; border:none; outline: none;"></textarea></td>
			</tr>
			<tr>
			<th>첨부파일</th><td colspan="3"><input type="file"></td>
			</tr>
			</table>
	</div>
	<div id="includeFooter" class="includeFooter">
			<%@ include file="../footer.jsp"%>
	</div>
	</div>
</body>
</html>