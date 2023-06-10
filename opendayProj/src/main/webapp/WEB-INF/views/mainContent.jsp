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


.oclassListWrapper{
display: flex;
align-items: center;}

/* 선호 */
.slider-list {
	display: flex;
	padding: 0;
	margin: 0;
	transition: transform 0.5s ease-in-out;
}

.slider-list li {
	flex: 0 0 300px; /* 각 아이템의 너비 */
	list-style: none;
}

.slider-next-btn {


	transform: translateY(-50%);
	color: #B5B5B5;
}

.slider-prev-btn {

	transform: translateY(-50%);
	color: #B5B5B5;
}
/* 핫한 */

.slider-list-hot {
	display: flex;
	padding: 0;
	margin: 0;
	transition: transform 0.5s ease-in-out;
}

.slider-list-hot li {
	flex: 0 0 300px; /* 각 아이템의 너비 */
	list-style: none;
}

.slider-next-btn-hot {


	transform: translateY(-50%);
	color: #B5B5B5;
}

.slider-prev-btn-hot {

	transform: translateY(-50%);
	color: #B5B5B5;
}

/* 신규 */



.slider-list-new {
	display: flex;
	padding: 0;
	margin: 0;
	transition: transform 0.5s ease-in-out;
}

.slider-list-new li {
	flex: 0 0 300px; /* 각 아이템의 너비 */
	list-style: none;
}

.slider-next-btn-new {


	transform: translateY(-50%);
	color: #B5B5B5;
}

.slider-prev-btn-new {

	transform: translateY(-50%);
	color: #B5B5B5;
}

/* 마감임박 */



.slider-list-d {
	display: flex;
	padding: 0;
	margin: 0;
	transition: transform 0.5s ease-in-out;
}

.slider-list-d  li {
	flex: 0 0 300px; /* 각 아이템의 너비 */
	list-style: none;
}

.slider-next-btn-d  {


	transform: translateY(-50%);
	color: #B5B5B5;
}

.slider-prev-btn-d  {

	transform: translateY(-50%);
	color: #B5B5B5;
}


/* 요청 */



.slider-list-r {
	display: flex;
	padding: 0;
	margin: 0;
	transition: transform 0.5s ease-in-out;
}

.slider-list-r  li {
	flex: 0 0 300px; /* 각 아이템의 너비 */
	list-style: none;
}

.slider-next-btn-r  {


	transform: translateY(-50%);
	color: #B5B5B5;
}

.slider-prev-btn-r  {

	transform: translateY(-50%);
	color: #B5B5B5;
}
</style>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> -->


<script type="text/javascript">
/* 선호 */
	document.addEventListener("DOMContentLoaded", function() {
		const sliderContainer = document.querySelector(".slider-container");
		const sliderList = document.querySelector(".slider-list");
		const prevBtn = document.querySelector(".slider-prev-btn");
		const nextBtn = document.querySelector(".slider-next-btn");

		const itemWidth = sliderList.querySelector(".oclassP").offsetWidth;
		const containerWidth = sliderContainer.offsetWidth;
		const slideCount = sliderList.querySelectorAll(".oclassP").length;
		const maxPosition = itemWidth * slideCount - containerWidth; // 보정값 미적용
		const adjustment = 100; // 보정값: 10px
		let currentPosition = 0;

		nextBtn.addEventListener("click", function() {
			if (currentPosition < maxPosition) {
				currentPosition += itemWidth;
				sliderList.style.transform = "translateX(-"
						+ (currentPosition + adjustment) + "px)"; // 보정값 추가
			}
		});

		prevBtn.addEventListener("click", function() {
			if (currentPosition > 0) {
				currentPosition -= itemWidth;
				sliderList.style.transform = "translateX(-" + currentPosition
						+ "px)";
			}
		});
	});
	
	/* 핫한 */
	document.addEventListener("DOMContentLoaded", function() {
    const sliderContainerHot = document.querySelector(".slider-container-hot");
    const sliderListHot = document.querySelector(".slider-list-hot");
    const prevBtnHot = document.querySelector(".slider-prev-btn-hot");
    const nextBtnHot = document.querySelector(".slider-next-btn-hot");

    const itemWidthHot = sliderListHot.querySelector(".oclassHot").offsetWidth;
    const containerWidthHot = sliderContainerHot.offsetWidth;
    const slideCountHot = sliderListHot.querySelectorAll(".oclassHot").length;
    const maxPositionHot = itemWidthHot * slideCountHot - containerWidthHot; // 보정값 미적용
    const adjustmentHot = 100; // 보정값: 10px
    let currentPositionHot = 0;

    nextBtnHot.addEventListener("click", function() {
        if (currentPositionHot < maxPositionHot) {
            currentPositionHot += itemWidthHot;
            sliderListHot.style.transform = "translateX(-" + (currentPositionHot + adjustmentHot) + "px)"; // 보정값 추가
        }
    });

    prevBtnHot.addEventListener("click", function() {
        if (currentPositionHot > 0) {
            currentPositionHot -= itemWidthHot;
            sliderListHot.style.transform = "translateX(-" + currentPositionHot + "px)";
        }
    });
});
	/* 신규 */
	document.addEventListener("DOMContentLoaded", function() {
    const sliderContainerNew = document.querySelector(".slider-container-new");
    const sliderListNew = document.querySelector(".slider-list-new");
    const prevBtnNew = document.querySelector(".slider-prev-btn-new");
    const nextBtnNew = document.querySelector(".slider-next-btn-new");

    const itemWidthNew = sliderListNew.querySelector(".oclassNew").offsetWidth;
    const containerWidthNew = sliderContainerNew.offsetWidth;
    const slideCountNew = sliderListNew.querySelectorAll(".oclassNew").length;
    const maxPositionNew = itemWidthNew * slideCountNew - containerWidthNew; // 보정값 미적용
    const adjustmentNew = 100; // 보정값: 10px
    let currentPositionNew = 0;

    nextBtnNew.addEventListener("click", function() {
        if (currentPositionNew < maxPositionNew) {
            currentPositionNew += itemWidthNew;
            sliderListNew.style.transform = "translateX(-" + (currentPositionNew + adjustmentNew) + "px)"; // 보정값 추가
        }
    });

    prevBtnNew.addEventListener("click", function() {
        if (currentPositionNew > 0) {
            currentPositionNew -= itemWidthNew;
            sliderListNew.style.transform = "translateX(-" + currentPositionNew + "px)";
        }
    });
});
	
	/* 마감임박 */
	document.addEventListener("DOMContentLoaded", function() {
    const sliderContainerD = document.querySelector(".slider-container-d");
    const sliderListD = document.querySelector(".slider-list-d");
    const prevBtnD = document.querySelector(".slider-prev-btn-d");
    const nextBtnD = document.querySelector(".slider-next-btn-d");

    const itemWidthD = sliderListD.querySelector(".oclassD").offsetWidth;
    const containerWidthD = sliderContainerD.offsetWidth;
    const slideCountD = sliderListD.querySelectorAll(".oclassD").length;
    const maxPositionD = itemWidthD * slideCountD - containerWidthD; // 보정값 미적용
    const adjustmentD = 100; // 보정값: 10px
    let currentPositionD = 0;

    nextBtnD.addEventListener("click", function() {
        if (currentPositionD < maxPositionD) {
            currentPositionD += itemWidthD;
            sliderListD.style.transform = "translateX(-" + (currentPositionD + adjustmentD) + "px)"; // 보정값 추가
        }
    });

    prevBtnD.addEventListener("click", function() {
        if (currentPositionD > 0) {
            currentPositionD -= itemWidthD;
            sliderListD.style.transform = "translateX(-" + currentPositionD + "px)";
        }
    });
});
	
	/* 요청 */
	document.addEventListener("DOMContentLoaded", function() {
    const sliderContainerR = document.querySelector(".slider-container-r");
    const sliderListR = document.querySelector(".slider-list-r");
    const prevBtnR = document.querySelector(".slider-prev-btn-r");
    const nextBtnR = document.querySelector(".slider-next-btn-r");

    const itemWidthR = sliderListR.querySelector(".oclassR").offsetWidth;
    const containerWidthR = sliderContainerR.offsetWidth;
    const slideCountR = sliderListR.querySelectorAll(".oclassR").length;
    const maxPositionR = itemWidthR * slideCountR - containerWidthR; // 보정값 미적용
    const adjustmentR = 100; // 보정값: 10px
    let currentPositionR = 0;

    nextBtnR.addEventListener("click", function() {
        if (currentPositionR < maxPositionR) {
            currentPositionR += itemWidthR;
            sliderListR.style.transform = "translateX(-" + (currentPositionR + adjustmentR) + "px)"; // 보정값 추가
        }
    });

    prevBtnR.addEventListener("click", function() {
        if (currentPositionR > 0) {
            currentPositionR -= itemWidthR;
            sliderListR.style.transform = "translateX(-" + currentPositionR + "px)";
        }
    });
});
</script>


</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<div class="mainContentBigWrapper">
		<!-- <img src="resources/image/user/cookbigbanner.jpg" alt="이미지"
			style="width: 100%;"> -->
		<div class="mainContentWrapper">


			<c:if test="${plist.size() > 0 }">
				<div class="classWrapper">
					<p class="mainOclassListTitle">내가 선호하는 클래스</p>
					<div class="oclassListWrapper">
						<button class="slider-prev-btn"
							style="border: none; background-color: transparent;">
							<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_left </span>
						</button>
						<div style="width: 1280px; overflow: hidden;">
							<div class="oclassTable slider-container">
								<ul class="tableTr slider-list">
									<c:forEach items="${plist}" var="list" varStatus="loop">
										<c:if test="${loop.index < 12}">
											<a href="classinfo/${list.clsId}">
												<li class="oclass oclassP"><img src="img/${list.filNum}"
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
	<button class="slider-next-btn" style="border: none; background-color: transparent;">
		<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_right </span>
	</button>
	</div>
	</div>
	</c:if>


	<div class="classWrapper">
					<p class="mainOclassListTitle">핫한 클래스</p>
					<div class="oclassListWrapper">
						<button class="slider-prev-btn-hot"
							style="border: none; background-color: transparent;">
							<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_left </span>
						</button>
						<div style="width: 1280px; overflow: hidden;">
							<div class="oclassTable slider-container-hot">
								<ul class="tableTr slider-list-hot">
									<c:forEach items="${hlist}" var="list" varStatus="loop">
										<c:if test="${loop.index < 12}">
											<a href="classinfo/${list.clsId}">
												<li class="oclass oclassHot"><img src="img/${list.filNum}"
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
	<button class="slider-next-btn-hot" style="border: none; background-color: transparent;">
		<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_right </span>
	</button>
	</div>
	</div>

	<%-- <div class="hotClass classWrapper">
		<p class="mainOclassListTitle">핫한 클래스</p>
		<div class="oclassListWrapperHot">
			<button class="slider-prev-btn-hot"
							style="border: none; background-color: transparent;">
							<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_left </span>
						</button>
						<div style="width: 1280px; overflow: hidden;">
			<div class="oclassTable slider-container-hot">
				<ul class="tableTr slider-list-hot">
					<c:forEach items="${hlist}" var="list" varStatus="loop">
						<c:if test="${loop.index < 12}">
							<a href="classinfo/${list.clsId}">
								<li class="oclass oclassHot"><img src="img/${list.filNum}"
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
						<c:if test="${loop.index == 11}">
				</ul>
				<ul>
					</c:if>
					</c:forEach>
				</ul>
			</div>
		
		<button class="slider-next-btn-hot" style="border: none; background-color: transparent;">
		<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_right </span>
	</button>

		</div>
	</div>
 --%>


	<div class="classWrapper">
					<p class="mainOclassListTitle">신규 클래스</p>
					<div class="oclassListWrapper">
						<button class="slider-prev-btn-new"
							style="border: none; background-color: transparent;">
							<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_left </span>
						</button>
						<div style="width: 1280px; overflow: hidden;">
							<div class="oclassTable slider-container-new">
								<ul class="tableTr slider-list-new">
									<c:forEach items="${nlist}" var="list" varStatus="loop">
										<c:if test="${loop.index < 12}">
											<a href="classinfo/${list.clsId}">
												<li class="oclass oclassNew"><img src="img/${list.filNum}"
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
	<button class="slider-next-btn-new" style="border: none; background-color: transparent;">
		<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_right </span>
	</button>
	</div>
	</div>
	
	<img src="resources/image/user/cooksmallbanner.jpg" alt="이미지"
		class="smallBanner">

	
	<div class="classWrapper">
					<p class="mainOclassListTitle">마감임박 클래스</p>
					<div class="oclassListWrapper">
						<button class="slider-prev-btn-d"
							style="border: none; background-color: transparent;">
							<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_left </span>
						</button>
						<div style="width: 1280px; overflow: hidden;">
							<div class="oclassTable slider-container-d">
								<ul class="tableTr slider-list-d">
									<c:forEach items="${dlist}" var="list" varStatus="loop">
										<c:if test="${loop.index < 12}">
											<a href="classinfo/${list.clsId}">
												<li class="oclass oclassD"><img src="img/${list.filNum}"
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
	<button class="slider-next-btn-d" style="border: none; background-color: transparent;">
		<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_right </span>
	</button>
	</div>
	</div>
	

	<div class="classWrapper">
					<p class="mainOclassListTitle">요청 클래스</p>
					<div class="oclassListWrapper">
						<button class="slider-prev-btn-r"
							style="border: none; background-color: transparent;">
							<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_left </span>
						</button>
						<div style="width: 1280px; overflow: hidden;">
							<div class="oclassTable slider-container-r">
								<ul class="tableTr slider-list-r">
									<c:forEach items="${rlist}" var="list" varStatus="loop">
										<c:if test="${loop.index < 12}">
											<a href="classinfo/${list.clsId}">
												<li class="oclass oclassR"><img src="img/${list.filNum}"
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
	<button class="slider-next-btn-r" style="border: none; background-color: transparent;">
		<span class="material-symbols-outlined" style="font-size: 35px;"> chevron_right </span>
	</button>
	</div>
	</div>


	</div>
	</div>




</body>
</html>