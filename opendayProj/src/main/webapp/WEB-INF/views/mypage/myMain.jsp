<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="id" value="${sessionScope.id }" />
<c:set var="contentPage" value='${page}' />
<%-- <c:if test="${contentPage eq value="/resources/js/user/header.js"}/>
</script> --%>

<link rel="stylesheet"
	href="<c:url value="/resources/css/user/footer.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/header.css"/>">
<link rel="shortcut icon" href="#">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div class="includeWrapper">

			<jsp:include page="../header.jsp" />
	
			<jsp:include page='${contentPage}.jsp' />
		
			<jsp:include page="../footer.jsp" />
		
	</div>
</body>
</html>
