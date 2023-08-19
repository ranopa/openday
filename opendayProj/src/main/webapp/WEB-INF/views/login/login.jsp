<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/login.css"/>">
	
	<style type="text/css">
	
	  /* 모달 스타일 */
    .modalLogin {
        display: flex;
        justify-content: center;
        align-items: center;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        z-index: 9999;
    }

    .modal-content {
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        text-align: center; /* 가운데 정렬을 위한 설정 */
    }

    .modal-close {
        background-color: #E3E3E3;
        border: none;
        padding: 6px 12px;
        border-radius: 4px;
        cursor: pointer;
        margin-top:20px;
    }
	</style>
	
</head>
<body>

	<%@ include file="../header.jsp"%>
	<div class="loginWrapper">
		<div class="loginContentWrapper">
			<div class="loginPageTitleWrapper">

				<p class="loginPageTitle">로그인</p>
			</div>
			<form id="loginForm" action="login" method="post">
				<ul class="loginContainer">
					<li><input type="text" class="loginBox" id="userId"
						name="userId" placeholder="아이디"></li>
					<li><input type="password" class="loginBox pwBox"
						id="userPassword" name="userPassword" placeholder="비밀번호" ></li>
				</ul>

				<ul class="loginPageFind">
					<li><a href="findid">아이디 찾기</a></li>
					<li class="pwFindMenu"><a href="findpw">비밀번호 찾기</a></li>
				</ul>

				<div class="loginPageBtns">
					<input type="submit" class="loginBtn" value="로그인">
					
					<a href="joinform"> <input
						type="button" class="joinBtn" value="회원가입"></a>
				</div>


			</form>
		</div>
	</div>
	
	

    <c:if test="${loginFailed}">
        <!-- 로그인 실패 모달 -->
        <div id="loginFailModal" class="modalLogin">
            <div class="modal-content">
                <p>로그인에 실패했습니다.</p>
                <button class="modal-close">닫기</button>
            </div>
        </div>
    </c:if>
	<script>
	  var modal = document.getElementById("loginFailModal");
	    var closeBtn = document.getElementsByClassName("modal-close")[0];

	    // 모달 창 표시 여부 확인
	    var loginFailed = ${loginFailed};
	    if (loginFailed) {
	        modal.style.display = "flex";
	    }

	    // 모달 창 닫기 버튼 클릭 이벤트 처리
	    closeBtn.onclick = function() {
	        modal.style.display = "none";
	    }

	    // 모달 창 외부 클릭 시 닫기
	    window.onclick = function(event) {
	        if (event.target == modal) {
	            modal.style.display = "none";
	        }
	    }
</script>
	
	<%@ include file="../footer.jsp"%>
</body>
</html>