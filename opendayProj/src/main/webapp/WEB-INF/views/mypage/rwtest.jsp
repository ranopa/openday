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
        margin: 0;
    }
    
    #wrap {
        width: 1280px; 
        margin: 0 auto;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    
    h1 {
        font-size: 24px;
        color: #5A2ECE;
        margin-left: 17px;
        margin-bottom: 25px;
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
    	margin-left: 20px;
    }
    
    .form-fields input[type="text"] {
        width: 180%;
        height: 30px;
        padding: 5px;
        font-size: 14px;
        border: 1px solid #D9D9D9;
        margin-bottom: 40px;
        margin-top: 40px;
    }
    
    .form-fields textarea {
    	width: 180%;
    	height: 130px;
        padding: 5px;
        font-size: 14px;
        border: 1px solid #D9D9D9;
        margin-bottom: 10px;
    }
    
    .form-fields input[type="submit"] {
        background-color: #5A2ECE;
        color: white;
        font-size: 17px;
        padding: 10px 25px;
        border-radius: 5px;
        border: none;
        cursor: pointer;
        margin-left: 214.5px;
        margin-top: 49.5px;
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
</style>
</head>
<body>
	<div id="wrap">
		<form>
			<h1>후기</h1>&nbsp;&nbsp;
			<div class="form-container">
				<div class="complete-class">
					<div class="image-box"><img src=""></div>
            		<div class="complete-detail">
                		<p class="complete-date">수강일자</p>
                		<p class="compcla-name">클래스 이름</p>
                		<p class="compcla-price">가격</p>
            		</div>
        		</div>
				
				<div class="form-fields">
					<table>
        				<tr>
            				<td>
                 				<input type="text" name="star" id="star" required placeholder="별점">
            				</td>
        				</tr>
						<tr>
							<td>
								<textarea name="content" id="content" placeholder="한줄평"></textarea>
							</td>
						</tr>
					</table>
					<div>
						<input type="submit" value="후기 작성" class="submit-button">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>