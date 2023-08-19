<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%> 

	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
	<script src='<c:url value="/resources/js/user/main.js"/>'></script> 
 
</head>

<body>
 <jsp:include page="../header.jsp" /> 

	<div class="newList">
 
					<table class="oclassTable">
						<tr>
							<td class="oclass">
								<div class="ssum-img">이미지</div>
								<div class="txt-box">
									<div class="tb1">
										<div class="t1">
											<span>서울</span><span>|</span><span>쿠킹</span>
										</div>
										<div class="t2">
											<span><i class="bi bi-star-fill star"></i></span><span>3</span><span>(26)</span>
											<span><i class="bi bi-heart-fill heart"></i></span><span>3523</span>
										</div>
									</div>
									<p class="cls-name">클래스이름</p>
									<div class="tb2">
										<span class="oriPrice"><strike>400000원</strike></span>
										<div class="price">
											<span class="disc">20%</span> <span
												class="fp">10000 원</span>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</table>
		
			</div>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/heart.css"/>">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
 
<script src='<c:url value="/resources/js/user/heart.js"/>'></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
</head>

<body>
	<div id="heart">
		<div class="heart-content">
			<h2 class="heart-h2">찜 클래스</h2>

			<table class="oclassTable">
				<tr class=tableTr>
					<c:forEach items="${heartList}" var="list" varStatus="status">

						<td class="oclass"><a href="toclassinfofrommy/${list.clsId}" class="h-link">
								<img src="img/${list.filNum}" class="h-ssum-img"> 
							 <button class="h-btn" value="${list.clsId}"><span class=" material-symbols-outlined fill icon-custom">favorite</span></button> 
								<div class="txt-box">
									<div class="tb1">
										<div class="t1">
											<span>${list.clsLoc}</span><span>|</span><span>${list.codName}</span>
										</div>
										<div class="t2">
											<span><i class="bi bi-star-fill star"></i></span><span>${list.avgStar}</span><span>(${list.reviewCount})</span>
											<span><i class="bi bi-heart-fill heart"></i></span><span>${list.heartCnt}</span>
										</div>
									</div>
									<p class="cls-name">${list.clsName}</p>
									<div class="tb2">
										<span class="oriPrice"><strike>${list.clsPrice}원</strike></span>
										<div class="price">
											<span class="disc">${list.clsDiscount}%</span> <span
												class="fp">${list.finalPrice}원</span>
										</div>
									</div>
								</div>
						</a></td>
						<c:if test="${(status.count % 4 eq 0) and (status.last eq false)}">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>
  <jsp:include page="../footer.jsp"/> 