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
<%@ include file="../header.jsp"%>
	<div id="includeWrapper">
	<div id="noticeWrapper">	
			<a href="announcementList" class="atag">공지사항</a>
			<a href="inquiry" class="atag">문의하기</a>
			<a href="inquiryList" class="atag">문의내역</a>
		    <br><br><hr><br><br>
			
			<form action="inquiryUpdate" method="post">
			<input type="hidden" name="admNum" class="alist" value="${inquiry.admNum }"/>
			<table>
			<tr>
			<th>작성자</th><td><input type="text" name="userId" class="alist" value="${inquiry.userId}" readonly/></td>
			<th>등록일</th><td><input type="text"  class="alist" value="${inquiry.admUploadDate}" readonly/></td>
			</tr>
			<tr>
			<th>제목</th><td><input type="text" name="admTitle" class="alist" value="${inquiry.admTitle}"/></td>
			<th>상태</th><td><input type="text" name="admType" class="alist" value="${inquiry.admType}" readonly/></td>
			</tr>
			<tr  style="height:280px">
			<th>내용</th><td colspan="3"><input name="admContent" class="alist" type="text" value="${inquiry.admContent}" /></td>
			</tr>
			</table>
			
						
			<br><br>
			
			<table>
			<tr>
			<th>답변제목</th><td>${inquiry.admAnTitle}</td>
			<th>등록일</th><td>${inquiry.admAnDate}</td>
			</tr>
			<tr style="height:200px">
			<th>답변내용</th><td colspan="3">${inquiry.admAnContent}</td>
			</tr>
			</table>
			<br><br>
			<button type="submit" class="edit-btn">수정</button>
      		<button type="button" class="list-btn"><a href="inquiryList" style="text-decoration: none; color:white;">목록</a></button>
      		</form>
	</div>
			<%@ include file="../footer.jsp"%>

	</div>
</body>
</html>