<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
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
        margin: 0;
    }
    
    #wrap {
        width: 1280px; 
        margin: 0 auto;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    
    .review-above {
        font-size: 24px;
        color: #5A2ECE;
        margin-left: 17px;
        margin-bottom: 25px;
        font-family: 'NanumBarunGothic', sans-serif;
    }
    
    .form-container {
        display: flex;
        margin-left: 20px;
    }
    
    .image-box {
        width: 200px;
        height: 220px;
        background-color: #D9D9D9;
        border: 1px solid #000000;
    }
    
    .form-fields {
    	width: 242px;
    	height: 385px;
    	margin-left: 20px;
    }
    
    .form-fields textarea {
    	width: 241px;
    	height: 130px;
        font-size: 14px;
        border: 1px solid #D9D9D9;
        margin-top: 48px;
    }
    
    .form-fields input[type="submit"] {
        background-color: #5A2ECE;
        color: white;
        font-size: 17px;
        padding: 10px 25px;
        border-radius: 5px;
        border: none;
        cursor: pointer;
        margin-top: 42%;
        margin-right: -2px;
    }       
    
    .complete-detail {
        display: flex;
        flex-direction: column;
        margin-top: 20px;
    }
    
    .complete-detail p {
        margin-bottom: 10px;
    }
    
    .complete-date {
    	font-size: 14px;
    }
    
    .compcla-name {
    	font-weight: bold;
    	border-bottom: 1px solid #000000;
        padding-bottom: 10px;
    }
    
    .complete-class {
        background-color: #F2F2F2;
        padding: 20px;
    }
    
	.stars {
 		width: 100%;
 		display: flex;
 		justify-content: center;
 	}
 
	.star-rating {
  		display: flex;
  		flex-direction: row-reverse;
  		font-size: 2.25rem;
  		line-height: 2.5rem;
  		justify-content: space-around;
  		padding: 0 0.2em;
  		text-align: center;
  		width: 5em;
	}
 
	.star-rating input {
  		display: none;
	}
 
	.star-rating label {
  		-webkit-text-fill-color: transparent;
  		-webkit-text-stroke-width: 2.3px;
  		-webkit-text-stroke-color: yellow;
  		cursor: pointer;
  		margin-top: 18px;
  		margin-right: 10px;
	}
 
	.star-rating :checked ~ label {
  		-webkit-text-fill-color: yellow;
	}
 
	.star-rating label:hover,
	.star-rating label:hover ~ label {
  		-webkit-text-fill-color: yellow;
	}    

	#content {
		resize: none;
	}
	
	#content:focus {
		outline: none;
	}

	.rev-complete {
		width: 100%;
		height: 36%;
		display: flex;
		flex-direction: row-reverse;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
	<div id="wrap">
		<form action="${contextPath}/reviewwrite" method="POST">
			<input type="hidden" name="scdNum" value="${param.scdNum}"/>
			<br/>
			<h1 class="review-above">후기</h1>&nbsp;&nbsp;
			<div class="form-container">
				<div class="complete-class">
					<div class="image-box"><img src="${contextPath}/img/${param.filNum}" width="100%" height="100%"></div>
            		<div class="complete-detail">
                		<p class="complete-date">${param.strDate}</p>
                		<p class="compcla-name">${param.clsName}</p>
                		<p class="compcla-price">${param.apFinalAmount}</p>
            		</div>
        		</div>
				
				<div class="form-fields">
					<table>
        				<tr>
            				<td class="stars">
								<div class="star-rating space-x-4 mx-auto">
									<input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
									<label for="5-stars" class="star pr-4">★</label>
									<input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
									<label for="4-stars" class="star">★</label>
									<input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
									<label for="3-stars" class="star">★</label>
									<input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
									<label for="2-stars" class="star">★</label>
									<input type="radio" id="1-star" name="rating" value="1" v-model="ratings" checked/>
									<label for="1-star" class="star">★</label>
								</div>            				
      							<input type="hidden" name="star" id="star" required placeholder="별점">
            				</td>
        				</tr>
						<tr>
							<td>
								<textarea name="content" id="content" placeholder="한줄평"></textarea>
							</td>
						</tr>
					</table>
					<div class="rev-complete">
						<input type="submit" value="후기 작성" class="submit-button">
					</div>
				</div>
			</div>
		</form>
	</div>
    <%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>