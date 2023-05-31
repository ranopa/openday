<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		padding: 0;
		margin: 0;
	}
	
	#wrap {
		width: 1280px;
	}
	
    h1 {
        font-family: Gothic;
        font-size: 24px;
        color: #5A2ECE;
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
        width: 100%;
        padding: 5px;
        font-size: 14px;
        border: 1px solid #FF99B8;
    }
    
    textarea {
    	width: 100%;
    	height: 300px;
        padding: 5px;
        font-size: 14px;
        border: 1px solid #FF99B8;
    }
    
    .main-con{
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
    	margin-right: -9px;
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
</style>
</head>
<body>
	<div id="wrap">
	
	<form method="post" action="requestwrite">
	
	
	<div class="main-con">
	<h1>클래스 개설 요청</h1>&nbsp;&nbsp;
		<table>
        	<tr>
            	<td>
                 	<input type="text" name="location" id="location" required placeholder="(예)서울시 강남구">
            	</td>
        	</tr>
			<tr>
				<td>
					<input type="text" name="title" id="title" required placeholder="제목">
				</td>
			</tr>
			<tr>
				<td>
					<textarea name="content" id="content" placeholder="내용"></textarea>
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
</body>
</html>