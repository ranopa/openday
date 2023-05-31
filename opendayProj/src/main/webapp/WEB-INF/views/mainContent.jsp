<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src='<c:url value="/resources/js/user/mainContent.js"/>'></script>
	<link rel="stylesheet"
		href="<c:url value="/resources/css/user/mainContent.css"/>">
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" />
</head>
<body>
	<div class="mainContentBigWrapper">
		<div class="mainContentWrapper">

			<table class="mainMenuTable">
				<c:forEach items="${codeList}" var="code" varStatus="loop">
					<c:if test="${loop.index % 5 == 0}">
						<tr>
					</c:if>
					<c:if test="${loop.index == 0}">
						<td>
							<button type="button" class="mainCategoryButton"
								name="categoryButton" value="all">전체</button>
						</td>
					</c:if>
					<c:if test="${loop.index > 0 and loop.index <= 4}">
						<td>
							<button type="button" class="mainCategoryButton"
								name="categoryButton" value="${code.codNum}">${code.codName}</button>
						</td>
					</c:if>
					<c:if test="${loop.index > 4}">
						<td>
							<button type="button" class="mainCategoryButton"
								name="categoryButton" value="${code.codNum}">${code.codName}</button>
						</td>
					</c:if>
					<c:if test="${loop.index % 5 == 4 or loop.last}">
						</tr>
					</c:if>
				</c:forEach>
			</table>

			<div class="newListWrapper">
				<div class="newList">
					<table class="oclassTable">
						<tr class=tableTr>
							<c:forEach items="${nlist}" var="list" varStatus="loop">
								<c:if test="${loop.index < 8}">
									<td class="oclass">
										<div class="ssum-img">${list.filNum}</div>
										<div class="txt-box">
											<div class="tb1">
												<div class="t1">
													<span>${list.scdLoc}</span><span>|</span><span>${list.codName}</span>
												</div>
												<div class="t2">
													<span><i class="bi bi-star-fill star"></i></span><span>${list.clsStar}</span><span>(${list.reviewCount})</span>
													<span><i class="bi bi-heart-fill heart"></i></span><span>${list.clsHeart}</span>
												</div>
											</div>
											<p class="cls-name">${list.clsName}</p>
											<div class="tb2">
												<span class="oriPrice"><strike>${list.clsPrice}원</strike></span>
												<div class="price">
													<span class="disc">${list.scdDiscount}%</span> <span
														class="fp">${list.finalPrice}원</span>
												</div>
											</div>
										</div>
									</td>
								</c:if>
								<c:if test="${loop.index == 7}">
						</tr>
						<tr>
							</c:if>
							</c:forEach>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>