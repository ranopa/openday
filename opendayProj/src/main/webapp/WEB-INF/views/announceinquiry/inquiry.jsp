<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link href='<c:url value="/resources/css/adm/inquiry.css" />' rel="stylesheet">
<script src='<c:url value="/resources/js/announcement/inquiry.js" />'></script>

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
			<form id="form" action="inquiry" method="post" enctype="multipart/form-data" style="width:818px;">
			
			<span style="margin-left:230px;">유&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;형</span>
			<input type="radio" id="category1" name="admType" value="일반" style="width:40px; margin-left:16px;" ><label for="category1">일반</label>&nbsp;
			<input type="radio" id="category2" name="admType" value="강사" style="width:40px; margin-bottom:40px;"><label for="category2">강사</label>
			
			<div>
			<span style="margin-left:230px;">공개여부</span>
			<input type="radio" id="category3" name="admSecret" value="1" style="width:40px; margin-left:15px;" ><label for="category3">공개</label>&nbsp;
			<input type="radio" id="category4" name="admSecret" value="2" style="width:40px; margin-bottom:40px;"><label for="category4">비공개</label>
			</div>
			
			<p style="margin-left:230px; margin-bottom:10px; font-size:18px;">제목</p>
			<input type="text" name="admTitle" style="width:820px; height:40px; margin-left:230px; border:1px solid; border-radius: 5px; margin-bottom:40px" placeholder="제목을 입력해주세요"/>

			<p style="margin-left:230px; margin-bottom:10px; font-size:18px;">내용</p>
			<textarea name="admContent" style="height:380px; width:818px; margin-left:230px; margin-bottom:40px; border-radius: 5px;" placeholder="내용을 입력해주세요" ></textarea>
			
			<button type="submit" class="submit-btn">제출하기</button>
			</form>
	</div>
	<div id="includeFooter" class="includeFooter">
			<%@ include file="../footer.jsp"%>
	</div>
	</div>
</body>
</html>