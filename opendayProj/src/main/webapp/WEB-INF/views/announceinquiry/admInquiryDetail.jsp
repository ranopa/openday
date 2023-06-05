<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/adm/admInquiryDetail.css" />' rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/announcement/admInquiryDetail.js" />'></script>

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
			<a href="admInquiry" class="atag">문의하기</a>
			<a href="admInquiryList" class="atag">문의내역</a>
			<br><br>
			
			<div>
			<p>제목</p>
			<input type="text">
			<br>
			<p>내용</p>
			<textarea/>
			<br>
			<p>첨부파일</p>
			<input type="file">
			</div>
	</div>
	<div id="includeFooter" class="includeFooter">
			<%@ include file="../footer.jsp"%>
	</div>
	</div>
</body>
</html>