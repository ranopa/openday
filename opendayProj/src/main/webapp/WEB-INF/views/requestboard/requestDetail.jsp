<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    let participateCount = 0;
    
    function participate() {
        if (participateCount === 0) {
            participateCount++;
            document.getElementById("participationButton").textContent = "참여("+participateCount+")";
        }
    }
</script>
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
    }
    
    .rd-above {
        font-size: 24px;
        color: #5A2ECE;
        margin-bottom: 20px;
        margin-left: 55px;
    }

    .rtable table {
        width: 70%;
        margin: 0 auto;  
    }

    .rtable th {
        text-align: left;
        vertical-align: top;
        font-weight: normal;
        font-size: 14px;
        color: #D9D9D9;
    }

    .rtable td {
        vertical-align: top;
        margin:0 auto;
    }
    
    .f {
    	padding-top: 5px;
    	width: 50px;    
    }

/*     label {
        display: block;
        font-weight: normal;
        font-size: 14px;
        color: #D9D9D9;
        margin-bottom: 5px;
    } */

    .rtable input[type="text"] {
        width: 900px;
        padding: 5px;
        font-size: 14px;
        border: 1px solid #D9D9D9;
        margin-bottom: 10px;
    }
    
    .rtable textarea {
        width: 900px;
        height: 300px;
        padding: 5px;
        font-size: 14px;
        border: 1px solid #D9D9D9;
        margin-bottom: 10px;
    }
    
    .main-con {
        width: 1000px;
        margin: 0 auto; 
    }
    
    .form-container {
        display: flex;
        justify-content: flex-end;       
    }
    
    .submit-button {
        width: 95px;
        margin-right: 5px;
    }
    
    .participation-button {
    	width: 80px; 
    	margin-left: 52px;
    }
    
    .buttons input[type="submit"] {
        background-color: #5A2ECE;
        color: white;
        height: 30px;
        font-size: 14px;
        padding: 5px 15px;
        border-radius: 5px;
        border: none;
        cursor: pointer;
    }
    
    .participation-button Button[type="button"] {
    	background-color: white;
    	color: #FF99B8;
    	font-size: 14px;
    	padding: 5px 15px;
    	border-radius: 5px;
    	border: 1px solid #FF99B8;
    }
    
    .buttons {
    	display: flex;
    	width: 95%;
    	margin: 0 auto; 
    	flex-direction: row-reverse;
    	justify-content: space-between;
    	position: relative;
    }  
    
    #reqContent {
    	resize: none;
    }
    
    #reqContent:focus, #reqLocation:focus, #reqTitle:focus {
    	outline: none;
    }
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	if('${partpaYN}'==1) {
		$("#participationBtn").css('backgroundColor','#FF99B8');
		$("#participationBtn").css('color','white');
	} else {
		$("#participationBtn").css('backgroundColor','white');
		$("#participationBtn").css('color','#FF99B8');
	}
	
	$("#modifyBtn").click(function(e){
		e.preventDefault();
		$.ajax({
			url:"modrequest",
			method:"POST",
			async:true,
			data:{
				reqId:$("#reqId").val(),
				reqLocation:$("#reqLocation").val(),
				reqTitle:$("#reqTitle").val(),
				reqContent:$("#reqContent").val()
			},
			success:function(result) {
				alert(result.responseText);
			},
			error:function(result) {
				alert(result.responseText);
			}
		})
	});
	
	$("#deleteBtn").click(function(e){
		var frm=$(document.forms[0]);
		frm.attr("action", "delrequest");	
		frm.attr("method", "GET");
		frm.submit();
		
	});
	
	$("#requestlistBtn").click(function(e){
		e.preventDefault();
		location.href="./requestlist"
		
	});	
	
	$("#participationBtn").click(function(e) {
		$.ajax({
			url:'participation',
			method:'POST',
			async:true,
			data:{reqId:$("#reqId").val()},
			success:function(result) {
				console.log(result)
				if(result==="true") {	
					$("#participationCnt").text(+$("#participationCnt").text()+1);
					$("#participationBtn").css('backgroundColor','#FF99B8');
					$("#participationBtn").css('color','white');
				} else {
					$("#participationCnt").text(+$("#participationCnt").text()-1);
					$("#participationBtn").css('backgroundColor','white');
					$("#participationBtn").css('color','#FF99B8');
				}
			},
			error:function(result) {
				
			}
		})
	})
})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
    <div id="wrap">
    
    <form method="get" action="${contextPath}/delrequest">
    <div class="main-con">
    <br/>
    <h1 class="rd-above">클래스 개설 요청</h1>&nbsp;&nbsp;
    <input type="hidden" id="reqId" name="reqId" value="${request.reqId }"/>
        <table class="rtable">
            <tr>
                <td class="f">지역</td>
                <td><input name="reqLocation" type="text" id="reqLocation" value="${request.reqLocation }"/></td>
            </tr>
            <tr>
                <td class="f">제목</td>
                <td><input name="reqTitle" type="text" id="reqTitle" value="${request.reqTitle }"/></td>
            </tr>
            <tr>
                <td class="f">내용</td>
                <td><textarea name="reqContent" id="reqContent">${request.reqContent }</textarea></td>
            </tr>            
        </table>
        &nbsp;&nbsp;
        <div class="buttons">
           	<div class="form-container">
        	<c:if test="${userId.authority eq '2'}">
	    	    <input type="submit" onclick="window.location.href='${contextPath}/classOpen'" value="클래스 개설" class="submit-button">
        	</c:if>
        	<c:if test="${userId.userId eq request.userId }">
	        	<input type="submit" id="modifyBtn" value="수정" class="submit-button" style="margin-right: 10px;">
        	   	<input type="submit" id="deleteBtn" value="삭제" class="submit-button" style="margin-right: 10px;">
        	</c:if>
        	   	<input type="submit" id="requestlistBtn" value="목록" class="submit-button" style="margin-right: 22px;"/>
           	</div>
        <%-- 	<c:choose>
        		<c:when test="${userId.authority eq '2'}">
	        		<div class="form-container">
        	    	<input type="submit" onclick="window.location.href='${contextPath}/classOpen'" value="클래스 개설" class="submit-button">
        	    	<input type="submit" value="목록" class="submit-button"/>
        			</div>
        		</c:when>
        		<c:otherwise>
        			<c:if test="${userId.userId eq request.userId }">
	        		<div class="form-container">
     	       		<input type="submit" id="modifyBtn" value="수정" class="submit-button" style="margin-right: 10px;">
        	   		<input type="submit" id="deleteBtn" value="삭제" class="submit-button" style="margin-right: 10px;">
        	   		<input type="submit" id="requestlistBtn" value="목록" class="submit-button" style="margin-right: 22px;"/></div>
        	   		</c:if>        		
        		</c:otherwise>
        	</c:choose> --%>
        	<div class="participation-button">
        		<button type="button" id="participationBtn">참여&nbsp;&nbsp;<span id="participationCnt">${partpaCnt }</span></button>
        	</div>
        </div>
    </div>
    </form>
    </div>
    <%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>