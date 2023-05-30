<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="<%=request.getContextPath() %>" />
<c:set var="num" value="<%=1 %>"/>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- UIkit CSS & JS -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/uikit@3.16.17/dist/css/uikit.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/uikit@3.16.17/dist/js/uikit.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/uikit@3.16.17/dist/js/uikit-icons.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/user/myprefer.css">
<script src="${contextPath}/resources/js/user/myPrefer.js"></script>
<body>

<form action="prefer" method="post">

	<div class="pre-wrap">
		<h2>나의 취향 고르기</h2>
		<div class="preferbox">
			<div class="mypick">
			 	<h3>내가 선택한 카테고리</h3>
				<%--<c:choose>
					<c:when>
					
					</c:when>
					<c:otherwise>
				
				</c:otherwise>
				</c:choose> --%>
				<table class="e-flex">
					<tr>
						<td>
						<%-- <c:forEach items="${userPreferList}" var="upl"> --%>
							<button type="button" class="checked" name="prefer">${upl.userPrefer}</button>
						<%-- </c:forEach> --%>
						</td> 
					</tr>
				</table>
			</div>
			<!-- <table class="e-flex"> -->
			<%--                <div class="flex-box">
      			<c:forEach items="${cateNames}" var="ctgr"> 	
                     <button type="button" class="unchecked" name="prefer">${ctgr.codName}</button>
                </c:forEach> --%>

			<div class="repick">
				<h3>다시 선택하기</h3>
			
			<!-- </table> -->
			<table class="e-flex">
				<tr>
					<c:forEach items="${cateNames}" var="ctgr" varStatus="status">
						<td><button type="button" class="category-btn unchecked" name="checkboxGroup" value="${ctgr.codName}">${ctgr.codName}</td>
<%-- 						<td><input type="checkbox" class="unchecked" name="checkboxGroup" value="C+${status}" onclick="return limitCheckboxes('group', 3)">${ctgr.codName}</td> --%>
						<c:if test="${(status.count % 5 eq 0) and (status.last eq false)}">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
			</table>

		</div>
		<button type="submit" class="submit-btn">적용하기</button>
	</div>
	</div>
</form>
</body>

</html>