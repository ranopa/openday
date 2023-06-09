<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
		margin-left: 80px;
	}

	.buttons {
		margin-bottom: 22px;
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
		width: 75%;
		list-style-type: none;
		padding: 0;
		border-bottom: 1px solid #D9D9D9;
		margin: 0 auto;
		display: flex;
		justify-content: space-evenly;
		align-items: center;
		margin-top: 40px;
	}

	.tab-menu li {
		display: inline-block;
		cursor: pointer;
		font-size: 17px;
		color: gray;
		margin-left: 24px;
		margin-right: 24px;
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
		margin: 0 auto;
		width: 72%;
    	font-size: 17px;
  	}
  	
  	.tab-content #reviews p {
    	width: 72%;
    	margin-top: 20px;
    	font-size: 14px;
    	border-bottom: 1px solid #D9D9D9;
    }
    
    .user-id {
    	font-weight: bold;
    }
    
    .delete-button {
		background-color: white;
		color: gray;
		font-size: 12.5px;
		padding: 0.5px 4px;
		border-radius: 2px;
		border: 1px solid gray;
		cursor: pointer;
		margin-bottom: 10px;
	}
	
	.review-star {
		font-weight: bold;
		color: yellow;
	}
	
	.tab-content #instructor {
		margin: 0 auto;
		width: 72%;
	}
	
	.instructor-button {
    	display: inline-block;
    	background-color: white;
    	color: gray;
    	padding: 50px 80px;
    	border: 1px solid gray;
		cursor: pointer;
    	text-decoration: none;
    	font-size: 18px;
    	border-radius: 5px;
	}
	
	.btn.btn-primary {
		background-color: gray !important;
		border-radius: 5px;
		color: white;
		padding: 5px 15px;
		border: none;
		font-size: 16px;
		cursor: pointer;
	}
	
	.btn.btn-primary:not(:active) {
    	background-color: gray;
  	}
	
	.edit-button {
		background-color: white;
		color: gray;
		font-size: 12.5px;
		padding: 0.5px 4px;
		border-radius: 2px;
		border: 1px solid gray;
		cursor: pointer;
	}
	
	.tab-content #inquiry p {
    	font-size: 14px;
    }
    
    .inquiry .user-id {
    	font-weight: bold;
    }
    
    .instructor-id {
    	font-weight: bold;
    }
    
    .response {
    	width: 710px;
  		height: 110px;
  		background-color: #D9D9D9;
  		border-radius: 4px;
    }
    
    .modal-header, .modal-footer {
        border: none;
    }
    
    .modal-content {
    	height: auto;
    }
    
    .modal-title {
        font-size: 20px;
        font-weight: bold;
        color: gray;
    }
    
    .modal-footer .btn.btn-danger {
        background-color: gray;
        color: white;
        border: none;
        font-size: 16px;
        margin-left: 350px;
    }
    
    .modal-header .btn-close {
    	margin-left: 350px;
    }
    
    .secret-opt {
    	color: gray;
    }
    
    .modal-body {
    	position: relative;
    	padding: 0;
    }
    
    textarea {
    	height: 250px;
    	width: 80%;
    	margin-left: 150.5px;
    	transform: translateX(-24.9%);
    	border: 1px solid #D9D9D9;
    	margin-top: 10px;
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


</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	let heartYN = '${res.heart}';
	function heartFill(heart) {
		if(heart==1) {
			$('.material-symbols-outlined').addClass("fill");
		} else {
			$('.material-symbols-outlined').removeClass("fill");
		}
	}
	
	heartFill(heartYN);
	
	$("#heartButton").click(function() {

		$.ajax({
			url:"${contextPath}/heart",
			method:"POST",
			async:true,
			data:{clsId:'${res.clsInfo.clsId}'},
			success:function(res) {
				if(heartYN==1) {
					heartYN=0;
				} else {
					heartYN=1;
				}
				heartFill(heartYN);
				$("#clickedCount").text(res);
			}
		})
	})
	
	$("#inquiryBtn").click(function() {
		$.ajax({
			url:"${contextPath}/clsinquiry",
			method:"POST",
			async:true,
			data:{clsId:'${res.clsInfo.clsId}',
				  ciContent:$("#ciContent").val(),
				  ciSecret:$("#ciSecret").is(':checked')
				  },
			success:function(res) {
				alert(res);
			}
		})
		
	})
	
	let editBtn;
	$(".edit-button").click(function() {
		editBtn = $(this);
		ciNum = editBtn.data("cinum")
		$("#ciModContent").val($('#ct'+ciNum).text());
		
		if($(this).data("cisecret")==true) {
			$("#ciModSecret").prop("checked", true);
		} else {
			$("#ciModSecret").prop("checked", false);
		}
	})
	
	$("#modInquiryBtn").click(function() {
		$.ajax({
			url:"${contextPath}/modClsInquiry",
			method:"POST",
			async:true,
			data:{ciNum:editBtn.data("cinum"),
				  ciContent:$("#ciModContent").val(),
				  ciSecret:$("#ciModSecret").is(':checked')
				  },
			success:function(res) {
				if(res==true) {
					$('#ct'+ciNum).text($("#ciModContent").val());
					editBtn.data("cisecret", $("#ciModSecret").is(':checked'));
				}
			}
		})
		
	})	
	
	$(".delete-button").click(function() {
		let rvNum = $(this).data("reviewnum")
		console.log(rvNum);
		$.ajax({
			url:"${contextPath}/removeReview",
			method:"POST",
			async:true,
			data:{rvNum:rvNum},
			success:function(res) {
				console.log($('#p'+$(this).data("reviewnum")));
				if(res==true) {
					$('#p'+rvNum).remove();
				}
			}
		})		
	})
})
</script>
</head>
<body>
	<div id="wrap">

		<div class="container">
			<div class="image"><img src="${contextPath}/img/${res.clsInfo.filNum}" style="width: 350px;"></div>

			<div class="txt-con">
				<div class="texts">
					<h2>${res.clsInfo.clsName}</h2>
					<br/>
					<p>${res.clsInfo.price}</p>
				</div>
				<div class="buttons">
					<button id="heartButton" class="heart-button"><span class="material-symbols-outlined">favorite</span></button>
					<span id="clickedCount" class="clicked-count">${res.heartCnt}</span>
					<button class="apply-button" onclick="window.location.href='${contextPath}/apply/${res.clsInfo.clsId}'">신청하기</button>
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
					<div id="instructor" class="tab">
						<a href="${contextPath}/../${res.teacherChannel.tchcNum}" class="instructor-button">채널 바로가기&nbsp;&nbsp;&nbsp;＞</a>
					</div>
					<div id="location" class="tab">
    					<c:forEach items="${res.scheduleList}" var="schedule">
    						<p>
								<span>${schedule.scdDate}</span>&nbsp;&nbsp;
								<span>${schedule.scdTime}</span>&nbsp;&nbsp;
								<span>${schedule.scdPlace}</span>&nbsp;&nbsp;
								<span>${schedule.scdPlaceDetail}</span>
							</p>
						</c:forEach>
					</div>
					<div id="reviews" class="tab">
    					<c:forEach items="${res.reviewList}" var="review">
        					<p id='p${review.rvNum}'>
            					<span class="user-id">${review.userId }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            					<span class="review-date">${review.rvDate }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            					<c:if test="${user.userId==review.userId}">
            					<button class="delete-button" data-reviewnum=${review.rvNum }>삭제</button><br/>
            					</c:if>
            					<span class="review-star">${review.rvStar }</span><br/><br/>
            					<span class="review-content">${review.rvContent }</span><br/><br/>
        					</p>
    					</c:forEach>
					</div>
					<div id="inquiry" class="tab">
						<p>
							<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">문의하기</button><br/><br/>
						</p>
									
						<div class="modal" id="myModal">
  							<div class="modal-dialog">
    							<div class="modal-content">
     								<div class="modal-header">
        								<h4 class="modal-title">문의 작성</h4>
        								<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      								</div>
      								
      								<div class="modal-body"><textarea id="ciContent"></textarea></div>
      								
      								<div class="modal-footer">
      								  	<input type="checkbox" id="ciSecret" name="ciSecret" value="true">
      								  		<span class="secret-opt">비밀글</span>
										<button type="button" class="btn btn-danger" data-bs-dismiss="modal" id="inquiryBtn">작성 완료</button>
      								</div>
      							</div>
  							</div>
						</div>
						
						<c:forEach items="${res.inquiryList}" var="inquiryAndAnswer">
							<p>
								<span class="user-id">${inquiryAndAnswer.clsInquiry.userId }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span>${inquiryAndAnswer.clsInquiry.ciDate }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<c:choose>
								<c:when test="${user.userId==inquiryAndAnswer.clsInquiry.userId}">
									<button class="edit-button" data-bs-toggle="modal" data-bs-target="#modifyModal"
										data-cinum="${inquiryAndAnswer.clsInquiry.ciNum}"
										data-cisecret="${inquiryAndAnswer.clsInquiry.ciSecret}">수정</button><br/><br/>
									<span id='ct${inquiryAndAnswer.clsInquiry.ciNum}'>${inquiryAndAnswer.clsInquiry.ciContent }</span><br/><br/>
								</c:when>
								<c:when test="${inquiryAndAnswer.clsInquiry.ciSecret==false}">
									<span>${inquiryAndAnswer.clsInquiry.ciContent }</span><br/><br/>
								</c:when>
								<c:otherwise>
									<span>비밀글입니다.</span><br/><br/>
								</c:otherwise>
								</c:choose>
							</p>
							
							<c:if test="${inquiryAndAnswer.answer!=null}">
							<div class="response">
							<p>
								<br/>
								<span>${inquiryAndAnswer.answer.ansDate }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
								<c:choose>
								<c:when test="${user.userId==inquiryAndAnswer.clsInquiry.userId or 
											inquiryAndAnswer.clsInquiry.ciSecret==false}">
									<span>${inquiryAndAnswer.answer.ansContent }</span><br/><br/>
								</c:when>
								<c:otherwise>
									<span>비밀글입니다.</span><br/><br/>
								</c:otherwise>
								</c:choose>
							</p>	
							</div>	
							</c:if>	
							<br/>				
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
<!-- 	수정하기 모달 -->
	<div class="modal" id="modifyModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">문의 수정</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<div class="modal-body">
					<textarea id="ciModContent"></textarea>
				</div>

				<div class="modal-footer">
					<input type="checkbox" id="ciModSecret" name="ciModSecret" value="true">
					<span class="secret-opt">비밀글</span>
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal" id="modInquiryBtn">수정 완료</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>