<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/user/classOpen.css" />'	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/user/classOpen.js" />'></script>

<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.css" />
<script	src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.min.css"/>

<!-- 일단 임시로 넣어줌 아이콘 문제임 -->
<link rel="shortcut icon" href="#">
</head>

<body>
	
	<%@ include file="../header.jsp"%>
	<section id="./classOpenForm">
	<div id="div1">
	<form id="form" action="classOpen" method="post">
		<h3>클래스 개설</h3>
		<div id=opendiv1>
			
			<div class="opendiv2">
				<span class="span">클래스 이름</span> <input type="text" name="clsName"
					placeholder="클래스 이름을 입력해 주세요(20자 이하)" required autofocus
					maxlength="20">
			</div>

			<div class="opendiv2">
				<span class="span">클래스 카테고리</span><br><br>
				<div class=catediv>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="radio"id="category1" name="clsCode" ><label for="category1">가죽</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category2" name="clsCode"><label for="category2">금속/악세사리</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category3" name="clsCode"><label for="category3">도자기</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category4" name="clsCode"><label for="category4">라탄/마크라메</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category5" name="clsCode"><label for="category5">목공</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category6" name="clsCode"><label for="category6">미술</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category7" name="clsCode"><label for="category7">뷰티/미용</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category8" name="clsCode"><label for="category8">애견</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category9" name="clsCode"><label for="category9">유리</label>
				<br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category10" name="clsCode"><label for="category10">음악</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category11" name="clsCode"><label for="category11">자수</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category12" name="clsCode"><label for="category12">조향/캔들/방향제</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category13" name="clsCode"><label for="category13">취미</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category14" name="clsCode"><label for="category14">쿠킹</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category15" name="clsCode"><label for="category15">키즈</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category16" name="clsCode"><label for="category16">플라워/벌룬</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category17" name="clsCode"><label for="category17">핸드메이드</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category18" name="clsCode"><label for="category17">기타</label>
				<br><br>
				</div>
			</div>

			<div class="opendiv2">
				<span class="span">클래스 소개글</span> 
				<input type="text"name="clsDescription" id="clsDescription"placeholder="클래스 소개글을 입력해 주세요(200자 이하)" autofocus maxlength="200">
			</div>

			<div id="divdouble">
				<div>
					<p>클래스 썸네일 설정</p>
					<div class="thumbnail-container" id="thumbnail-container">
						<input type="file" name="filName" class="file-input" id="thumbnail-input"onchange="readURL(this);"> <img id="preview" />
					</div>
				</div>

				<div>
					<p>강사, 강의 경력</p>
					<textarea placeholder="내용을 입력해 주세요" name="clsCarrer"></textarea>
				</div>
			</div>

			<div id=curri class="opendiv2">
				<p>커리큘럼 작성</p>
				<div id="editor" name="clsCurri"></div>
			</div>
		</div>
		<div class="btns">
		<button type="button" class="cancel-btn" onClick="window.location.reload()">초기화</button>
      <button type="button" class="cancel-btn">취소</button>
      <button type="submit" class="submit-btn" id="classSubmit">클래스 개설</button>
	</div>
	</form>
	</div>
	</section>
	<%@ include file="../footer.jsp"%>
</body>
</html>