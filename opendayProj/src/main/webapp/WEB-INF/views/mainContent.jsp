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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />





<style>
   /*   .mainContentWrapper {
	white-space: nowrap;
}      */

.slider-container {
  position: relative;
  overflow: hidden;
}

.slider-list {
  display: flex;
  padding: 0;
  margin: 0;
  transition: transform 0.5s ease-in-out;
}

.slider-list li {
  flex: 0 0 260px; /* 각 아이템의 너비 */
  list-style: none;
}

.slider-next-btn {
  position: absolute;
  right: 260px;
  top: 50%;
  transform: translateY(-50%);
}

.slider-prev-btn {
  position: absolute;
  left: 10px;
  top: 50%;
  transform: translateY(-50%);

</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> -->


<script type="text/javascript">

document.addEventListener("DOMContentLoaded", function() {
	  const sliderList = document.querySelector(".slider-list");
	  const prevBtn = document.querySelector(".slider-prev-btn");
	  const nextBtn = document.querySelector(".slider-next-btn");

	  const itemWidth = sliderList.querySelector(".oclass").offsetWidth;
	  let currentPosition = 0; // 현재 위치

	  nextBtn.addEventListener("click", function() {
	    currentPosition += itemWidth;
	    sliderList.style.transform = `translateX(-${currentPosition}px)`;
	  });

	  prevBtn.addEventListener("click", function() {
	    currentPosition -= itemWidth;
	    sliderList.style.transform = `translateX(-${currentPosition}px)`;
	  });
	});

</script>




</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<div class="mainContentBigWrapper">
		<!-- <img src="resources/image/user/cookbigbanner.jpg" alt="이미지"
			style="width: 100%;"> -->
		<div class="mainContentWrapper">

			<%-- <table class="mainMenuTable">
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
			</table> --%>


			<!-- 		<div class="newListWrapper">
			<div class="newList"> -->
			
			
				<button class="slider-prev-btn">이전</button>
				<button class="slider-next-btn">다음</button>
			
			
			<c:if test="${plist.size() > 0 }">
				<div class="myList classWrapper">
					<p class="mainOclassListTitle">내가 선호하는 클래스</p>
					<div class="oclassListWrapper">
					
					
						<div class="oclassTable slider-container">
							<ul class="tableTr slider-list" >
								<c:forEach items="${plist}" var="list" varStatus="loop">
									<c:if test="${loop.index < 12}">
										<a href="classinfo/${list.clsId}">
											<li class="oclass"><img src="img/${list.filNum}"
												class="ssum-img">
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
												</div></li>
										</a>
									</c:if>
									<c:if test="${loop.index ==11}">
							</ul>
							<ul>
								</c:if>
								</c:forEach>
							</ul>
						</div>
				
	
					</div>
				</div>
			</c:if>
			<!-- 	</div>
	
			</div> -->

 


			<div class="hotClass classWrapper">
				<p class="mainOclassListTitle">핫한 클래스</p>
				<div class="oclassListWrapper">
					<!-- <div class="arrowIcon">
					<div class="material-symbols-outlined">
						<a href="#"> arrow_back_ios </a>
					</div>
				</div> -->
					<div class="oclassTable">
						<ul class="tableTr">
							<c:forEach items="${hlist}" var="list" varStatus="loop">
								<c:if test="${loop.index < 4}">
									<a href="classinfo/${list.clsId}">
										<li class="oclass"><img src="img/${list.filNum}"
											class="ssum-img">
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
											</div></li>
									</a>
								</c:if>
								<c:if test="${loop.index == 3}">
						</ul>
						<ul>
							</c:if>
							</c:forEach>
						</ul>
					</div>
					<!-- <div class="arrowIcon">
					<div class="material-symbols-outlined arrow">
						<a href="#">arrow_forward_ios</a>
					</div>
				</div> -->
				</div>
			</div>


		
			<div class="newClass classWrapper">
				<p class="mainOclassListTitle">신규 클래스</p>
				<div class="oclassListWrapper">

					<div class="oclassTable">
						<ul class="tableTr" style="overflow: hidden;">
							<c:forEach items="${nlist}" var="list" varStatus="loop">
								<c:if test="${loop.index < 4}">
									<a href="classinfo/${list.clsId}">
										<li class="oclass"><img src="img/${list.filNum}"
											class="ssum-img">
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
											</div></li>
									</a>
								</c:if>
								<c:if test="${loop.index == 3}">
						</ul>
						<ul>
							</c:if>
							</c:forEach>
						</ul>
					</div>

				</div>
			</div>
			<img src="resources/image/user/cooksmallbanner.jpg" alt="이미지"
				class="smallBanner">

			<div class="imminentDeadlineClass classWrapper">
				<p class="mainOclassListTitle">마감임박 클래스</p>
				<div class="oclassListWrapper">
					<!-- <div class="arrowIcon">
					<div class="material-symbols-outlined">
						<a href="#"> arrow_back_ios </a>
					</div>
				</div> -->
					<div class="oclassTable">
						<ul class="tableTr">
							<c:forEach items="${dlist}" var="list" varStatus="loop">
								<c:if test="${loop.index < 4}">
									<a href="classinfo/${list.clsId}">
										<li class="oclass"><img src="img/${list.filNum}"
											class="ssum-img">
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
											</div></li>
									</a>
								</c:if>
								<c:if test="${loop.index == 3}">
						</ul>
						<ul>
							</c:if>
							</c:forEach>
						</ul>
					</div>
					<!-- <div class="arrowIcon">
					<div class="material-symbols-outlined arrow">
						<a href="#">arrow_forward_ios</a>
					</div>
				</div> -->
				</div>
			</div>

			<div class="requestClass classWrapper">
				<p class="mainOclassListTitle">요청 클래스</p>
				<div class="oclassListWrapper">
					<!-- <div class="arrowIcon">
					<div class="material-symbols-outlined">
						<a href="#"> arrow_back_ios </a>
					</div>
				</div> -->
					<div class="oclassTable">
						<ul class="tableTr">
							<c:forEach items="${rlist}" var="list" varStatus="loop">
								<c:if test="${loop.index < 4}">
									<a href="classinfo/${list.clsId}">
										<li class="oclass"><img src="img/${list.filNum}"
											class="ssum-img">
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
											</div></li>
									</a>
								</c:if>
								<c:if test="${loop.index == 3}">
						</ul>
						<ul>
							</c:if>
							</c:forEach>
						</ul>
					</div>
					<!-- <div class="arrowIcon">
					<div class="material-symbols-outlined arrow">
						<a href="#">arrow_forward_ios</a>
					</div>
				</div> -->
				</div>
			</div>


		</div>
	</div>


</body>
</html>