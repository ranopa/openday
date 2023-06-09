<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="adm-inquiry-detail">
	<div class="container">
		<h2>문의목록</h2>
		<div class="page">
			<form action="" , method="post">
				<table class="table">
					<tbody>
						<tr>
							<td class="td1 bold">아이디</td>
							<td class="td2 t22">${inquiry.userId}</td>
						</tr>
						<tr>
							<td class="td1 bold">분류</td>
							<td class="td2 t22">${inquiry.admType}</td>
							<td class="td1 bold">답변상태</td>
							<c:choose>
								<c:when test="${inquiry.admStatus eq true}">
									<td class="td2 t22">답변완료</td>
								</c:when>
								<c:otherwise>
									<td class="td2 t22">답변대기</td>
								</c:otherwise>
							</c:choose>

						</tr>
						<tr>
							<td class="td1 bold">등록일</td>
							<td class="td2 t22">${inquiry.admUploadDate}</td>
							<td class="td1 bold">답변일</td>
							<c:choose>
								<c:when test="${inquiry.admAnDate eq null}">
									<td class="td2 t22">-</td>
								</c:when>
								<c:otherwise>
									<td class="td2 t22">${inquiry.admAnDate}</td>
								</c:otherwise>
							</c:choose>

						</tr>
						<tr>
							<td class="td1 bold">제목</td>
							<td colspan="3" class="td2 t22">${inquiry.admTitle}</td>
						</tr>
						<tr class="txtbox">
							<td class="td1 bold">내용</td>
							<td colspan="3" class="td2 txtarea">${inquiry.admContent}</td>
						</tr>
						<tr class="txtbox">
							<td class="td1 bold">답변</td>
							<td colspan="3" class="td2"><textarea type="text"
									name="answer" maxlength="1000" class="txtarea txt-ip" required
									readonly>${inquiry.admAnContent}</textarea></td>
						</tr>
					</tbody>
				</table>
				<div class="btn-par">
					<button type="button" id="inquiry-detail" class="submit-btn btn1">목록으로</button>
					<c:if test="${inquiry.admAnContent eq null}">
						<button type="submit" class="submit-btn btn2">답변완료</button>
					</c:if>
				</div>
				<script>
				 $('#inquiry-detail').click(()=>{ 
					 location.href="/openday/adminquirylist";
				 })
				</script>

			</form>
		</div>
	</div>
</div>