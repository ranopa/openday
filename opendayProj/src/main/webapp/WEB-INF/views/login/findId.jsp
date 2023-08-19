<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/js/user/findId.js"/>'></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/findId.css"/>">
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<script type="text/javascript">
	$(function() {
		let authenConfirm = false;
		var code = "";
    	$("#emailChkForId").click(function(e){
    		e.preventDefault();
       		$.ajax({
            	type:"POST",
            	url:"emailChkForId",
            	data:{userEmail:$("#userEmail").val()},       
	            cache : false,
            	success:function(data){
               		if(data == "error"){
                  		alert("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.");
               		}else{                 
                		alert("인증번호 발송이 완료되었습니다.\n입력한 이메일에서 인증번호 확인을 해주십시오.");
                  		code = data;
                  		authenConfirm = true;
               		}
            	 }
        	});
    	});
    
    $("#idFindConfirm").click(function(e) {
    	if(authenConfirm==false || $("#idFindAuthenNum").val()!=code) {
    		alert("인증번호를 확인하세요.");
    		e.preventDefault();
    	}
    })
    
    
	})
	
	</script>
	
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="findIdWrapper">
		<div class="findIdContentWrapper">
			<div class="findIdPageTitleWrapper">
				<p class="findIdPageTitle">아이디/비밀번호 찾기</p>
			</div>
			<ul class="findMenu">
				<li><a href="findid">아이디 찾기</a></li>
				<li class="pwFindMenu"><a href="findpw">비밀번호 찾기</a></li>
			</ul>
			<form action="findid" method="post">
			<ul class="findIdContainer">
				<li>
				<div class="AuthenticationNumberWrapper">
				<input type="text" class="findIdPEmailBox"
					id="userEmail" name="userEmail" placeholder="이메일"
					>
					<input
						type="button" class="AuthenticationNumber"
						id="emailChkForId" value="이메일인증">
					</div>
					</li>
				
					<li><input type="text" class="AuthenticationNumberBox"
						id="idFindAuthenNum" name="AuthenticationNumberBox"
						placeholder="인증번호"> </li> 
				
			</ul>


			<div class="findIdBtns">
				<input type="submit" class="findIdBtn" id="idFindConfirm" value="확인">
			</div>
			
			</form>
			<!-- 
			<div class="loginBtns">
				<button type="button" class="cancel-btn">취소</button>
				<button type="submit" class="submit-btn">가입완료</button>
			</div>

 -->
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>