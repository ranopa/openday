<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/js/user/subClassList.js"/>'></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/subClassList.css"/>">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" />



</head>
<%@ include file="header.jsp"%>
<body>

	<div class="mainContentBigWrapper">
		<div class="mainContentWrapper">
			
			<p class="subTitle">검색결과</p>
			

			<hr>
			

			<div class="subOption">
				<label class="checkLabel"><input type="checkbox" name="color" value="blue">인기순</label>
				<label class="checkLabel"><input type="checkbox" name="color" value="blue">등록일순</label>
				<label class="checkLabel"><input type="checkbox" name="color" value="blue">가격높은순</label>
				<label class="checkLabel"><input type="checkbox" name="color" value="blue">가격낮은순</label>

			</div>
			
			<div class="oclassListWrapper">
				<!-- <div class="arrowIcon">
					<div class="material-symbols-outlined">
						<a href="#"> arrow_back_ios </a>
					</div>
				</div> -->
				<%-- <div class="oclassTable">
					<ul class="tableTr">
						<c:forEach items="${collectList}" var="list" varStatus="loop">
							<c:if test="${loop.index < 4}">
								<li class="oclass">
									<div class="ssum-img">${list.filNum}</div>
									<div class="txt-box">
										<div class="tb1">
											<div class="t1">
												<span>${list.clsLoc}</span><span>|</span><span>${list.codName}</span>
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
												<span class="disc">${list.clsDiscount}%</span> <span
													class="fp">${list.finalPrice}원</span>
											</div>
										</div>
									</div>
								</li>
							</c:if>
							<c:if test="${loop.index == 3}">
					</ul>
					<ul>
						</c:if>
						</c:forEach>
					</ul>
				</div>
 --%>

<div class="oclassTable">
  <c:forEach items="${collectList}" var="list" varStatus="loop">
    <c:if test="${loop.index % 4 == 0}">
      <ul class="tableTr">
    </c:if>
    <a href="classinfo/${list.clsId}">
    <li class="oclass">
     <img src="img/${list.filNum}" class="ssum-img">
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
            <span class="disc">${list.clsDiscount}%</span> <span class="fp">${list.finalPrice}원</span>
          </div>
        </div>
      </div>
    </li>
    </a>
    <c:if test="${(loop.index + 1) % 4 == 0 || loop.last}">
      </ul>
    </c:if>
  </c:forEach>
</div>

			<%-- 	<div class="newList">

					<c:forEach items="${collectList}" var="list">
						<table class="oclassTable">
							<tr>
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
							</tr>
						</table>
					</c:forEach>
				</div> --%>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
</body>
</html>