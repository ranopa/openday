<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/follow.css"/>">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/js/user/follow.js"></script>
</head>
<body>
 <div id="follow">
        <div class="wrap">
            <h2 class="f-h2">
                팔로우 목록
            </h2>
            <c:forEach items="${tchcList}" var="tchc"> 
	            <a href="" class="abox">
	                <div class="mybox2 square">
	                    <img src = "img/${tchc.filNum}"class="f-img">
	                    <div class="mymenu-txt">
	                        <p class="mymenu2 mini-txt">follower <span>${tchc.tchcFollower}</span></p>
	                        <p class="mymenu1">${tchc.tchcNickname}</p>
	                        <div class="mymenu2">
	                            <p class="intro-txt">
	                                ${tchc.tchcIntro}
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </a>
              </c:forEach>
        </div>
    </div>  
</body>
</html>