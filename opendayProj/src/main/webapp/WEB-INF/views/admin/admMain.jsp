<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contentPage" value="${page}" />
<c:if test="${contentPage eq null }">
	<c:set var="contentPage" value='admWaitingList' />
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
<!-- 외부 -->

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href='<c:url value="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>'>

<!-- jQuery UI CSS 임포트 -->

<script src="resources/js/teacher/jquery-3.1.1.min.js"></script>
<!-- Air datepicker css -->
<script src="resources/js/teacher/datepicker.js"></script>
<script src="resources/js/teacher/datepickerSetting.js"></script>
<!-- Air datepicker js -->
<script src="resources/js/teacher/datepicker.ko.js"></script>
<link rel="stylesheet"
	href='<c:url value="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>'>

<!-- jQuery 및 jQuery UI JavaScript 임포트 -->
<script
	src="<c:url value="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/>"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<!-- css -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admHeader.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admWaitingList.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admClassList.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admSettleWaitingList.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admSettleRecordList.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admUserList.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admInquiryList.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admInquiryDetail.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admNoticeList.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admNoticeWrite.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admNoticeDetail.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admSalesList.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admSettleDetail.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/adm/admWaitingDetail.css"/>'>
<!-- js -->
<script src="<c:url value="/resources/js/adm/admHeader.js"/>"></script>
<script src="<c:url value="/resources/js/adm/admSettleRecordList.js"/>"></script>
<script src="<c:url value="/resources/js/adm/admClassList.js"/>"></script>
<script src="<c:url value="/resources/js/adm/admUserList.js"/>"></script>
<script src="<c:url value="/resources/js/adm/admUserList.js"/>"></script>
<script src="<c:url value="/resources/js/adm/admNoticeList.js"/>"></script>
<script src="<c:url value="/resources/js/adm/admNoticeWrite.js"/>"></script>
<script src="<c:url value="/resources/js/adm/admNoticeDetail.js"/>"></script>
<style>
* {
	padding: 0;
	margin: 0;
}
</style>
</head>
<body>
	<jsp:include page="admHeader.jsp" />
	<jsp:include page='${contentPage}.jsp' />

</body>
</html>