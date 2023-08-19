<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/adm/announcementDetail.css" />' rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/adm/announcementDetail.js" />'></script>

<!-- 일단 임시로 넣어줌 아이콘 문제임 -->
<link rel="shortcut icon" href="#">
<!-- 제이쿼리 문제 -->
<script type="text/javascript">
      $.noConflict();
</script>
</head>
<%@ include file="../header.jsp"%>
<body>
	<div id="includeWrapper">
	<div id="noticeWrapper">	
			<a href="announcementList" class="atag">공지사항</a>
			<a href="inquiry" class="atag">문의하기</a>
			<a href="inquiryList" class="atag">문의내역</a>
			<br><br><hr><br><br>
			<table id="announcementDetailTable">
			<tr>
			<th>작성날짜</th><td colspan="3"><input type="date" id="now_date" class="alist" value="${anc.ancUploadDate }" readonly></input></td>
			</tr>
			<tr>
			<th>제목</th><td colspan="3"><input type="text" value="${anc.ancTitle }" class="alist" readonly></input></td>
			</tr>
			<tr style="height:400px">
			<th>내용</th><td colspan="3"><input type="text" id="content" class="alist" value="${anc.ancContent }" readonly></td>
			</tr>
			<tr>
			<th>첨부파일</th><td colspan="3"><input type="file" class="alist" value="${anc.filNum }"></td>
			</tr>
			</table>
			<br><br>
			<button type="button" class="list-btn"><a href="announcementList" style="color:white; text-decoration:none;">목록</a></button>
	</div>
	</div>
</body>
<%@ include file="../footer.jsp"%>
</html>