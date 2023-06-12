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
		margin-left: -50px;
	}
	
    .rw-above {
        font-size: 24px;
        color: #5A2ECE;
        margin-bottom: 20px;
        text-align: center;
        margin-right: 340px;
    }

    table {
        width: 50%;
        margin: 0 auto;   
    }

    th {
        text-align: left;
        vertical-align: top;
        font-weight: normal;
        font-size: 14px;
        color: #FF99B8;
    }

    td {
        vertical-align: top;
    }

    label {
        display: block;
        font-weight: normal;
        font-size: 14px;
        color: #FF99B8;
        margin-bottom: 5px;
    }

    input[type="text"] {
        width: 120%;
        padding: 5px;
        font-size: 14px;
        border: 1px solid #FF99B8;
        margin-bottom: 10px;
    }
    
    textarea {
    	width: 120%;
    	height: 300px;
        padding: 5px;
        font-size: 14px;
        border: 1px solid #FF99B8;
        margin-bottom: 10px;
    }
    
    .main-con {
    	width: 1000px;
    	margin: 0 auto;
    }
    
     .form-container { 
     	display: flex;
     	justify-content: flex-end;
     	width: 500px; 
     	margin: 0 auto; 
    }
    
    .submit-button {   
    	width: 100px;
    	margin-right: -110px;
    }
    
    input[type="submit"] {
        background-color: #5A2ECE;
        color: white;
        font-size: 14px;
        padding: 5px 15px;
        border-radius: 5px;
        border: none;
        cursor: pointer;
    }
    
    #content {
		resize: none;
	}
	
	#content:focus, #location:focus, #title:focus {
		outline: none;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
	<div id="wrap">
	
	<form method="post" action="requestwrite">
	
	
	<div class="main-con">
	<h1 class="rw-above">클래스 개설 요청</h1>&nbsp;&nbsp;
		<table>
        	<tr>
            	<td>
                 	<input type="text" name="location" id="location" required placeholder="원하는 클래스 진행의 지역을 대략적으로 적어주세요. (예)서울시 강남구">
            	</td>
        	</tr>
			<tr>
				<td>
					<input type="text" name="title" id="title" required placeholder="제목">
				</td>
			</tr>
			<tr>
				<td>
					<textarea name="content" id="content" placeholder="요청 내용"></textarea>
				</td>
			</tr>
		</table>
		&nbsp;&nbsp;
		<div class="form-container">
			<input type="submit" value="작성 완료" class="submit-button">
		</div>
	</div>
	</form>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>