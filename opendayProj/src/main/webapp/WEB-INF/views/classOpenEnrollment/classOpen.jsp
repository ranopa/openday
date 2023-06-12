<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/user/classOpen.css" />' rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/user/classOpen.js" />'></script>

<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.css" />
<script	src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.min.css"/>

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
	<div id="div1">
	<form id="form" action="classOpen" method="post" enctype="multipart/form-data">
		<h3>클래스 개설</h3>
		<div id=opendiv1>
			
			<div class="opendiv2">
				<span class="span">클래스 이름</span> <input type="text" id="clsName" name="clsName" placeholder="클래스 이름을 입력해 주세요(20자 이하)" required autofocus maxlength="20">
			</div>
			<div class="opendiv2">
				<span class="span">클래스 지역</span>
				<select id="select" name="clsLoc")>
										<option>선택</option>
										<option>서울</option>
										<option>경기</option>
										<option>부산</option>
										<option>인천</option>
										<option>대전</option>
										<option>대구</option>
										<option>광주</option>
										<option>경북</option>
										<option>경남/울산</option>
										<option>전북</option>
										<option>전남</option>
										<option>충북</option>
										<option>충남</option>
										<option>세종</option>
										<option>강원</option>
										<option>제주</option>										
							</select>
			</div>
			<div class="opendiv2">
				<span class="span">클래스 수강료</span> <input type="number" id="clsPrice" name="clsPrice" min="0" required autofocus>원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="span">할인률</span> <input type="number" id="clsDiscount" name="clsDiscount" min="0" max="100" autofocus>%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="opendiv2">
				<span class="span">클래스 카테고리</span><br><br>
				<div class=catediv>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="radio"id="category1" name="clsCode" value="C1"><label for="category1">가죽</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category2" name="clsCode" value="C2"><label for="category2">금속/악세사리</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category3" name="clsCode" value="C3"><label for="category3">도자기</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category4" name="clsCode" value="C4"><label for="category4">라탄/마크라메</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category5" name="clsCode" value="C5"><label for="category5">목공</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category6" name="clsCode" value="C6"><label for="category6">미술</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category7" name="clsCode" value="C7"><label for="category7">뷰티/미용</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category8" name="clsCode" value="C8"><label for="category8">애견</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category9" name="clsCode" value="C9"><label for="category9">유리</label>
				<br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category10" name="clsCode" value="C10"><label for="category10">음악</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category11" name="clsCode" value="C11"><label for="category11">자수</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category12" name="clsCode" value="C12"><label for="category12">조향/캔들/방향제</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category13" name="clsCode" value="C13"><label for="category13">취미</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category14" name="clsCode" value="C14"><label for="category14">쿠킹</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category15" name="clsCode" value="C15"><label for="category15">키즈</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category16" name="clsCode" value="C16"><label for="category16">플라워/벌룬</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category17" name="clsCode" value="C17"><label for="category17">핸드메이드</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category18" name="clsCode" value="C18"><label for="category18">기타</label>
				<br><br>
				</div>
			</div>

			<div class="opendiv2">
				<span class="span">클래스 소개글</span> 
				<input type="text" name="clsDescription" id="clsDescription"placeholder="클래스 소개글을 입력해 주세요(200자 이하)" autofocus maxlength="200">
			</div>

			<div id="divdouble">
				<div>
					<p style="font-size:18px;">클래스 썸네일 설정</p>
					<div class="thumbnail-container" id="thumbnail-container">
						<input type="file" name="file" class="file-input" id="thumbnail-input" onchange="readURL(this);"> <img id="preview" />
					</div>
				</div>

				<div>
					<p style="font-size:18px;">강사, 강의 경력</p>
					<textarea placeholder="내용을 입력해 주세요" name="clsCareer"></textarea>
				</div>
			</div>

			<div id=curri class="opendiv2">
				<p style="font-size:18px;">커리큘럼 작성</p>
				<div id="editor"></div>
				<input type="hidden" id="hidden" value="" name="clsCurri"> 
			</div>
		</div>
		<div class="btns">
		<button type="button" class="cancel-btn" onClick="window.location.reload()">초기화</button>
     	<button type="button" class="cancel-btn">취소</button>
      	<button type="submit" class="submit-btn" id="classSubmit">클래스 개설</button>
	</div>
	</form>
	</div>
	<div id="includeFooter" class="includeFooter">
			<%@ include file="../footer.jsp"%>
	</div>
	</div>	
</body>
</html>