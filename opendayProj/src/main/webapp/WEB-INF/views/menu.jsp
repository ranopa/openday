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
	href="<c:url value="/resources/css/user/menu.css"/>">
	<link rel="stylesheet"
	href="<c:url value="/resources/css/user/subClassList.css"/>">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" />

<style>
.menuContentW{
margin-top:60px;
width: 1280px;
margin-left:auto;
margin-right:auto;
}
.oclassListWrapper{
margin-top: 55px;
}

 
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<%@ include file="header.jsp"%>
	<div class="menuContentBigWrapper">
		<div class="menuContentWrapper">
	<div class="menuContentW">
			<p class="subTitle">${hcn}</p>
			

			<hr>
			
			
			</div>
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
  <c:forEach items="${hMenuList}" var="list" varStatus="loop">
    <c:if test="${loop.index % 4 == 0}">
      <ul class="tableTr">
    </c:if>
    <li class="oclass">
    <a href="classinfo/${list.clsId}">
    	<img src="img/${list.filNum}" class="ssum-img" alt="클래스대표이미지">
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
          <span class="oriPrice"><del>${list.clsPrice}원</del></span>
          <div class="price">
            <span class="disc">${list.clsDiscount}%</span> <span class="fp">${list.finalPrice}원</span>
          </div>
        </div>
      </div>
    </a>
    </li>
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
			
				<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</nav>
			
		</div>
		</div>
		
		<%@ include file="footer.jsp"%>
</body>
</html>