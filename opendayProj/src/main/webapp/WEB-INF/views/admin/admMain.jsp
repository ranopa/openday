<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="contextPath" value="<%=request.getContextPath() %>"/>
	<c:set var="contentPage" value="${page}"/>
	<c:if test="${contentPage eq null }">
	<c:set var = "contentPage" value='adminWaitingList.jsp'/>
	</c:if>

<%-- 	<c:set var="id" value="${sessionScope.id}"/> 
	<c:set var="contentPage" value="${page}"/>
	<c:choose>
		<c:when test ="${id eq null}">
			<c:if test="${contentPage eq null or contentPage ne 'join.jsp'}">
				<c:set var="contentPage" value="login.jsp"/>
			</c:if>
		</c:when>
		<c:otherwise>
		<c:if test="${contentPage eq null }">
			<c:set var = "contentPage" value='makeAccount.jsp'/>
		</c:if>
		
		</c:otherwise>
	</c:choose> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/adm/admHeader.css"> 
</head>
<body>
<table style="width:1280px">
		<thead>
			<tr> 
				<td><jsp:include page="admHeader.jsp"/></td> 
			</tr>
		</thead>
		<tbody> 
			<tr style="padding-top: 20px"> 
				<td><jsp:include page='${contentPage}'/></td> 
			</tr>
		</tbody>
	</table>
</body>
</html>