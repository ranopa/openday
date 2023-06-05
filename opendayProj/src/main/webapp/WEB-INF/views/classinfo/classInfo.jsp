<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
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
		margin: 0 auto;
	}

	#wrap {
		width: 1280px;
		margin: 0 auto;
	}

	.container {
		width: 60%;
		display: flex;
		align-items: center;
		justify-content: center;
		height: 400px;
	}

	.txt-con {
		display: flex;
		height: 100%;
		flex-direction: column;
		justify-content: space-between;
		margin-top: 40px;
	}

	.texts {
		margin-top: 40px;
	}

	.buttons {
		margin-bottom:22px;
	}

	.image {
		background-color: blue;
		height: 87%;
		width: 45%;
		margin-top: 60px;
		display: block;
		background-size: contain;
		background-image: url("resources/image/user/Laderach about.jpg");
		background-position: center;
	}

	h2 {
		font-size: 24px;
		margin-right: 200px;
	}

	p {
		font-size: 20px;
	}

	.heart-button {
		background-color: transparent;
		border: none;
		cursor: pointer; 
		color: #FF99B8;  
		height: 100%;
		position: relative;
    	top: 10px;
	}

	.heart-button.clicked {
		color: #FF99B8;
	}

	.clicked-count {
		font-size: 18px;
		margin-left: 5px;
		color: #FF99B8;
	}

	.apply-button {
		background-color: #5A2ECE;
		border: none;
		border-radius: 5px;
		color: white;
		padding: 10px 95px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 17px;
		cursor: pointer;
		margin-left: 30px;
	}

	.fixed-bar {
		margin: 0 auto;
		width: 75%;
	}

	.tab {
		display: none;
	}

	.tab.active {
		display: block;
	}

	.tab-menu {
		width: 77%;
		list-style-type: none;
		padding: 0;
		margin-top: 40px;
		margin-bottom: 20px;
		border-bottom: 1px solid #D9D9D9;
	}

	.tab-menu li {
		display: inline-block;
		cursor: pointer;
		font-size: 17px;
		color: gray;
		margin-left: 54px;
		margin-right: 25.5px;
	}

	.tab-menu li.active {
		font-weight: bold;
		border-bottom: 2.5px solid gray;
	}

	.tab-content {
		margin-top: 25px;
	}

	.material-symbols-outlined { 
		font-size: 30px;
		font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48;
	}

	.material-symbols-outlined.fill {
		font-variation-settings: 'FILL' 1, 'wght' 400, 'GRAD' 0, 'opsz' 48
	}
	
	.tab-content p {
		width: 77%;
    	font-size: 17px;
  	}
  	
  	.tab-content #reviews p {
    	width: 77%;
    	font-size: 14px;
    	border-bottom: 1px solid #D9D9D9;
    }
    
    .user-id {
    	font-weight: bold;
    }
    
    .delete-button {
		background-color: white;
		color: gray;
		padding: 1.5px 5px;
		border-radius: 2px;
		border: 1px solid gray;
		cursor: pointer;
		margin-bottom: 10px;
	}
	
	.review-star {
		font-weight: bold;
		color: yellow;
	}
</style>

<script>
	function openTab(tabId) {
		var tabs = document.getElementsByClassName('tab');
		for (var i = 0; i < tabs.length; i++) {
			tabs[i].style.display = 'none';
		}

		var menuItems = document.getElementsByClassName('tab-menu')[0]
				.getElementsByTagName('li');
		for (var j = 0; j < menuItems.length; j++) {
			menuItems[j].classList.remove('active');
		}

		document.getElementById(tabId).style.display = 'block';
		document.getElementById('menu-' + tabId).classList.add('active');
	}

	function toggleHeart() {
		var heartButton = document.getElementById('heartButton');
		var clickedCount = document.getElementById('clickedCount');
		var fileHeart = document.querySelector('.material-symbols-outlined');

		if (heartButton.classList.contains('clicked')) {
			heartButton.classList.remove('clicked');
			clickedCount.textContent = "";
			fileHeart.classList.remove('fill');
		} else {
			fileHeart.classList.add('fill');
			heartButton.classList.add('clicked');
			clickedCount.textContent = "1";
		}
	}
</script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {	
	if('${res.heart}'==1) {
		$('.material-symbols-outlined').addClass("fill");
	} else {
		$('.material-symbols-outlined').removeClass("fill");
	}
})
</script>
</head>
<body>
	<div id="wrap">

		<div class="container">
			<div class="image"><img src="./image?num=${res.clsInfo.filNum}"></div>

			<div class="txt-con">
				<div class="texts">
					<h2>${res.clsInfo.clsName} </h2>
					<br />
					<p>${res.clsInfo.price}</p>
				</div>
				<div class="buttons">
					<button id="heartButton" class="heart-button" onclick="toggleHeart()"><span class="material-symbols-outlined">favorite</span></button>
					<span id="clickedCount" class="clicked-count">${res.heartCnt}</span>
					<button class="apply-button" onclick="window.location.href='/apply'">신청하기</button>
				</div>
			</div>
		</div>

		<div class="fixed-bar">
			<div id="taps">
				<ul class="tab-menu">
					<li id="menu-introduction" class="active" onclick="openTab('introduction')">소개</li>
					<li id="menu-curriculum" onclick="openTab('curriculum')">커리큘럼</li>
					<li id="menu-instructor" onclick="openTab('instructor')">강사</li>
					<li id="menu-location" onclick="openTab('location')">장소</li>
					<li id="menu-reviews" onclick="openTab('reviews')">후기</li>
					<li id="menu-inquiry" onclick="openTab('inquiry')">문의</li>
				</ul>

				<div class="tab-content">
					<div id="introduction" class="tab active">
						<p>${res.clsInfo.clsDescription }</p>
					</div>
					<div id="curriculum" class="tab">
						<p>${res.clsInfo.clsCurri }</p>
					</div>
					<div id="instructor" class="tab">C</div>
					<div id="location" class="tab">
						<p>${res.clsInfo.scdLoc }${res.clsInfo.scdPlace }</p>
					</div>
					<div id="reviews" class="tab">
    					<c:forEach items="${res.reviewList}" var="review">
        					<p>
            					<span class="user-id">${review.userId }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            					<span class="review-date">${review.rvDate }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            					<button class="delete-button">삭제</button><br/>
            					<span class="review-star">${review.rvStar }</span><br/><br/>
            					<span class="review-content">${review.rvContent }</span><br/><br/>
        					</p>
    					</c:forEach>
					</div>
					<div id="inquiry" class="tab">
					<table border="1">
					<c:forEach items="${res.inquiryList}" var="inquiry">
						<tr>
							<td>${inquiry.ciNum }</td>
							<td>${inquiry.ciDate }</td>
							<td>${inquiry.ciTitle }</td>
							<td>${inquiry.ciContent }</td>
							<td>${inquiry.userId }</td>
						</tr>
					</c:forEach>
					</table>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>