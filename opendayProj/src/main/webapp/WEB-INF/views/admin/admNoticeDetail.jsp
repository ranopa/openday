<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>  
<div id="notice-detail">
	<form action="${contextPath}/admnoticedelete" method="get">
		<div class="w-modal">
			<div class="w-wrap">
				<div class="w-txtbox">
					<p class="w-p">정말 이 게시글을 삭제하시겠습니까?</p>
				</div>
				<div class="w-btn-box">
					<button id="go-back-btn" type="button" class="w-submit-btn">취소하기</button>
					<input id="real-del-btn" type="submit" class="w-cancel-btn" value="삭제하기" >
				</div>
			</div>
		</div>
	</form>
	<div class="container">
		<h2>공지</h2>
		<div class="page">
			<form action="${contextPath }/admnoticedelete" method="get">
				<table class="table">
					<tbody>
						<tr>
							<td class="td1 bold">유형</td>
							<td colspan="2" class="radios t22">${anc.ancType}</td>
						</tr>
						<tr>
							<td class="td1 bold">제목</td>
							<td colspan="3" class="td2 t22">${anc.ancTitle}</td>
						</tr>
						<!-- <tr>
							<td class="td1 bold">첨부파일</td>
							<td colspan="3"><a href="#" download class="file-down"></a>
								첨부파일이름</td>
						</tr> -->
						<tr class="txtbox">
							<td class="td1 bold">내용</td>
							<td colspan="3" class="td2 txt-content">${anc.ancContent}</td>
						</tr>

					</tbody>
				</table> 
				<div class="btn-par">
					<button type="button" class="submit-btn btn2" id="go-list">목록으로</button>
					<button type="submit" class="submit-btn btn1" id="del-btn">삭제</button>
				</div>
				<input type="hidden" name="ancId" value="${anc.ancId}"> 
			</form>
		</div>
	</div>
<script> 
var goListBtn = document.querySelector('#go-list');

goListBtn.addEventListener('click',()=>{
	location.href="../admnoticelist";
})



</script>

</div>

