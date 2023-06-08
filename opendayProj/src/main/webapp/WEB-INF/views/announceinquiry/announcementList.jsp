<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/adm/announcementList.css" />' rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/announcement/announcementList.js" />'></script>

<!-- 일단 임시로 넣어줌 아이콘 문제임 -->
<link rel="shortcut icon" href="#">

<!-- 제이쿼리 문제 -->
<script type="text/javascript">
      $.noConflict();
</script>
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
			<br><br>

			<table>
			<tr>
			<th class="smallth">번호</th>
			<th id="largeth">제목</th>
			<th>분류</th>
			<th>조회수</th>
			<th>작성날짜</th>
			</tr>
			<tr>
			<td class="smallth"><a href="announcementList?ancId=${announcementDTO.ancId}">${ancId }</th>
			<td id="largeth">${announcementDTO.ancTitle }</th>
			<td>${announcementDTO.ancType }</th>
			<td>${announcementDTO.ancViewcount }</th>
			<td>${announcementDTO.ancUploadDate }</th>
			</tr>
			</table>
	</div>
	<div id="includeFooter" class="includeFooter">
			<%@ include file="../footer.jsp"%>
	</div>
	</div>
</body>
</html>