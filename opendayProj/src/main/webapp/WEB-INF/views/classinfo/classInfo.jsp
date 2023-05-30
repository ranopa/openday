<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		margin: 0 auto;
	}

	#wrap {
		width: 1280px;
		margin: 0 auto;
	}
	
	.container {
		display: flex;
		align-items: center;
		justify-content: center;
	}
	
	.image {
        margin-right: 400px;
    }
    
	h2 {
        font-size: 27px;
    }

    p {
        font-size: 27px;
    }
    
    .buttons {
        margin-top: 300px;
    }

    .heart-button {
        background-color: transparent;
        border: none;
        cursor: pointer;
        font-size: 24px;
        color: #FF99B8;
        margin-right: 10px;
    }

    .apply-button {
        background-color: #5A2ECE;
        border: none;
        border-radius: 5px;
        color: white;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 20px;
        cursor: pointer;
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
    	width: 95%;
        list-style-type: none;
        padding: 0;
        margin-top: 50px; 
        margin-bottom: 20px;
        border-bottom: 1px solid #D9D9D9;
    }

    .tab-menu li {
        display: inline-block;
        margin-left: 5px; 
        cursor: pointer;
        font-size: 20px;
        color: gray;
        margin-left: 50px;
        margin-right: 50px;
    }

    .tab-menu li.active {
        font-weight: bold;
        border-bottom: 2.5px solid gray;
    }
    
    .tab-content {
        margin-top: 25px;
    }
</style>
<script>
	function openTab(tabId) {
        var tabs = document.getElementsByClassName('tab');
        for (var i=0; i < tabs.length; i++) {
            tabs[i].style.display = 'none';
        }

        var menuItems = document.getElementsByClassName('tab-menu')[0].getElementsByTagName('li');
        for (var j=0; j < menuItems.length; j++) {
            menuItems[j].classList.remove('active');
        }

        document.getElementById(tabId).style.display = 'block';
        document.getElementById('menu-' + tabId).classList.add('active');
    }
</script>
</head>
<body>
	<div id="wrap">
	
		<div class="container">
        	<div class="image">
            	<img src="" alt="">
        	</div>
        	<div>
            	<h2>클래스 이름</h2>
            	<p>가격</p>
            	<div class="buttons">
            		<button class="heart-button">&#10084;</button>
                	<button class="apply-button">신청하기</button>
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
        			</div>
        			<div id="curriculum" class="tab">
        			</div>
        			<div id="instructor" class="tab">
        			</div>
        			<div id="location" class="tab">
        			</div>
        			<div id="reviews" class="tab">
        			</div>
        			<div id="inquiry" class="tab">
        			</div>
        		</div>
    		</div>
        </div>
	</div>
</body>
</html>