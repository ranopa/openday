<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<style>
.contentTopMargin{
margin-top:60px;
}
.numBox{
border: 1px solid;
width: 30px;
height: 30px;
}

.tc-paging a{
text-decoration: none;
}
.tc-paging a:hover{
text-decoration-line: none;

}

.tc-paging{
display: flex;
align-items: center;
justify-content: center;}

.numBox{
margin-right: 10px;
display:flex;
align-items: center;
justify-content: center;
}

.pagenp{
color:#CFCFCF;
margin-top: 3px;

}
.pagenp:hover{
color:#8556FF;

}

.pagep{
margin-right: 8px;
}

</style>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<%@ include file="header.jsp"%>
	<div class="mainContentBigWrapper">
		<div class="mainContentWrapper">
			<div class="contentTopMargin">
				<p class="subTitle">검색결과</p>


				<hr style="margin-bottom:60px;">


			<!-- 	<div class="subOption">
					<label class="checkLabel"><input type="checkbox"
						name="color" value="blue">인기순</label> <label class="checkLabel"><input
						type="checkbox" name="color" value="blue">등록일순</label> <label
						class="checkLabel"><input type="checkbox" name="color"
						value="blue">가격높은순</label> <label class="checkLabel"><input
						type="checkbox" name="color" value="blue">가격낮은순</label>

				</div> -->

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
      <li class="oclass"><img src="img/${list.filNum}" class="ssum-img">
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
			
			<!-- <nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</nav> -->
			<div class="tc-paging">
						<c:if test="${pu.startPageNum>5 }">
							<a href="search?pageNum=${pu.startPageNum-1 }&startDate=${map.startDate}&endDate=${map.endDate}&clsCode=${map.clsCode}&clsLoc=${map.clsLoc}">
							<span class="material-symbols-outlined pagenp pagep">chevron_left</span></a>
						</c:if>

						<c:forEach var="i" begin="${pu.startPageNum }"
							end="${pu.endPageNum }">
							<c:choose>
								<c:when test="${pu.pageNum==i }">
									<!-- 현재페이지 -->
									<div class="numBox" style='color: #8556FF;'><a href="search?pageNum=${i }&startDate=${map.startDate}&endDate=${map.endDate}&clsCode=${map.clsCode}&clsLoc=${map.clsLoc}"> <span
										style='color: #8556FF; font-weight: bold'>${i }</span>
									</a></div>
								</c:when>
								<c:otherwise>
								<div class="numBox" style='color: #CFCFCF;'>
									<a href="search?pageNum=${i }&startDate=${map.startDate}&endDate=${map.endDate}&clsCode=${map.clsCode}&clsLoc=${map.clsLoc}"> <span style='color: gray;'>${i }</span>
									</a></div>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${pu.endPageNum<pu.totalPageCount }">
							<a href="search?pageNum=${pu.endPageNum+1 }&startDate=${map.startDate}&endDate=${map.endDate}&clsCode=${map.clsCode}&clsLoc=${map.clsLoc}">
							<span class="material-symbols-outlined pagenp">chevron_right</span></a>
						</c:if>
					</div>
		</div>
		</div>
		
		<%@ include file="footer.jsp"%>
</body>
</html>