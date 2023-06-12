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
		    <br><br><hr><br><br>
			
			<table>
			<tr>
			<th>작성자</th><td><input type="text" value="" readonly></input></td>
			<th>등록일</th><td><input type="text" value="" readonly></input></td>
			</tr>
			<tr>
			<th>제목</th><td><input type="text" value="" readonly></td>
			<th>상태</th><td><input type="text" value="" readonly></td>
			</tr>
			<tr  style="height:280px">
			<th>내용</th><td colspan="3"><input type="text" value="" readonly></td>
			</tr>
			<tr>
			<th>첨부파일</th><td colspan="3"><input type="file" value="" readOnly></td>
			</tr>
			</table>
			
						
			<br><br>
			
			<table>
			<tr>
			<th>답변제목</th><td>${admAnTitle }</td>
			</tr>
			<tr style="height:200px">
			<th>답변내용</th><td>${admAnContent }</td>
			</tr>
			</table>
			<br><br>
			<button type="button" class="edit-btn">수정</button>
      		<button type="button" class="list-btn">목록</button>
	</div>
	<div id="includeFooter" class="includeFooter">
			<%@ include file="../footer.jsp"%>
	</div>
	</div>
</body>
</html>