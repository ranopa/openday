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
			
			<p style="margin-left:230px; margin-bottom:10px;">제목</p>
			<input type="text" name="admTitle" style="width:820px; height:40px; margin-left:230px; border:1px solid; border-radius: 5px; margin-bottom:40px"/>

			<p style="margin-left:230px; margin-bottom:10px;">내용</p>
			<textarea name="admContent" style="height:380px; width:818px; margin-left:230px; margin-bottom:40px; border-radius: 5px;" ></textarea>
			
			<p style="margin-left:230px; margin-bottom:10px;">첨부파일</p>
			<input id="fileInput" type="file" name="file" style="display: none;">
			<div class="dropBox" style="width:820px; height:40px; margin-left:230px; border:1px solid; margin-bottom:40px">
  			<p><span>파일 추가</span> 또는 파일을 여기로 드래그</p>
			</div>
			
			<script>
			const $drop = document.querySelector(".dropBox");
			const $title = document.querySelector(".dropBox p");
			const $fileInput = document.getElementById("fileInput");

			  // 드래그한 파일 객체가 해당 영역에 놓였을 때
			  $drop.ondrop = (e) => {
			    e.preventDefault();
			    $drop.className = "dropBox";

			    // 파일 리스트
			    const files = [...e.dataTransfer?.files];
			    $title.innerHTML = files.map(v => v.name).join("<br>");
			    $fileInput.files = files;
			  }

			  // ondragover 이벤트가 없으면 onDrop 이벤트가 실행되지 않습니다.
			  $drop.ondragover = (e) => {
			    e.preventDefault();
			  }

			  // 드래그한 파일이 최초로 진입했을 때
			  $drop.ondragenter = (e) => {
			    e.preventDefault();
			    $drop.classList.add("active");
			  }

			  // 드래그한 파일이 영역을 벗어났을 때
			  $drop.ondragleave = (e) => {
			    e.preventDefault();
			    $drop.classList.remove("active");
			  }

			  // 파일 입력 필드를 클릭하여 파일 선택
			  $drop.onclick = () => {
			    $fileInput.click();
			  }

			  // 파일 선택 시 파일 리스트 업데이트
			  $fileInput.onchange = () => {
			    const files = [...$fileInput.files];
			    $title.innerHTML = files.map(v => v.name).join("<br>");
			  }
			</script>
			<button type="submit" class="submit-btn">제출하기</button>
			</form>
	</div>
	<div id="includeFooter" class="includeFooter">
			<%@ include file="../footer.jsp"%>
	</div>
	</div>
</body>
</html>