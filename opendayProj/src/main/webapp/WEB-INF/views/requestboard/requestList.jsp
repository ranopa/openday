<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	@font-face {
 		font-family: 'NanumBarunGothic';
 		font-style: normal;
 		font-weight: 400;
 		src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot');
 		src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot?#iefix') format('embedded-opentype'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.woff') format('woff'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.ttf') format('truetype');
	}

	@font-face {
 		font-family: 'NanumBarunGothic';
 		font-style: normal;
		font-weight: 700;
 		src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebBold.eot');
 		src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebBold.eot?#iefix') format('embedded-opentype'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebBold.woff') format('woff'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebBold.ttf') format('truetype')
	}

	@font-face {
 		font-family: 'NanumBarunGothic';
 		font-style: normal;
 		font-weight: 300;
 		src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebLight.eot');
 		src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebLight.eot?#iefix') format('embedded-opentype'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebLight.woff') format('woff'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebLight.ttf') format('truetype');
	}
	
	* {
	    font-family: 'NanumBarunGothic', sans-serif;
		padding: 0;
		margin: 0;
	}

	#wrap {
		width: 1280px;
		margin: 0 auto;
	}

	.rl-above {
		font-size: 24px;
		color: #5A2ECE;
		margin-bottom: 20px;
		margin-left: 220px;
	}
	
	td {
		text-align: center;
	}
	
	.button {
		display: inline-block;
		padding: 5px 15px;
		background-color: #5A2ECE;
		color: white;
		font-size: 14px;
		text-decoration: none;
		border-radius: 4px;
		margin-bottom: 20px;
	}

	table {
		width: 100%;
		margin: 0 auto;
		border-collapse: collapse;
	}

	th, td {
		padding: 10px;
		font-size: 14px;
	}

	th {
		background-color: #D9D9D9;
		font-weight: bold;
	}
	
	th:nth-child(2), td:nth-child(2) {
        width: 40%;
    }

	.container {
		width: 65%;
		height: 800px;
		margin: 0 auto;
	}

	.btn1 {
		width: 65px;	
	}
	
	.pagination {
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }
    
    .pagination a {
        display: inline-block;
        padding: 5px 10px;
        margin: 0 2px;
        background-color: #D9D9D9;
        color: black;
        text-decoration: none;
        font-size: 14px;
    }
    
    .pagination a.active {
        background-color: black;
        color: #D9D9D9;
        font-size: 14px;
    }
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
	<div id="wrap">
		<h1 class="rl-above">클래스 개설 요청</h1>
		&nbsp;&nbsp;
		<div class="container">
			<div class="btn1">
				<a href="requestwrite" class="button">새 글</a>
			</div>
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회</th>
					</tr>
					<c:forEach items="${requestList}" var="request">						
					<tr>
						<td>${request.reqId}</td>
						<td><a href="${contextPath}/requestdetail?reqId=${request.reqId} ">${request.reqTitle}</a></td>
						<td>${request.userId}</td>
						<td>${request.reqDate}</td>
						<td>${request.reqViews}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="pagination">
  				<c:choose>
  					<c:when test="${pageInfo.startPage eq 1 }">
  						<a href="#">＜ 이전</a>
  					</c:when>
  					<c:otherwise>
  						<a href="${contextPath }/requestlist?page=${pageInfo.startPage-1}">＜ 이전</a>
  					</c:otherwise>
  				</c:choose>			
                <c:forEach begin="${pageInfo.startPage }" end="${pageInfo.endPage }" var="pageNumber">
                    <c:choose>
                        <c:when test="${pageNumber == pageInfo.curPage}">
                            <a href="${contextPath }/requestlist?page=${pageNumber}" class="active">${pageNumber}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${contextPath }/requestlist?page=${pageNumber}">${pageNumber}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
    			<c:choose>
    				<c:when test="${pageInfo.endPage eq pageInfo.allPage }">
  						
    					<a href="#" >다음 ＞</a>
    				</c:when>
    				<c:otherwise>
    					<a href="${contextPath}/requestlist?page=${pageInfo.endPage+1 }">다음 ＞</a>    		
    				</c:otherwise>
    			</c:choose>                
                
            </div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>