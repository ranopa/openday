<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/js/user/findPw.js"/>'></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/findPw.css"/>">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		let authenConfirm = false;
	var code = "";
    $("#emailChk").click(function(e){
    	e.preventDefault();
       var sm_email = $("#email").val();
       console.log(sm_email)
       $.ajax({
            type:"GET",
            url:"mailCheck",
            data:{userId:$("#userId").val(), sm_email:sm_email},
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
    
    $("#confirm").click(function(e) {
    	if(authenConfirm==false || $("#authenNum").val()!=code) {
    		alert("인증번호를 확인하세요.");
    		e.preventDefault();
    	}
    })
    
    
	})
	
	</script>

</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="findPwWrapper">
		<div class="findPwContentWrapper">
			<div class="findPwPageTitleWrapper">
				<p class="findPwPageTitle">아이디/비밀번호 찾기</p>
			</div>
			<ul class="findMenu">
				<li><a href="findid">아이디 찾기</a></li>
				<li class="pwFindMenu"><a href="findpw">비밀번호 찾기</a></li>
			</ul>
			<form action="findpw" method="post">
				<ul class="findPwContainer">
					<li><input type="text" class="findPwPIdBox" id="userId"
						name="userId" placeholder="아이디"></li>
					<li>
					<div class="AuthenticationNumberWrapper">
						<input type="text" class="findPwPEmailBox" id="email" name="userEmail" placeholder="이메일">
						<input type="button" class="AuthenticationNumber" id="emailChk"	value="이메일인증">
					</div>
					</li>
					<li>
						<input type="text" class="AuthenticationNumberBox" id="authenNum" name="AuthenticationNumberBox" placeholder="인증번호"> 
					</li>
				</ul>
				<div class="findPwBtns">
					<input type="submit" class="findPwBtn" id="confirm" value="확인">
				</div>
			</form>

		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>